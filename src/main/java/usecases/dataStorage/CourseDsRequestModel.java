package usecases.dataStorage;

public class CourseDsRequestModel extends AccountDsRequestModel {
    private String courseCode;

    public CourseDsRequestModel(String username, String courseCode) {
        super(username);
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
