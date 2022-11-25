package inMemoryDB.entities;

import entities.account.Semester;
import entities.course.Course;

import java.util.List;

public class SemesterImpl extends Semester {
    private static final String DEFAULT_SEMESTER_TITLE = "Semester";

    private String title;
    private List<Course> runningCourses;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Course> getRunningCourses() {
        return runningCourses;
    }

    @Override
    public void setRunningCourses(List<Course> runningCourses) {
        this.runningCourses = runningCourses;
    }

    @Override
    public void addCourse(Course course) {
        if (!getRunningCourses().contains(course)) {
            getRunningCourses().add(course);
        }
    }

    @Override
    public void removeCourse(Course course) {
        getRunningCourses().remove(course);
    }
}
