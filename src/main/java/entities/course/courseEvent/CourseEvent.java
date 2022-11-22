package entities.course.courseEvent;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class CourseEvent {
    private String type;

    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;

    private Duration duration;

    private String location;

    /**
     * Create a new CourseEvent object with the given parameters
     * @param type the type of the course event
     *             e.g. 'Lecture', 'Tutorial', 'Lab'
     *             Note: this is not necessarily the same as the name of the course event (there can be two different lectures)
     * @param day the day of the week the course event is held on
     *            e.g. 'Monday', 'Tuesday', etc.
     *            Note: this is a DayOfWeek object, not a String
     * @param startTime the time the course event starts
     *                  e.g. '10:00'
     *                  Note: this is a LocalTime object, not a String
     * @param endTime the time the course event ends
     *                  e.g. '11:00'
     *                  Note: this is a LocalTime object, not a String
     *                  Note: this must be after the start time (handled by interactor)
     *                  Note: this must be before the end of the day (handled by interactor)
     * @param location the location of the course event
     *                 e.g. 'BA 1234'
     */

    public CourseEvent(String type, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location) {
        this.type = type;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = Duration.between(startTime, endTime);
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

    public String getLocation() {
        return location;
    }

    public String toString() {
        return this.type + " on " + this.day + " from " + this.startTime + " to " + this.endTime + " at " + this.location;
    }


}
