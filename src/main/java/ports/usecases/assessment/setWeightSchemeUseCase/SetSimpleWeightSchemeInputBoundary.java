package ports.usecases.assessment.setWeightSchemeUseCase;

import ports.usecases.PathNotFoundError;
import ports.usecases.assessment.addSimpleAssessmentUseCase.AddSimpleAssessmentInputBoundary;
import ports.usecases.assessment.addSimpleAssessmentUseCase.AddSimpleAssessmentRequest;
import ports.usecases.assessment.addSimpleAssessmentUseCase.AddSimpleAssessmentResponse;

public interface SetSimpleWeightSchemeInputBoundary {
    /**
     * Set a Simple WeightScheme for an Assessment
     * @param request the path to the Assessment, the number of instances, and the weight of each instance
     * @return preliminary weightscheme data of assessment
     * @throws SetSimpleWeightSchemeInputBoundary.SetSimpleWeightSchemeError if the Assessment's weightscheme is invalid
     * @throws ports.usecases.PathNotFoundError if the path to the Assessment does not exist
     */

    public SetSimpleWeightSchemeResponse execute (SetSimpleWeightSchemeRequest request)
            throws AddSimpleAssessmentInputBoundary.AddWeightSchemeError, ports.usecases.PathNotFoundError;

    public class SetSimpleWeightSchemeError extends Error {
        public SetSimpleWeightSchemeError(String message) {
            super(message);
        }
    }
}
