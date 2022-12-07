package ports.usecases.course.viewCourse;

public class ViewCourseRequest {
    public String username;
    public String courseCode;

    public ViewCourseRequest() {
    }

    public ViewCourseRequest(String username, String courseCode) {
        this.username = username;
        this.courseCode = courseCode;
    }
}

