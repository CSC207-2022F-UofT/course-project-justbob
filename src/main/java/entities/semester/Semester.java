package entities.semester;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Semester {
    private static final String DEFAULT_SEMESTER_TITLE = "Semester";
    private String title;
    private List<Course> semester;

    /**
     * Creates a new Semester object, where courses of the current semester can be added.
     */
    public Semester() {
        this(DEFAULT_SEMESTER_TITLE);
    }

    /**
     * Create a new empty Semester.
     * @param title the title of the semester (e.g. Fall)
     */
    public Semester(String title) {
        this.title = title;
        this.semester = new ArrayList<>();
    }

    public List<Course> getSemester() {
        return this.semester;
    }

    public void addCourse(Course course) {
        //Add new course to the current semester
        if (this.semester.contains(course)) {
            throw new IllegalArgumentException("Course already in semester");
            //report to controller
        } else {
            this.semester.add(course);
        }
    }

    public void removeCourse(Course course) {
        semester.remove(course);
    }
}

