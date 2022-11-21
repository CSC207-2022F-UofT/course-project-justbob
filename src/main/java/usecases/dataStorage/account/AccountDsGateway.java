package usecases.dataStorage.account;

public interface AccountDsGateway {
    boolean existsAccount(AccountDsRequestModel requestModel);
    AccountDsModel loadAccount(AccountDsRequestModel requestModel) throws NoSuchFieldException;
}
