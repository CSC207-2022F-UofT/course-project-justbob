package accountClasses.usecases;

import courseManager.Course;

import static accountClasses.entities.Semester.semester;

public class RemoveCourseFromSemester {

    public static void removeCourse(Course course) {
        semester.remove(course);
    }
}
