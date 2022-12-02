package ports.usecases.calendar.getMonthData;
import java.time.*;

public class calendarModelRequest {
    public LocalDate date;

    public calendarModelRequest(LocalDate date){
        this.date = date;
    }
    LocalDate getDate(){
        return date;
    }
    void setDate(LocalDate date){
        this.date = date;
    }
}
