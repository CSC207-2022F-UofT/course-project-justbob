package ports.usecases.calendar.toggleAssessmentsUseCase;

public class ToggleAssessmentsResponseModel {
    private boolean toggleAssessments;

    public ToggleAssessmentsResponseModel(boolean toggleAssessments) {
        this.toggleAssessments = toggleAssessments;
    }

    void setToggleAssessments(boolean toggleAssessments) {
        this.toggleAssessments = toggleAssessments;
    }

    boolean getToggleAssessments() {
        return toggleAssessments;
    }
}
