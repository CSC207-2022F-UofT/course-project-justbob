package ports.usecases.calendar.toggleAssessmentsUseCase;

public class ToggleAssessmentsRequestModel {
    private boolean viewAssessments;

    public ToggleAssessmentsRequestModel(boolean viewAssessments) {
        this.viewAssessments = viewAssessments;
    }

    void setViewAssessments(boolean viewAssessments) {
        this.viewAssessments = viewAssessments;
    }

    boolean getViewAssessments() {
        return viewAssessments;
    }
}
