package ports.usecases.calendar.getDayData;

import java.time.LocalDate;

public class calendarModelDayRequest {
    public LocalDate date;

    public calendarModelDayRequest(LocalDate date) {
        this.date = date;
    }

    LocalDate getDate() {
        return date;
    }

    void setDate(LocalDate date) {
        this.date = date;
    }
}
