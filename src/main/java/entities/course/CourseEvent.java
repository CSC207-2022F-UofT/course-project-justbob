package entities.course;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class CourseEvent {
    private String title;
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;

    /**
     * Create a new CourseEvent object with the given parameters
     *
     * @param title     the title of the course event
     *                  e.g. 'Lecture 1', 'Tutorial', 'Lab'
     *                  Note: this is not necessarily the same as the name of the course event (there can be two different lectures)
     * @param day       the day of the week the course event is held on
     *                  e.g. 'Monday', 'Tuesday', etc.
     *                  Note: this is a DayOfWeek object, not a String
     * @param startTime the time the course event starts
     *                  e.g. '10:00'
     *                  Note: this is a LocalTime object, not a String
     * @param endTime   the time the course event ends
     *                  e.g. '11:00'
     *                  Note: this is a LocalTime object, not a String
     *                  Note: this must be after the start time (handled by interactor)
     *                  Note: this must be before the end of the day (handled by interactor)
     * @param location  the location of the course event
     *                  e.g. 'BA 1234'
     */

    public CourseEvent(String title, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location) {
        this.title = title;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public String toString() {
        return String.format("%s - %s from %s to %s - %s", title, day, startTime, endTime, location);
    }
}
