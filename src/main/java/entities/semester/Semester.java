package entities.semester;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Semester {
    private static final String DEFAULT_SEMESTER_TITLE = "Semester";
    private String title;
    private List<Course> runningCourses;

    /**
     * Create a new empty Semester.
     * @param title the title of the semester (e.g. Fall)
     */
    public Semester(String title) {
        this.title = title;
        this.runningCourses = new ArrayList<>();
    }

    /**
     * Creates a new empty Semester object, where courses of the current semester can be added.
     */
    public Semester() {
        this(DEFAULT_SEMESTER_TITLE);
    }

    public String getTitle() {
        return title;
    }

    public List<Course> getRunningCourses() {
        return this.runningCourses;
    }

    public void addCourse(Course course) {
        if (!this.runningCourses.contains(course)) {
            this.runningCourses.add(course);
        }
    }

    public void removeCourse(Course course) {
        runningCourses.remove(course);
    }
}

