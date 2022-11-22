package usecases.markOperations.addMark;

import usecases.dataStorage.account.AccountDsGateway;
import usecases.dataStorage.course.CourseDsGateway;
import usecases.dataStorage.instance.InstanceDsGateway;

public interface AddMarkDsGateway extends AccountDsGateway, InstanceDsGateway {
}
