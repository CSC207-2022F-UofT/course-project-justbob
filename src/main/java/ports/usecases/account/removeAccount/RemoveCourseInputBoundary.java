package ports.usecases.account.removeAccount;

import entities.course.Course;
import ports.usecases.PathNotFoundError;

public interface RemoveCourseInputBoundary {
    /**
     * Send remove a course from this account's archive.
     * @param username the username of the account
     * @param courseCode the courseCode
     * @throws PathNotFoundError if the username or courseCode do not exist
     */

    void execute(String username, Course course) throws PathNotFoundError;
}
