package entities.account;

public class AccountFactory {

    public Account create(String username, String password) {
        return new Account(username, password);
    }
}
