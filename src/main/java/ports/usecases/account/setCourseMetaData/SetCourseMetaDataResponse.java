package ports.usecases.account.setCourseMetaData;

public class SetCourseMetaDataResponse {
    public String newCourseCode;
    public String newCourseName;
    public float newCredit;

    public SetCourseMetaDataResponse() {}

    public SetCourseMetaDataResponse(String newCourseCode, String newCourseName, float newCredit) {
        this.newCourseCode = newCourseCode;
        this.newCourseName = newCourseName;
        this.newCredit = newCredit;
    }

}
