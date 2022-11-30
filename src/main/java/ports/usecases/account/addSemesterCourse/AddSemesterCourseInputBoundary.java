package ports.usecases.account.addSemesterCourse;

public interface AddSemesterCourseInputBoundary {
    /**
     * add a new course to the current semester of the user's account
     * @param username the user's account username
     * @param request a request for a new course with the course's courseCode, courseName, and credit
     */
    void execute(String username, AddSemesterCourseRequest request) throws CourseAlreadyExistsError;

    class CourseAlreadyExistsError extends Error{}
}
