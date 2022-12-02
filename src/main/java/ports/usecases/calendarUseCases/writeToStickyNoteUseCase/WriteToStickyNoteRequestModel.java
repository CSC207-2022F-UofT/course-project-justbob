package ports.usecases.calendarUseCases.writeToStickyNoteUseCase;

import java.time.*;

public class WriteToStickyNoteRequestModel {
    private String title;
    private String type;
    private String location;
    private String time;
    private String[] dotJots;
    private LocalDate[] dates;

    public WriteToStickyNoteRequestModel(String title, String type, String location, String time, String[] dotJots, LocalDate[] dates) {
        this.title = title;
        this.type = type;
        this.location = location;
        this.time = time;
        this.dotJots = dotJots;
        this.dates = dates;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    String getLocation() {
        return type;
    }

    void setLocation(String location) {
        this.location = location;
    }

    String[] getDotJots() {
        return dotJots;
    }

    void setDotJots(String[] dotJots) {
        this.dotJots = dotJots;
    }

    LocalDate[] getDates() {
        return dates;
    }

    void setDates(LocalDate[] dates) {
        this.dates = dates;
    }

    String getTime() {
        return time;
    }

    void setTime(String time) {
        this.time = time;
    }
}
