package usecases.markOperations.addMark;

import usecases.dataStorage.instance.InstanceDsGateway;
import usecases.dataStorage.instance.InstanceDsRequestModel;

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

        // somehow find the new hypothetical grade

        return new AddMarkResponseModel(0.0);
    }
}
