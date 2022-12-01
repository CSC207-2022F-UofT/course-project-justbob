package ports.usecases.account.RemoveSemesterCourse;

public interface RemoveSemesterCourseInputBoundary {
    /**
     * Remove an existing course from the user's account's semester.
     * @param username
     * @param request
     * @throws CourseDoesNotExistsError if the course requested does not exist in semester
     */
    void execute(String username, RemoveSemesterCourseRequest request) throws CourseDoesNotExistsError;

    class CourseDoesNotExistsError extends Error{}
}
