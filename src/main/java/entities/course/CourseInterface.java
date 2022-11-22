package entities.course;

import entities.course.outline.Outline;
import entities.course.courseEvent.CourseEvent;

import java.util.ArrayList;

public interface CourseInterface {
    String getCourseCode();

    String getCourseName();

    String getSemester();

    boolean isArchived();

    float getCredit();

    Outline getOutline();

    ArrayList<CourseEvent> getCourseEvents();

    void archiveCourse();

    void unarchiveCourse();

    String toString();

    void addCourseEvent(CourseEvent courseEvent);
}
