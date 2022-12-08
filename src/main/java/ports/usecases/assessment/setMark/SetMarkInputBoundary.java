package ports.usecases.assessment.setMark;

public interface SetMarkInputBoundary {
    /**
     * @param request the path to the AssessmentInstance and the mark to set
     * @return the mark that was set
     * @throws ports.usecases.PathNotFoundError  if the path to the AssessmentInstance does not exist
     * @throws SetMarkInputBoundary.SetMarkError if the mark is invalid
     */

    public SetMarkResponse execute(SetMarkRequest request)
            throws ports.usecases.PathNotFoundError, SetMarkInputBoundary.SetMarkError;

    public class SetMarkError extends Error {
        public SetMarkError(String message) {
            super(message);
        }
    }
}
