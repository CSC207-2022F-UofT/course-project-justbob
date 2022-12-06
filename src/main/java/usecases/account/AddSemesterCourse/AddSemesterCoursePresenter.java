package usecases.account.AddSemesterCourse;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import views.ApplicationView;

import javax.swing.*;

public class AddSemesterCoursePresenter {
    private final JFrame frame;
    private final EntityGateway entityGateway;
    private final EntityFactory entityFactory;

    public AddSemesterCoursePresenter(JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory) {
        this.entityGateway = entityGateway;
        this.entityFactory = entityFactory;
        this.frame = frame;
    }

    public void presentError(Throwable error) {
        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void presentSuccess(ApplicationResponse response) {
        JOptionPane.showMessageDialog(null, "Course Added", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.frame.dispose();
        new ApplicationView(entityGateway, entityFactory, response);
    }
}
