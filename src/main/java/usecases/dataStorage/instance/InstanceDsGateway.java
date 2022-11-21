package usecases.dataStorage.instance;

public interface InstanceDsGateway {
    boolean existsInstance(InstanceDsRequestModel requestModel);
    InstanceDsModel loadInstance(InstanceDsRequestModel requestModel) throws NoSuchFieldException;
    void saveInstanceMark(InstanceDsRequestModel requestModel, double mark) throws NoSuchFieldException;
}
