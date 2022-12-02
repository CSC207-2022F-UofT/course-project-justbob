package ports.usecases.calendarUseCases.toggleTimetableUseCase;

public class ToggleTimetableRequestModel {
    private boolean viewTimetable;

    public ToggleTimetableRequestModel(boolean viewTimetable) {
        this.viewTimetable = viewTimetable;
    }

    void setViewTimetable(boolean viewTimetable) {
        this.viewTimetable = viewTimetable;
    }

    boolean getViewTimetable() {
        return viewTimetable;
    }
}
