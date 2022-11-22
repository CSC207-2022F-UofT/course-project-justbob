package entities.account;

public class AccountFactory implements AccountFactoryInterface {

    public Account create(String username, String password) {
        return new Account(username, password);
    }
}
