package usecases.markOperations.addMark;

public class AddMarkRequestModel {
    private String username;
    private String courseCode;
    private String assessmentTitle;
    private int instanceIndex;

    public AddMarkRequestModel(String username, String courseCode, String assignmentTitle, int instanceIndex) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assignmentTitle;
        this.instanceIndex = instanceIndex;
    }

    public String getUsername() {
        return username;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getAssignmentTitle() {
        return assessmentTitle;
    }

    public int getInstanceIndex() {
        return instanceIndex;
    }
}
