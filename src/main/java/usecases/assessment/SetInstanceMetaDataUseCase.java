package usecases.assessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.setInstanceMetaDataUseCase.SetInstanceMetaDataInputBoundary;
import ports.usecases.assessment.setInstanceMetaDataUseCase.SetInstanceMetaDataRequest;
import ports.usecases.assessment.setInstanceMetaDataUseCase.SetInstanceMetaDataResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SetInstanceMetaDataUseCase implements SetInstanceMetaDataInputBoundary {

    private EntityGateway entityGateway;

    public SetInstanceMetaDataUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public SetInstanceMetaDataResponse execute(SetInstanceMetaDataRequest request)
            throws ports.usecases.PathNotFoundError, SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

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

        if (request.newTitle == null || request.newTitle.equals("")) {
            assessmentInstance.setTitle(oldTitle); /*if the user doesn't give any input, the old title remains. Somehow,
            the controller must allow for no input though.*/
        } else {
            assessmentInstance.setTitle(request.newTitle);
        }

        LocalDateTime newDeadlineFormatted = LocalDateTime.parse(request.newDeadline,
                java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));

        if (newDeadlineFormatted.isEqual(oldDeadline)) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Deadline must be different");
        }

        if (newDeadlineFormatted.isBefore(LocalDateTime.now())) {
            throw new SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError("Deadline must be in the future");
        }

        if (request.newDeadline == null || request.newDeadline.equals("")) {
            assessmentInstance.setDeadline(oldDeadline); /*if the user doesn't give any input, the old deadline remains.
            Somehow, the controller must allow for no input though.*/
        } else {
            assessmentInstance.setDeadline(newDeadlineFormatted);
        }

        return createResponse(assessmentInstance);
    }
    private SetInstanceMetaDataResponse createResponse(AssessmentInstance assessmentInstance) {
        SetInstanceMetaDataResponse response = new SetInstanceMetaDataResponse();
        response.newTitle = assessmentInstance.getTitle();
        response.newDeadline = assessmentInstance.getDeadline().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));
        return response;
    }
}
