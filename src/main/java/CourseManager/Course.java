package CourseManager;

import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private String semester;
    private boolean archived;
    private float credit;

    private Outline outline;

    private ArrayList<CourseEvent> courseEvents;

    public Course(String courseCode, String courseName, String semester, boolean archived, float credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.archived = archived;
        this.credit = credit;
        this.courseEvents = new ArrayList<>();
    }

    public void setOutline(Outline outline) {
        this.outline = outline;
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

    public ArrayList<CourseEvent> getCourseEvents() {
        return courseEvents;
    }

    public void addCourseEvent(CourseEvent courseEvent) {
        this.courseEvents.add(courseEvent);
    }

    public String toString() {
        if (archived) {
            return this.courseCode + ": " + this.courseName + " took place in " + this.semester + " and was worth " + this.credit +
                    " credit(s). It had the following course events:" + this.courseEvents;
        } else {
            return this.courseCode + ": " + this.courseName + " takes place in " + this.semester +
                    " and is worth " + this.credit + " credit(s). It has the following course events: " + this.courseEvents;
        }
    }

    public void archiveCourse() {
        this.archived = true;
        /*Archive.addArchivedCourse(this);*/
        /*RunningCourses.removeCourse(this);*/
    }

    public static void main(String[] args) {
        Course course = new Course("CSC207", "Software Design", "Fall 2022", false, 0.5f);
        CourseEvent csc207lecture = new CourseEvent("Lecture", "Tuesday", "18:00", "20:00", "BA 1200");
        CourseEvent csc207tutorial = new CourseEvent("Tutorial", "Monday", "12:00", "14:00", "BA 1200");
        course.addCourseEvent(csc207lecture);
        course.addCourseEvent(csc207tutorial);
        System.out.println(course);
    }


}
