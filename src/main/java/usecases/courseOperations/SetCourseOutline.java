package usecases.courseOperations;

import entities.outline.Outline;
import entities.course.Course;

public class SetCourseOutline {

    public void setOutline(Outline outline, Course course) {
        course.outline = outline;
    }
}
