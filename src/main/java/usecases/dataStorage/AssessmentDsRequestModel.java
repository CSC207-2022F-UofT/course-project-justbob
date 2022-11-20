package usecases.dataStorage;

public class AssessmentDsRequestModel extends CourseDsRequestModel {
    private String assessmentTitle;

    public AssessmentDsRequestModel(String username, String courseCode, String assessmentTitle) {
        super(username, courseCode);
        this.assessmentTitle = assessmentTitle;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }
}
