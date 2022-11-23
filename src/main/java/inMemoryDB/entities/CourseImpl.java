package inMemoryDB.entities;

import entities.course.Course;
import entities.course.courseEvent.CourseEvent;
import entities.course.outline.Outline;

import java.util.ArrayList;

public class CourseImpl extends Course {
    private String courseCode;
    private String courseName;
    private float credit;
    private Outline outline;
    private ArrayList<CourseEvent> courseEvents;

    /**
     * Create a new Course object with the given parameters
     *
     * @param courseCode the code of the course
     *                   e.g. 'CSC207'
     * @param courseName the name of the course
     *                   e.g. 'Software Design'
     * @param credit     the number of credits the course is worth; must be either 0.5 or 1.0
     */
    public CourseImpl(String courseCode, String courseName, float credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        this.outline = new Outline();
        this.courseEvents = new ArrayList<>();
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public float getCredit() {
        return credit;
    }

    @Override
    public void setCredit(float credit) {
        this.credit = credit;
    }

    @Override
    public Outline getOutline() {
        return outline;
    }

    @Override
    public void setOutline(Outline outline) {
        this.outline = outline;
    }

    @Override
    public ArrayList<CourseEvent> getCourseEvents() {
        return courseEvents;
    }

    @Override
    public void addCourseEvent(CourseEvent courseEvent) {
        if (!courseEvents.contains(courseEvent)) {
            courseEvents.add(courseEvent);
        }
    }

    @Override
    public void removeCourseEvent(CourseEvent courseEvent) {
        courseEvents.remove(courseEvent);
    }
}