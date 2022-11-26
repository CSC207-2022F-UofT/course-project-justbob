package usecases.dataStorage_DEPRECATED.account;

public class AccountDsRequestModel {
    private String username;

    public AccountDsRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
