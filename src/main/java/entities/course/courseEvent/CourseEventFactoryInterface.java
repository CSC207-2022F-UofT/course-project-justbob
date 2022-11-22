package entities.course.courseEvent;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface CourseEventFactoryInterface {

    CourseEvent create(String type, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location);
}
