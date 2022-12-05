package ports.usecases.account.addCourseEvent;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class AddCourseEventResponse {
    public String eventTitle;
    public DayOfWeek day;
    public LocalTime startTime;
    public LocalTime endTime;
    public String location;

    public AddCourseEventResponse() {}

    public AddCourseEventResponse(String eventTitle, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location) {
        this.eventTitle = eventTitle;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }
}
