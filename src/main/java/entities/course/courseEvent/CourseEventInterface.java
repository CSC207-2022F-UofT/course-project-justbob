package entities.course.courseEvent;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface CourseEventInterface {

    String getType();

    DayOfWeek getDay();

    LocalTime getStartTime();

    LocalTime getEndTime();

    String getLocation();
    String toString();
}

