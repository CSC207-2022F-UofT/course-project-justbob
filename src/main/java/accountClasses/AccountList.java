package accountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    /**
     * The list of registered accounts.
     * This is static since there will only be one accountList for the app +
     */
    static List<Account> accounts;

    /**
     * This method adds a new account to accounts
     */
    static public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * This method removes an existing account in accounts
     */
    public static void removeAccount(Account account) {
        //Remove an account from accounts
        accounts.remove(account);
    }
}
