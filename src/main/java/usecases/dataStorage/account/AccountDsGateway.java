package usecases.dataStorage.account;

public interface AccountDsGateway {
    boolean existsAccount(AccountDsRequestModel requestModel);
    AccountDsResponseModel loadAccount(AccountDsRequestModel requestModel);
}
