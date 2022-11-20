package accountClasses;

public class AccountFactory implements AccountFactoryInterface {

    @Override
    public Account create(String username, String password) {
        return new Account(username, password);
    }
}
