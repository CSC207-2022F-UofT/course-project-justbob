package entities.account.semester;

import entities.course.Course;

import java.util.List;

public abstract class Semester {
    public abstract String getTitle();
    public abstract List<Course> getRunningCourses();

    public abstract void setTitle(String title);
    public abstract void setRunningCourses(List<Course> runningCourses);

    public abstract void addCourse(Course course);
    public abstract void removeCourse(Course course);

    public interface SemesterFactory {
        Semester createSemester();
    }
}

