package usecases;

import entities.course.Course;

import static entities.semester.Semester.semester;

public class RemoveCourseFromSemester {

    public static void removeCourse(Course course) {
        semester.remove(course);
    }
}
