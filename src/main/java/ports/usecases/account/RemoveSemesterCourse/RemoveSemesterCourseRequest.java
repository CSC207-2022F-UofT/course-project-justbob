package ports.usecases.account.RemoveSemesterCourse;

public class RemoveSemesterCourseRequest {

    public String courseCode;

    public RemoveSemesterCourseRequest(String courseCode){
        this.courseCode = courseCode;
    }
}
