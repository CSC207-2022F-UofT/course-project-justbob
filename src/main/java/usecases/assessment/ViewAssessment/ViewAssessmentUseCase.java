package usecases.assessment.ViewAssessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.viewAssessment.ViewAssessmentInputBoundary;
import ports.usecases.assessment.viewAssessment.ViewAssessmentRequest;
import ports.usecases.assessment.viewAssessment.ViewAssessmentResponse;

public class ViewAssessmentUseCase implements ViewAssessmentInputBoundary {

    private final EntityGateway entityGateway;

    public ViewAssessmentUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public ViewAssessmentResponse execute(ViewAssessmentRequest request) {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);
        if (course == null) {
            throw new PathNotFoundError();
        }
        Assessment assessment = course.getOutline().getAssessmentByTitle(request.assessmentTitle);
        if (assessment == null) {
            throw new PathNotFoundError();
        }
        return createResponse(assessment, account);
    }

    private ViewAssessmentResponse createResponse(Assessment assessment, Account account) {
        ViewAssessmentResponse response = new ViewAssessmentResponse();
        response.username = account.getUsername();
        response.courseCode = account.getSemester().getCourseByCode(response.courseCode).getCourseCode();
        response.assessmentTitle = assessment.getTitle();
        response.assessmentInstanceTitles = new String[assessment.getInstances().size()];
        for (int i = 0; i < assessment.getInstances().size(); i++) {
            response.assessmentInstanceTitles[i] = assessment.getInstances().get(i).getTitle();
        }
        response.assessmentInstanceWeights = new Double[assessment.getInstances().size()];
        for (int i = 0; i < assessment.getInstances().size(); i++) {
            response.assessmentInstanceWeights[i] = assessment.getWeightScheme().getTotalWeight()/assessment.getInstances().size();
        }
        response.assessmentInstanceMarks = new Double[assessment.getInstances().size()];
        for (int i = 0; i < assessment.getInstances().size(); i++) {
            response.assessmentInstanceMarks[i] = assessment.getInstances().get(i).getMark();
        }
        return response;
    }



}
