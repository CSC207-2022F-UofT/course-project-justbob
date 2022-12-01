package ports.usecases.account.RemoveSemesterCourse;

public class RemoveSemesterCourseRequest {
    String courseCode;

    public RemoveSemesterCourseRequest(String courseCode){
        this.courseCode = courseCode;
    }
}
