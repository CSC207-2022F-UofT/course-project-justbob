package usecases.account.ArchiveCourse;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import ports.usecases.account.archiveCourse.ArchiveCourseRequest;
import ports.usecases.account.archiveCourse.ArchiveCourseResponse;
import usecases.account.AddSemesterCourse.AddSemesterCoursePresenter;

import javax.swing.*;

public class ArchiveCourseController {
    public ArchiveCourseController(ArchiveCourseRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        ArchiveCourseUseCase usecase = new ArchiveCourseUseCase(entityGateway);
        ArchiveCoursePresenter presenter = new ArchiveCoursePresenter(frame, entityGateway, entityFactory, parentFrame);

        try {
            ArchiveCourseResponse response = usecase.execute(request.username, request.courseCode);
            presenter.presentSuccess(response);
        } catch (Throwable error) {
            presenter.presentError(error);
        }
    }
}
