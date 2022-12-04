package inMemoryDB;

import entities.account.Account;
import ports.database.EntityGateway;

import java.util.HashMap;

//TODO: Implement querying for paths of the form (username, courseCode, assessmentTitle, instanceTitle) and sub-paths
// of the same form.

public class InMemoryEntityGateway implements EntityGateway {
    private final HashMap<String, Account> accountsByUsername = new HashMap<>();

    @Override
    public boolean existsAccount(String username) {
        return accountsByUsername.containsKey(username);
    }

    @Override
    public Account loadAccount(String username) throws AccountNotFoundException {
        Account account = accountsByUsername.get(username);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        accountsByUsername.put(account.getUsername(), account);
    }

    @Override
    public void deleteAccount(String username) {
        accountsByUsername.remove(username);
    }
}
