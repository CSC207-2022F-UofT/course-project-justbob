package usecases.account.AddSemesterCourse;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;

import javax.swing.*;

public class AddSemesterCoursePresenter {
    private final JFrame frame;

    public AddSemesterCoursePresenter(JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory) {
        this.frame = frame;
    }

    public void presentError(Throwable error) {
        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void presentSuccess(ApplicationResponse response) {
        JOptionPane.showMessageDialog(null, "Course Added", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.frame.dispose();
    }
}
