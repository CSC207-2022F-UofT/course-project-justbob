package ports.usecases.archiveCourse;

import ports.usecases.PathNotFoundError;

public interface ArchiveCourseInputBoundary {
    /**
     * Send a course to this account's archive. The course must be completed (i.e., all instances are committed)
     * @param username the username of the account
     * @param courseCode the courseCode
     * @throws PathNotFoundError if the username or courseCode do not exist
     * @throws CourseNotCompletedError if the course still has uncommitted instances.
     */
    void execute(String username, String courseCode) throws PathNotFoundError, CourseNotCompletedError;

    //TODO: specify which instances are not committed (this may warrant a response model.)
    class CourseNotCompletedError extends Error {}
}
