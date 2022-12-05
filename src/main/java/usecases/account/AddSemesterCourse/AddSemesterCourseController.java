package usecases.account.AddSemesterCourse;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseRequest;

import javax.swing.*;

public class AddSemesterCourseController {
    public AddSemesterCourseController(AddSemesterCourseRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory) {
        AddSemesterCourseUseCase usecase = new AddSemesterCourseUseCase(entityGateway, entityFactory);
        AddSemesterCoursePresenter presenter = new AddSemesterCoursePresenter(frame, entityGateway, entityFactory);

        try {
            ApplicationResponse response = usecase.execute(request);
            presenter.presentSuccess(response);
        } catch (Throwable error) {
            presenter.presentError(error);
        }
    }
}
