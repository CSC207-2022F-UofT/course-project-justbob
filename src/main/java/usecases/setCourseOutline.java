package usecases;

import courseManager.Outline;
import entities.course.Course;

public class setCourseOutline {

    public void setOutline(Outline outline, Course course) {
        course.outline = outline;
    }
}
