package entities.archive;

import entities.course.Course;

import java.util.List;

public interface ArchiveInterface {
    static List<Course> getCourses() {
        return null;
    }

    void addCourse(Course course);

    void RemoveCourse(Course course);
}
