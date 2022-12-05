package ports.usecases.course.editCourse;

public class EditCourseDataResponse {
    public String newCourseCode;
    public String newCourseName;
    public float newCredit;

    public EditCourseDataResponse() {}

    public EditCourseDataResponse(String newCourseCode, String newCourseName, float newCredit) {
        this.newCourseCode = newCourseCode;
        this.newCourseName = newCourseName;
        this.newCredit = newCredit;
    }

}
