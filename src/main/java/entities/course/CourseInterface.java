package entities.course;

import entities.courseEvent.CourseEvent;
import courseManager.Outline;

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
