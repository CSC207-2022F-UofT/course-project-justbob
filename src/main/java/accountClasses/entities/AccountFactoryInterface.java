package accountClasses.entities;

import accountClasses.entities.Account;

public interface AccountFactoryInterface {
    Account create(String username, String password);
}
