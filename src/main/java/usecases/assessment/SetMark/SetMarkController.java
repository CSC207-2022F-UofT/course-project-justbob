package usecases.assessment.SetMark;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.assessment.setMark.SetMarkRequest;
import ports.usecases.assessment.setMark.SetMarkResponse;

import javax.swing.*;

public class SetMarkController {

    public SetMarkController(SetMarkRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame){
        SetMarkUseCase usecase = new SetMarkUseCase(entityGateway);
        SetMarkPresenter presenter = new SetMarkPresenter(frame, entityGateway, entityFactory, parentFrame);

        try {
            SetMarkResponse response = usecase.execute(request);
            presenter.presentSuccess(response);
        } catch (Throwable error) {
            presenter.presentError(error);
        }
    }
}
