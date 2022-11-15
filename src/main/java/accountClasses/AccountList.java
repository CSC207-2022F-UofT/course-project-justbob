package accountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    static List<Account> accounts = new ArrayList<Account>(); //The list of registered accounts.

    static public void addAccount(Account account) {
        //This method adds a new account to accounts
        accounts.add(account);
    }
}
