package usecases.assessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.course.Course;
import entities.weightScheme.SimpleWeight;
import entities.weightScheme.Weight;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.addSimpleAssessment.AddSimpleAssessmentInputBoundary;
import ports.usecases.assessment.addSimpleAssessment.AddSimpleAssessmentRequest;
import ports.usecases.assessment.addSimpleAssessment.AddSimpleAssessmentResponse;

public class AddSimpleAssessmentUseCase implements AddSimpleAssessmentInputBoundary {

    private EntityGateway entityGateway;

    private Assessment.AssessmentFactory assessmentFactory;

    public AddSimpleAssessmentUseCase(EntityGateway entityGateway, Assessment.AssessmentFactory assessmentFactory) {
        this.entityGateway = entityGateway;
        this.assessmentFactory = assessmentFactory;
    }

    public AddSimpleAssessmentResponse execute(AddSimpleAssessmentRequest request)
            throws AddAssessmentError, AddWeightSchemeError, PathNotFoundError {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

        if (course == null) {
            throw new PathNotFoundError();
        }

        if (course.getOutline().getAssessmentsTitles().contains(request.assessmentTitle)){
            throw new AddAssessmentError();
        }


        if(request.numberOfInstances < 1){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Number of instances must be greater than 0");
        }
        if(request.weightOfEachInstance < 0 || request.weightOfEachInstance == 0){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Weight of each instance must be greater than 0");
        }
        if(request.weightOfEachInstance > 1){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Weight of each instance must be less than or equal to 1");
        }
        if(request.numberOfInstances * request.weightOfEachInstance > 1){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Total weight of instances must be less than or equal to 1");
        }

        SimpleWeight weightScheme = new SimpleWeight(new Weight(request.numberOfInstances, request.weightOfEachInstance));

        Assessment assessment = assessmentFactory.createAssessment(request.assessmentTitle, weightScheme);

        course.getOutline().addAssessment(assessment);
        entityGateway.saveAccount(account);
        return createResponse(assessment);

    }

    private AddSimpleAssessmentResponse createResponse(Assessment assessment) {
        AddSimpleAssessmentResponse response = new AddSimpleAssessmentResponse();
        response.totalWeight = assessment.getWeightScheme().getTotalWeight();
        response.maximumNumberOfInstances = assessment.getWeightScheme().getNumberOfInstances();
        return response;
    }
}
