package ports.usecases.account.addAccount;

public class AddAccountRequest {
    public String username;
    public String password;

    public AddAccountRequest() {}

    public AddAccountRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
