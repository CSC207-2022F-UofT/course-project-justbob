package usecases.dataStorage.instance;

public interface InstanceDsGateway {
    boolean existsInstance(InstanceDsRequestModel requestModel);
    InstanceDsResponseModel loadInstance(InstanceDsRequestModel requestModel);
    void saveInstanceMark(InstanceDsRequestModel requestModel, double mark);
}
