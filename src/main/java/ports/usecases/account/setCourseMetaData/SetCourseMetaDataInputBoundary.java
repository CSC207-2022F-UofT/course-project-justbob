package ports.usecases.account.setCourseMetaData;

public interface SetCourseMetaDataInputBoundary {
    /**
     * @param request the path to the Course and the courseCode, courseName, and credit to set
     * @return the courseCode, courseName, and credit that was set
     * @throws ports.usecases.PathNotFoundError if the path to the Course does not exist
     * @throws SetCourseMetaDataInputBoundary.SetCourseMetaDataError if the new courseCode, courseName, or credit is invalid
     */

    public SetCourseMetaDataResponse execute(SetCourseMetaDataRequest request)
            throws ports.usecases.PathNotFoundError, SetCourseMetaDataInputBoundary.SetCourseMetaDataError;

    public class SetCourseMetaDataError extends Error {
        public SetCourseMetaDataError(String message) {
            super(message);
        }
    }
}
