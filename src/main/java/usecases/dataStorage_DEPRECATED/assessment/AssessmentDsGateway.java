package usecases.dataStorage_DEPRECATED.assessment;

public interface AssessmentDsGateway {
    boolean existsAssessment(AssessmentDsRequestModel requestModel);
    AssessmentDsModel loadAssessment(AssessmentDsRequestModel requestModel) throws IllegalArgumentException;
}
