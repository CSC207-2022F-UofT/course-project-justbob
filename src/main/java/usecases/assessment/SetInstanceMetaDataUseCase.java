package usecases.assessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.setInstanceMetaData.SetInstanceMetaDataInputBoundary;
import ports.usecases.assessment.setInstanceMetaData.SetInstanceMetaDataRequest;
import ports.usecases.assessment.setInstanceMetaData.SetInstanceMetaDataResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SetInstanceMetaDataUseCase implements SetInstanceMetaDataInputBoundary {

    private EntityGateway entityGateway;

    public SetInstanceMetaDataUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public SetInstanceMetaDataResponse execute(SetInstanceMetaDataRequest request)
            throws ports.usecases.PathNotFoundError, SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

        if (course == null) {
            throw new PathNotFoundError();
        }

        ArrayList<String> assessmentTitles = course.getOutline().getAssessmentsTitles();

        ArrayList<String> assessmentSingularTitles = course.getOutline().getAssessmentsSingularTitles();

        if (!assessmentTitles.contains(request.assessmentTitle)) {
            throw new PathNotFoundError();
        }
        Assessment assessment = course.getOutline().getAssessmentByTitle(request.assessmentTitle);

        if (request.instanceNumber > assessment.getInstances().size()) {
            throw new PathNotFoundError();
        }

        AssessmentInstance assessmentInstance = assessment.getInstances().get(request.instanceNumber);

        String oldTitle = assessmentInstance.getTitle();
        LocalDateTime oldDeadline = assessmentInstance.getDeadline();

        if (request.newTitle.length() > 30) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Title must be less than 30 characters");
        }

        if (assessmentSingularTitles.contains(request.newTitle)) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Title must not mimic another assessment");
        }

        if (request.newTitle.equals(oldTitle)) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Title must be different");
        }

        if (request.newTitle.equals("")) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Title must not be empty");
        }


        if (request.newDeadline.isEqual(oldDeadline)) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Deadline must be different");
        }

        if (request.newDeadline.isBefore(LocalDateTime.now())) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Deadline must be in the future");
        }


        assessmentInstance.setTitle(request.newTitle);
        assessmentInstance.setDeadline(request.newDeadline);

        entityGateway.saveAccount(account);

        return createResponse(assessmentInstance);
    }
    private SetInstanceMetaDataResponse createResponse(AssessmentInstance assessmentInstance) {
        SetInstanceMetaDataResponse response = new SetInstanceMetaDataResponse();
        response.newTitle = assessmentInstance.getTitle();
        response.newDeadline = assessmentInstance.getDeadline();
        return response;
    }
}
