package ports.usecases.assessment.setInstanceMetaData;

public interface SetInstanceMetaDataInputBoundary {
    /**
     * @param request the path to the AssessmentInstance and the title and deadline to set
     * @return the title and deadline that was set
     * @throws ports.usecases.PathNotFoundError if the path to the AssessmentInstance does not exist
     * @throws SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError if the new title or deadline is invalid
     */

    public SetInstanceMetaDataResponse execute(SetInstanceMetaDataRequest request)
            throws ports.usecases.PathNotFoundError, SetInstanceMetaDataInputBoundary.SetInstanceMetaDataError;

    public class SetInstanceMetaDataError extends Error {
        public SetInstanceMetaDataError(String message) {
            super(message);
        }
    }
}
