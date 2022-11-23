package usecases.markOperations.addMark;

import usecases.dataStorage.instance.InstanceDsRequestModel;

public class AddMarkInteractor implements AddMarkInputBoundary {
    private AddMarkDsGateway gateway;
    private AddMarkPresenter presenter;

    public AddMarkInteractor(AddMarkDsGateway gateway, AddMarkPresenter presenter) {
        this.gateway = gateway;
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

        if (!gateway.existsInstance(dsRequestModel)) {
            return presenter.prepareFailureView("Could not find the desired instance");
        }
        //Account account = DsConverter.accountModelToEntity(gateway.loadAccount(dsRequestModel));
        //account.getSemester().

        //Account account = gateway.loadAccount(requestModel.getUsername());//DsConverter.accountModelToEntity()//DsConverter.courseModelToEntity(courseModel);

        //CourseInterface course = courseFactory.create();

        // somehow find the new hypothetical grade

        return new AddMarkResponseModel(0.0);
    }
}
