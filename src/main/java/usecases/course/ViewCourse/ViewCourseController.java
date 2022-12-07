package usecases.course.ViewCourse;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.course.viewCourse.ViewCourseRequest;

import javax.swing.*;

public class ViewCourseController {

    public ViewCourseController(ViewCourseRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        ViewCourseUseCase usecase = new ViewCourseUseCase(entityGateway);
        ViewCoursePresenter presenter = new ViewCoursePresenter(frame, entityGateway, entityFactory, parentFrame);

        presenter.present(usecase.execute(request));

    }

}
