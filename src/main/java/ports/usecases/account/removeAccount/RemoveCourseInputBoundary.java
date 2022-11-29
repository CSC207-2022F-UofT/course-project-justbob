package ports.usecases.account.removeAccount;

import entities.course.Course;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.archiveCourse.ArchiveCourseInputBoundary;

public interface RemoveCourseInputBoundary {
    /**
     * Send remove a course from this account's archive.
     * @param username the username of the account
     * @param courseCode the name of the course that the user wants to remove
     * @throws PathNotFoundError if the username or courseCode do not exist
     */

    void execute(String username, String courseCode) throws PathNotFoundError, ArchiveCourseInputBoundary.CourseNotCompletedError;
}
