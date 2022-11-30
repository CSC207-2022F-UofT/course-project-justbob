package ports.usecases.assessment.commitMarkUseCase;

import ports.usecases.assessment.setMarkUseCase.SetMarkInputBoundary;
import ports.usecases.assessment.setMarkUseCase.SetMarkRequest;
import ports.usecases.assessment.setMarkUseCase.SetMarkResponse;

public interface CommitMarkInputBoundary {
    /**
     * @param request the path to the AssessmentInstance to commit
     * @return the successful commit
     * @throws ports.usecases.PathNotFoundError if the path to the AssessmentInstance does not exist
     * @throws CommitMarkInputBoundary.CommitMarkError if the AssessmentInstance can't be committed
     */

    public CommitMarkResponse execute(CommitMarkRequest request)
            throws ports.usecases.PathNotFoundError, SetMarkInputBoundary.SetMarkError;

    public class CommitMarkError extends Error {
        public CommitMarkError(String message) {
            super(message);
        }
    }
}
