package entities.courseEvent;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseEventFactory {

    public CourseEvent create(String type, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location) {
        return new CourseEvent(type, day, startTime, endTime, location);
    }
}
