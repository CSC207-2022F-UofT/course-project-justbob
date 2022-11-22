package entities.account;

import entities.account.Account;

public interface AccountFactoryInterface {
    Account create(String username, String password);
}
