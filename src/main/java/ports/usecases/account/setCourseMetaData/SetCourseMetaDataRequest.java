package ports.usecases.account.setCourseMetaData;

public class SetCourseMetaDataRequest {
    public String username; /*abstract to path class*/

    public String courseCode; /*abstract to path class*/

    public String newCourseCode;

    public String newCourseName;

    public float newCredit;


    public SetCourseMetaDataRequest() {};

    public SetCourseMetaDataRequest(String username, String courseCode, String newCourseCode, String newCourseName,
                                    float newCredit) {
        this.username = username;
        this.courseCode = courseCode;
        this.newCourseCode = newCourseCode;
        this.newCourseName = newCourseName;
        this.newCredit = newCredit;
    }
}
