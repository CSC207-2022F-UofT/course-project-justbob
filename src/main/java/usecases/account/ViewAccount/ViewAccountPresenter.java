package usecases.account.ViewAccount;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.viewAccount.ViewAccountResponse;
import ports.usecases.account.viewSemester.ViewSemesterResponse;
import views.AccountView;
import views.SemesterView;

import javax.swing.*;

public class ViewAccountPresenter {
    private final EntityGateway entityGateway;
    private final EntityFactory entityFactory;
    private final JFrame frame;

    ViewAccountPresenter(JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        this.entityGateway = entityGateway;
        this.entityFactory = entityFactory;
        this.frame = frame;
    }

    public void present(ViewAccountResponse response) {
        new AccountView(entityGateway, entityFactory, response);
        frame.dispose();
    }
}
