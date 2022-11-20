package usecases.markOperations.addMark;

import usecases.dataStorage.InstanceDsGateway;
import usecases.dataStorage.InstanceDsRequestModel;

public class AddMarkInteractor implements AddMarkInputBoundary {
    private InstanceDsGateway instanceDsGateway;
    private AddMarkPresenter presenter;

    public AddMarkInteractor(InstanceDsGateway instanceDsGateway, AddMarkPresenter presenter) {
        this.instanceDsGateway = instanceDsGateway;
        this.presenter = presenter;
    }

    @Override
    public AddMarkResponseModel execute(AddMarkRequestModel requestModel) {
        InstanceDsRequestModel dsRequestModel = new InstanceDsRequestModel(
                requestModel.getUsername(),
                requestModel.getCourseCode(),
                requestModel.getAssignmentTitle(),
                requestModel.getInstanceIndex()
        );

        if (!instanceDsGateway.existsInstance(dsRequestModel)) {
            return presenter.prepareFailureView("Could not find the desired instance");
        }

        // factory a new instance



        return new AddMarkResponseModel(0.0);
    }
}
