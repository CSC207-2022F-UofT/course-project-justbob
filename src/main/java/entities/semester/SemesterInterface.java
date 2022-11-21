package entities.semester;

import entities.course.Course;

import java.util.List;

public interface SemesterInterface {

    //Calendar getCalendar();
    //Checklist getChecklist();
    List<Course> getSemester();

    static void addCourse(Course course) {

    }

    static void removeCourse(Course course) {

    }
}
