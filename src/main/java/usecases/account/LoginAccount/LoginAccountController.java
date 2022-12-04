package usecases.account.LoginAccount;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.loginAccount.LoginAccountRequest;

import javax.swing.*;

public class LoginAccountController {
    public LoginAccountController(LoginAccountRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory) {
        LoginAccountUseCase usecase = new LoginAccountUseCase(entityGateway);
        LoginAccountPresenter presenter = new LoginAccountPresenter(frame, entityGateway, entityFactory);

        try {
            usecase.execute(request);
            presenter.presentSuccess(request.username);
        } catch (Throwable error) {
            presenter.presentError(error);
        }
    }
}
