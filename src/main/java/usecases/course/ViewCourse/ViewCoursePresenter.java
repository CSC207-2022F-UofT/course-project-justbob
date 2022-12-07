package usecases.course.ViewCourse;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.course.viewCourse.ViewCourseResponse;
import views.CourseView;

import javax.swing.*;

public class ViewCoursePresenter {

    private final EntityGateway entityGateway;
    private final EntityFactory entityFactory;

    public ViewCoursePresenter(JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory) {
        this.entityGateway = entityGateway;
        this.entityFactory = entityFactory;
    }

    public void present(ViewCourseResponse response) {
        new CourseView(entityGateway, entityFactory, response);
    }
}
