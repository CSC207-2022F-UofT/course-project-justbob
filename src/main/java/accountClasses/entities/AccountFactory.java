package accountClasses.entities;

public class AccountFactory implements AccountFactoryInterface {

    @Override
    public static Account create(String username, String password) {
        return new Account(username, password);
    }
}
