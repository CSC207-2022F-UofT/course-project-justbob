package ports.usecases.assessment.viewAssessment;

public class ViewAssessmentRequest {
    public String username;
    public String courseCode;
    public String assessmentTitle;

    public ViewAssessmentRequest(String username, String courseCode, String assessmentTitle) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
    }
}

