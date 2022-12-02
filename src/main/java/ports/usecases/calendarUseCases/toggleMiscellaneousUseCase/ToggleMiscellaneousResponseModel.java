package ports.usecases.calendarUseCases.toggleMiscellaneousUseCase;

public class ToggleMiscellaneousResponseModel {
    private boolean toggleMiscellaneous;

    public ToggleMiscellaneousResponseModel(boolean toggleMiscellaneous) {
        this.toggleMiscellaneous = toggleMiscellaneous;
    }

    void setToggleMiscellaneous(boolean toggleMiscellaneous) {
        this.toggleMiscellaneous = toggleMiscellaneous;
    }

    boolean getToggleMiscellaneous() {
        return toggleMiscellaneous;
    }
}
