package usecases.dataStorage.assessment;

public interface AssessmentDsGateway {
    boolean existsAssessment(AssessmentDsRequestModel requestModel);
    AssessmentDsModel loadAssessment(AssessmentDsRequestModel requestModel) throws NoSuchFieldException;
}
