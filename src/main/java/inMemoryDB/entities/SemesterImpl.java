package inMemoryDB.entities;

import entities.account.Semester;
import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class SemesterImpl extends Semester {
    private String title;
    private ArrayList<Course> runningCourses = new ArrayList<>();

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ArrayList<Course> getRunningCourses() {
        return runningCourses;
    }

    @Override
    public void setRunningCourses(ArrayList<Course> runningCourses) {
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
