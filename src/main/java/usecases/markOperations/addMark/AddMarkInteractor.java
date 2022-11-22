package usecases.markOperations.addMark;

import entities.course.CourseFactoryInterface;
import entities.course.CourseInterface;
import usecases.dataStorage.course.CourseDsGateway;
import usecases.dataStorage.course.CourseDsModel;
import usecases.dataStorage.instance.InstanceDsGateway;
import usecases.dataStorage.instance.InstanceDsRequestModel;

public class AddMarkInteractor implements AddMarkInputBoundary {
    private AddMarkDsGateway gateway;
    private AddMarkPresenter presenter;
    private CourseFactoryInterface courseFactory;

    public AddMarkInteractor(AddMarkDsGateway gateway, AddMarkPresenter presenter,
                             CourseFactoryInterface courseFactory) {
        this.gateway = gateway;
        this.presenter = presenter;
        this.courseFactory = courseFactory;
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
        CourseDsModel courseModel = gateway.loadCourse(dsRequestModel);
        //CourseInterface course = courseFactory.create();

        // somehow find the new hypothetical grade

        return new AddMarkResponseModel(0.0);
    }
}
