package usecases.assessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.commitMarkUseCase.CommitMarkInputBoundary;
import ports.usecases.assessment.commitMarkUseCase.CommitMarkRequest;
import ports.usecases.assessment.commitMarkUseCase.CommitMarkResponse;
import ports.usecases.assessment.commitMarkUseCase.CommitMarkInputBoundary;

import java.util.ArrayList;

public class CommitMarkUseCase implements CommitMarkInputBoundary {

    private EntityGateway entityGateway;

    public CommitMarkUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public CommitMarkResponse execute(CommitMarkRequest request)
            throws ports.usecases.PathNotFoundError, CommitMarkInputBoundary.CommitMarkError {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

        ArrayList<String> assessmentTitles = course.getOutline().getAssessmentsTitles();
        if (!assessmentTitles.contains(request.assessmentTitle)) {
            throw new PathNotFoundError();
        }
        Assessment assessment = course.getOutline().getAssessmentByTitle(request.assessmentTitle);

        if (request.instanceNumber >= assessment.getInstances().size()) {
            throw new PathNotFoundError();
        }

        AssessmentInstance assessmentInstance = assessment.getInstances().get(request.instanceNumber);


        if (!assessmentInstance.isSubmitted()) {
            throw new CommitMarkInputBoundary.CommitMarkError("Assessment must be submitted before it can be committed");
        }
        if (assessmentInstance.isCommitted()) {
            throw new CommitMarkInputBoundary.CommitMarkError("Assessment already committed");
        }
        if (assessmentInstance.getMark() == null) {
            throw new CommitMarkInputBoundary.CommitMarkError("Assessment must have a mark before it can be committed");
        }

        assessmentInstance.setCommitted(true);
        return createResponse(assessmentInstance);
    }
    private CommitMarkResponse createResponse(AssessmentInstance assessmentInstance) {
        CommitMarkResponse response = new CommitMarkResponse();
        response.commitSuccessful = true;
        return response;
    }
    }