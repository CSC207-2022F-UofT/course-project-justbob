package usecases.account.LoginAccount;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import views.ApplicationView;

import javax.swing.*;

public class LoginAccountPresenter {
    private final JFrame frame;
    private final EntityGateway entityGateway;
    private final EntityFactory entityFactory;

    public LoginAccountPresenter(JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory) {
        this.frame = frame;
        this.entityGateway = entityGateway;
        this.entityFactory = entityFactory;
    }

    public void presentError(Throwable error) {
        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void presentSuccess(ApplicationResponse response) {
        JOptionPane.showMessageDialog(null, "Logged In", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.frame.dispose();
        new ApplicationView(this.entityGateway, this.entityFactory, response);
    }
}
