package usecases.markOperations.addMark;

public class AddMarkDsRequestModel {
    private String username;
    private String courseCode;
    private String assessmentTitle;
    private int instanceIndex;
    private double mark;

    public AddMarkDsRequestModel(String username, String courseCode, String assessmentTitle, int instanceIndex) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
        this.instanceIndex = instanceIndex;
    }

    public String getUsername() {
        return username;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public int getInstanceIndex() {
        return instanceIndex;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
