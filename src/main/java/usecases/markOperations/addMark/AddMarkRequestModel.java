package usecases.markOperations.addMark;

public class AddMarkRequestModel {
    String username;
    String courseCode;
    String assignmentTitle;
    int instanceIndex;

    public AddMarkRequestModel(String username, String courseCode, String assignmentTitle, int instanceIndex) {
        this.username = username;
        this.courseCode = courseCode;
        this.assignmentTitle = assignmentTitle;
        this.instanceIndex = instanceIndex;
    }

    public String getUsername() {
        return username;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public int getInstanceIndex() {
        return instanceIndex;
    }
}
