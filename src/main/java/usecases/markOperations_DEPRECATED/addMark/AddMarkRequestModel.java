package usecases.markOperations_DEPRECATED.addMark;

public class AddMarkRequestModel {
    private String username;
    private String courseCode;
    private String assessmentTitle;
    private int instanceIndex;
    private double mark;

    public AddMarkRequestModel(String username, String courseCode, String assignmentTitle,
                               int instanceIndex, double mark) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assignmentTitle;
        this.instanceIndex = instanceIndex;
        this.mark = mark;
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

    public double getMark() {
        return mark;
    }
}
