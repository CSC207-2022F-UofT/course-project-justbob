package usecases;

import courseManager.CourseEvent;
import entities.course.Course;

public class AddCourseEvent {

    public void addCourseEvent(Course course, CourseEvent courseEvent) {
        if (course.courseEvents.contains(courseEvent)) {
            throw new IllegalArgumentException("Course event already exists");
        }
        course.courseEvents.add(courseEvent);
    }
}
