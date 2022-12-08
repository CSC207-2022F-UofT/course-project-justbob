package usecases.account.ViewArchive;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.ViewArchive.ViewArchiveRequest;
import ports.usecases.account.ViewArchive.ViewArchiveResponse;

import javax.swing.*;

public class ViewArchiveController {

    public ViewArchiveController(ViewArchiveRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        ViewArchiveUseCase usecase = new ViewArchiveUseCase(entityGateway);
        ViewArchivePresenter presenter = new ViewArchivePresenter(frame, entityGateway, entityFactory, parentFrame);

        ViewArchiveResponse response = usecase.execute(request);
        presenter.present(response);
    }
}
