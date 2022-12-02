package ports.usecases.calendar.getWeekData;

import java.time.LocalDate;

public class calendarModelWeekResponse {
    LocalDate[] listOf7Days;

    public calendarModelWeekResponse(LocalDate[] listOf7Days){
        this.listOf7Days = listOf7Days;
    }

    public LocalDate[] getListOf7Days() {
        return listOf7Days;
    }

    public void setListOfDays(LocalDate[] listOf7Days){
        this.listOf7Days = listOf7Days;
    }
}
