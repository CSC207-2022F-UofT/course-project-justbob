package ports.usecases.calendarUseCases.toggleTimetableUseCase;

public class ToggleTimetableResponseModel {
    private boolean toggleTimetable;

    public ToggleTimetableResponseModel(boolean toggleTimetable) {
        this.toggleTimetable = toggleTimetable;
    }

    void setToggleTimetable(boolean toggleTimetable) {
        this.toggleTimetable = toggleTimetable;
    }

    boolean getToggleTimetable() {
        return toggleTimetable;
    }
}
