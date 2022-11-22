package entities.course;

import entities.courseEvent.CourseEvent;
import entities.outline.Outline;

import java.util.ArrayList;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class Course {
    private String courseCode;
    private String courseName;
    private String semester;
    private boolean archived;
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
     * @param archived whether the course is archived or not
     */

    public Course(String courseCode, String courseName, boolean archived, float credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        //this.semester = semester;
        this.archived = archived;
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

    public String getSemester() {
        return semester;
    }

    public boolean isArchived() {
        return archived;
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

    public void addCourseEvent(CourseEvent courseEvent) throws IllegalArgumentException{
        if (courseEvents.contains(courseEvent)) {
            throw new IllegalArgumentException("Course event already exists");
        }
        courseEvents.add(courseEvent);
    }

    public String toString() {
        return String.format("%s: %s - %f credits", courseCode, courseName, credit);
    }

    public void archiveCourse() {
        this.archived = true;
        /*Archive.addArchivedCourse(this);*/
        /*RunningCourses.removeCourse(this);*/
    }

    public void unarchiveCourse() {
        this.archived = false;
    }

    public static void main(String[] args) {
        Course course = new Course("CSC207", "Software Design", false, 0.5f);
        CourseEvent csc207lecture = new CourseEvent("Lecture", DayOfWeek.TUESDAY,
                LocalTime.of(18,00), LocalTime.of(20,00), "BA 1200");
        CourseEvent csc207tutorial = new CourseEvent("Tutorial", DayOfWeek.MONDAY,
                LocalTime.of(12,00), LocalTime.of(14,00), "BA 1200");
        course.addCourseEvent(csc207lecture);
        course.addCourseEvent(csc207tutorial);
        System.out.println(course);
    }


}