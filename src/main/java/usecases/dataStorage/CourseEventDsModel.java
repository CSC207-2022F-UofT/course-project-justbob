package usecases.dataStorage;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class CourseEventDsModel {
    private String type;
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;
    private String location;

    public CourseEventDsModel(String type, DayOfWeek day, LocalTime startTime, LocalTime endTime, Duration duration, String location) {
        this.type = type;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }
}