package ports.usecases.account.addSemesterCourse;

import entities.course.Outline;

public class AddSemesterCourseRequest {

    public String username;
    public String courseCode;
    public String courseName;
    public float credit;

    public AddSemesterCourseRequest(String username, String courseCode, String courseName, float credit){
        this.username = username;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;

    }
}
