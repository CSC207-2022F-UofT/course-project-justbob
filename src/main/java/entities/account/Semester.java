package entities.account;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public abstract class Semester {
    public abstract String getTitle();
    public abstract ArrayList<Course> getRunningCourses();

    public abstract void setTitle(String title);
    public abstract void setRunningCourses(ArrayList<Course> runningCourses);

    public abstract void addCourse(Course course);
    public abstract void removeCourse(Course course);

    public interface SemesterFactory {
        Semester createSemester();
    }
}

