package ports.usecases.account.addSemesterCourse;

import ports.usecases.account.RemoveSemesterCourse.RemoveSemesterCourseInputBoundary;

public interface AddSemesterCourseInputBoundary {
    /**
     * add a new course to the current semester of the user's account
     * @param username the user's account username
     * @param request a request for a new course with the course's courseCode, courseName, and credit
     * @throws CourseAlreadyExistsError if the course requested is already in semester
     */
    void execute(String username, AddSemesterCourseRequest request) throws CourseAlreadyExistsError;

    class CourseAlreadyExistsError extends Error{}
}
