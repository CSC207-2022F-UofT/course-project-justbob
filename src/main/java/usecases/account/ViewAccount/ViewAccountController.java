package usecases.account.ViewAccount;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.viewAccount.ViewAccountRequest;
import ports.usecases.account.viewAccount.ViewAccountResponse;

import javax.swing.*;

public class ViewAccountController {

    public ViewAccountController(ViewAccountRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        ViewAccountUseCase usecase = new ViewAccountUseCase(entityGateway);
        ViewAccountPresenter presenter = new ViewAccountPresenter(frame, entityGateway, entityFactory, parentFrame);

        ViewAccountResponse response = usecase.execute(request);
        presenter.present(response);
    }
}
