package usecases.dataStorage_DEPRECATED.account;

public interface AccountDsGateway {
    boolean existsAccount(AccountDsRequestModel requestModel);
    AccountDsModel loadAccount(AccountDsRequestModel requestModel) throws IllegalArgumentException;
}
