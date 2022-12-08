package inMemoryDB;

import entities.account.Account;
import ports.database.EntityGateway;

import java.io.FileNotFoundException;
import java.util.HashMap;

//TODO: Implement querying for paths of the form (username, courseCode, assessmentTitle, instanceTitle) and sub-paths
// of the same form.

public class InMemoryEntityGateway implements EntityGateway {
    private String databaseFilePath;
    private HashMap<String, Account> accountsByUsername = new HashMap<>();

    public InMemoryEntityGateway(String databaseFilePath) {
        this.databaseFilePath = databaseFilePath;
        // TODO: actually print error statements
        try {
            accountsByUsername = (HashMap<String, Account>) Serializer.deserialize(databaseFilePath);
        } catch (Exception e) {
        }
    }

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
        // TODO: actually print error statements
        try {
            Serializer.serialize(accountsByUsername, databaseFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("FAILED TO FIND FILE");
        } catch (java.io.IOException e) {
            System.out.println("THERE WAS A PROBLEM WITH WRITING TO THE FILE.");
        }
    }

    @Override
    public void deleteAccount(String username) {
        accountsByUsername.remove(username);
    }
}
