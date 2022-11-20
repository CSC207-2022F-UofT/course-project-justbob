package entities.course;

import entities.outline.Outline;
import entities.courseEvent.CourseEvent;

import java.util.ArrayList;

public interface CourseInterface {
    String getCourseCode();

    String getCourseName();

    String getSemester();

    boolean isArchived();

    float getCredit();

    Outline getOutline();

    ArrayList<CourseEvent> getCourseEvents();
}
