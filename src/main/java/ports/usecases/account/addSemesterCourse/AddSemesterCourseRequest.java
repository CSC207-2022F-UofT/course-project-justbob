package ports.usecases.account.addSemesterCourse;

public class AddSemesterCourseRequest {
    public String courseCode;
    public String courseName;
    public float credit;

    public AddSemesterCourseRequest(String courseCode, String courseName, float credit){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
    }
}
