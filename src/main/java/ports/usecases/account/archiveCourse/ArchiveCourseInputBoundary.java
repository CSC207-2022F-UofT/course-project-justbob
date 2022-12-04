package ports.usecases.account.archiveCourse;

import ports.usecases.PathNotFoundError;

public interface ArchiveCourseInputBoundary {
    /**
     * Send a course to this account's archive. The course must be completed (i.e., all instances are committed)
     * @param username the username of the account
     * @param courseCode the courseCode
     * @throws PathNotFoundError if the username or courseCode do not exist
     */
    void execute(String username, String courseCode) throws PathNotFoundError;
}
