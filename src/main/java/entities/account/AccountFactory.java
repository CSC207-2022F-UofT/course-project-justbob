package entities.account;

public class AccountFactory implements AccountFactoryInterface {

    public static Account create(String username, String password) {
        return new Account(username, password);
    }
}
