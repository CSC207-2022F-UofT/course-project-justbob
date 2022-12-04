package ports.usecases.account.RemoveSemesterCourse;

public interface RemoveSemesterCourseInputBoundary {
    /**
     * Remove an existing course from the user's account's semester.
     * @param request the user input required for this usecase
     * @throws CourseDoesNotExistsError if the course requested does not exist in semester
     */
    void execute(RemoveSemesterCourseRequest request) throws CourseDoesNotExistsError;

    class CourseDoesNotExistsError extends Error{}
}
