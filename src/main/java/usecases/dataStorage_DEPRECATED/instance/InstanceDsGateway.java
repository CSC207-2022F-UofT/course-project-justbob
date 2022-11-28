package usecases.dataStorage_DEPRECATED.instance;

public interface InstanceDsGateway {
    boolean existsInstance(InstanceDsRequestModel requestModel);
    InstanceDsModel loadInstance(InstanceDsRequestModel requestModel) throws IllegalArgumentException;
    void saveInstanceMark(InstanceDsRequestModel requestModel, double mark) throws IllegalArgumentException;
}
