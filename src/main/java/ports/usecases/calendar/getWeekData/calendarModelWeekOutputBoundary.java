package ports.usecases.calendar.getWeekData;

public interface calendarModelWeekOutputBoundary {
    calendarModelWeekResponse prepareSuccessView(calendarModelWeekResponse week);
}
