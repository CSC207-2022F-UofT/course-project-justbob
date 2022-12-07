package usecases.assessment.AddSimpleAssessment;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.course.Course;
import entities.weightScheme.SimpleWeight;
import entities.weightScheme.Weight;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseInputBoundary;
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

        int numberOfInstances;
        try {
            numberOfInstances = Integer.parseInt(request.numberOfInstances);
        } catch (NumberFormatException ex) {
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Number of instances must be an integer");
        }

        double weightOfEachInstance;
        try {
            weightOfEachInstance = Double.parseDouble(request.weightOfEachInstance);
        } catch (NumberFormatException ex) {
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Weight of each instance must be a number between 0 and 1");
        }

        if(numberOfInstances < 1){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Number of instances must be greater than 0");
        }
        if(weightOfEachInstance < 0 || weightOfEachInstance == 0){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Weight of each instance must be greater than 0");
        }
        if(weightOfEachInstance > 1){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Weight of each instance must be less than or equal to 1");
        }
        if(numberOfInstances * weightOfEachInstance > 1){
            throw new AddSimpleAssessmentInputBoundary.AddWeightSchemeError("Total weight of instances must be less than or equal to 1");
        }

        SimpleWeight weightScheme = new SimpleWeight(new Weight(numberOfInstances, weightOfEachInstance));

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
