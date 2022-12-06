package ports.usecases.calendar.getWeekData;

import java.time.LocalDate;

public class calendarModelWeekRequest {
    public LocalDate date;
    public calendarModelWeekRequest(LocalDate date){
        this.date = date;
    }
    LocalDate getDate(){
        return date;
    }
    void setDate(LocalDate date){
        this.date = date;
    }
}

