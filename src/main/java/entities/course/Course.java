package entities.course;

import entities.courseEvent.CourseEvent;
import entities.outline.Outline;

import java.util.ArrayList;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class Course {
    private String courseCode;
    private String courseName;
    private float credit;

    private Outline outline;

    private ArrayList<CourseEvent> courseEvents;

    /**
     * Create a new Course object with the given parameters
     * @param courseCode the code of the course
     *                   e.g. 'CSC207'
     * @param courseName the name of the course
     *                   e.g. 'Software Design'
     * @param credit the number of credits the course is worth; must be either 0.5 or 1.0
     */

    public Course(String courseCode, String courseName, float credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        this.courseEvents = new ArrayList<>();
        this.outline = new Outline();
    }
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public float getCredit() {
        return credit;
    }

    public Outline getOutline() {
        return outline;
    }

    public ArrayList<CourseEvent> getCourseEvents() {
        return courseEvents;
    }

    public void addCourseEvent(CourseEvent courseEvent) {
        if (!courseEvents.contains(courseEvent)) {
            courseEvents.add(courseEvent);
        }
    }

    public String toString() {
        return String.format("%s: %s - %f credits", courseCode, courseName, credit);
    }
}