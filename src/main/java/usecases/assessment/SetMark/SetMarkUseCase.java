package usecases.assessment.SetMark;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.setMark.SetMarkInputBoundary;
import ports.usecases.assessment.setMark.SetMarkRequest;
import ports.usecases.assessment.setMark.SetMarkResponse;

import java.util.ArrayList;

public class SetMarkUseCase implements SetMarkInputBoundary {

    private EntityGateway entityGateway;

    public SetMarkUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public SetMarkResponse execute(SetMarkRequest request)
            throws ports.usecases.PathNotFoundError, SetMarkInputBoundary.SetMarkError {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

        if (course == null) {
            throw new PathNotFoundError();
        }

        ArrayList<String> assessmentTitles = course.getOutline().getAssessmentsTitles();
        if (!assessmentTitles.contains(request.assessmentTitle)) {
            throw new PathNotFoundError();
        }
        Assessment assessment = course.getOutline().getAssessmentByTitle(request.assessmentTitle);

        if (request.instanceNumber > assessment.getInstances().size()) {
            throw new PathNotFoundError();
        }

        AssessmentInstance assessmentInstance = assessment.getInstances().get(request.instanceNumber);

        if (request.mark < 0 || request.mark > 100) {
            throw new SetMarkInputBoundary.SetMarkError("Mark must be between 0 and 100");
        }

        if (assessmentInstance.isCommitted()) {
            throw new SetMarkInputBoundary.SetMarkError("Cannot change mark of committed assessment");
        }
        assessmentInstance.setMark(request.mark);
        entityGateway.saveAccount(account);
        return createResponse(assessmentInstance);
    }
    private SetMarkResponse createResponse(AssessmentInstance assessmentInstance) {
        SetMarkResponse response = new SetMarkResponse();
        response.newHypotheticalMark = assessmentInstance.getMark();
        return response;
    }
    }


