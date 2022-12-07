package usecases.assessment.AddSimpleAssessment;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.assessment.addSimpleAssessment.AddSimpleAssessmentRequest;
import ports.usecases.assessment.addSimpleAssessment.AddSimpleAssessmentResponse;

import javax.swing.*;


public class AddSimpleAssessmentController {

    public AddSimpleAssessmentController(AddSimpleAssessmentRequest request, JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        AddSimpleAssessmentUseCase usecase = new AddSimpleAssessmentUseCase(entityGateway, entityFactory);
        AddSimpleAssessmentPresenter presenter = new AddSimpleAssessmentPresenter(frame, entityGateway, entityFactory, parentFrame);

        try {
            AddSimpleAssessmentResponse response = usecase.execute(request);
            presenter.presentSuccess(response);
        } catch (Throwable error) {
            presenter.presentError(error);
        }
    }
}
