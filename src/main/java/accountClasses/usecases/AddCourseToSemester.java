package accountClasses.usecases;

import courseManager.Course;

import static accountClasses.entities.Semester.semester;

public class AddCourseToSemester {

    public static void addCourse(Course course) {
        //Add new course to the current semester
        if (semester.contains(course)) {
            System.out.println("Course already in semester");
            //report to controller
        } else {
            semester.add(course);
        }
    }
}
