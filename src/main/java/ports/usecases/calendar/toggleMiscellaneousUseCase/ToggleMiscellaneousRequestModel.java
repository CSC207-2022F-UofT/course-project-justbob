package ports.usecases.calendar.toggleMiscellaneousUseCase;

public class ToggleMiscellaneousRequestModel {
    private boolean viewMiscellaneous;

    public ToggleMiscellaneousRequestModel(boolean viewMiscellaneous) {
        this.viewMiscellaneous = viewMiscellaneous;
    }

    void setViewMiscellaneous(boolean viewMiscellaneous) {
        this.viewMiscellaneous = viewMiscellaneous;
    }

    boolean getViewMiscellaneous() {
        return viewMiscellaneous;
    }
}
