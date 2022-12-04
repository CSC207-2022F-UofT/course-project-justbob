package usecases.assessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.course.Course;
import entities.weightScheme.SimpleWeight;
import entities.weightScheme.Weight;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.setWeightScheme.SetSimpleWeightSchemeInputBoundary;
import ports.usecases.assessment.setWeightScheme.SetSimpleWeightSchemeRequest;
import ports.usecases.assessment.setWeightScheme.SetSimpleWeightSchemeResponse;

import java.util.ArrayList;

public class SetSimpleWeightSchemeUseCase implements SetSimpleWeightSchemeInputBoundary {

    private EntityGateway entityGateway;

    public SetSimpleWeightSchemeUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public SetSimpleWeightSchemeResponse execute(SetSimpleWeightSchemeRequest request) throws
            SetSimpleWeightSchemeInputBoundary.SetSimpleWeightSchemeError {

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

        if (request.numberOfInstances < 1) {
            throw new SetSimpleWeightSchemeInputBoundary.SetSimpleWeightSchemeError("Number of instances must be greater than 0");
        }
        if (request.weightOfEachInstance < 0 || request.weightOfEachInstance == 0) {
            throw new SetSimpleWeightSchemeInputBoundary.SetSimpleWeightSchemeError("Weight of each instance must be greater than 0");
        }
        if (request.weightOfEachInstance > 1) {
            throw new SetSimpleWeightSchemeInputBoundary.SetSimpleWeightSchemeError("Weight of each instance must be less than or equal to 1");
        }
        if (request.numberOfInstances * request.weightOfEachInstance > 1) {
            throw new SetSimpleWeightSchemeInputBoundary.SetSimpleWeightSchemeError("Total weight of instances must be less than or equal to 1");
        }

        SimpleWeight weightscheme = new SimpleWeight(new Weight(request.numberOfInstances, request.weightOfEachInstance));

        assessment.setWeightScheme(weightscheme);
        entityGateway.saveAccount(account);

        return createResponse(assessment);

    }

    private SetSimpleWeightSchemeResponse createResponse(Assessment assessment) {
        SetSimpleWeightSchemeResponse response = new SetSimpleWeightSchemeResponse();
        response.totalWeight = assessment.getWeightScheme().getTotalWeight();
        response.maximumNumberOfInstances = assessment.getWeightScheme().getNumberOfInstances();
        return response;
    }
}
