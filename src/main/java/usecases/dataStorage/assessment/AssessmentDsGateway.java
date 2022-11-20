package usecases.dataStorage.assessment;

public interface AssessmentDsGateway {
    boolean existsAssessment(AssessmentDsRequestModel requestModel);
    AssessmentDsResponseModel loadAssessment(AssessmentDsRequestModel requestModel);
}
