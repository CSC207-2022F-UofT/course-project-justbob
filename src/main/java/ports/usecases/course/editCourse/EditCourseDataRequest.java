package ports.usecases.course.editCourse;

public class EditCourseDataRequest {
    public String username; /*abstract to path class*/

    public String courseCode; /*abstract to path class*/

    public String newCourseCode;

    public String newCourseName;

    public float newCredit;


    public EditCourseDataRequest() {};

    public EditCourseDataRequest(String username, String courseCode, String newCourseCode, String newCourseName,
                                 float newCredit) {
        this.username = username;
        this.courseCode = courseCode;
        this.newCourseCode = newCourseCode;
        this.newCourseName = newCourseName;
        this.newCredit = newCredit;
    }
}
