package accountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    static List<Account> accounts = new ArrayList<Account>(); //The list of registered accounts.

    static public void addAccount(Account account) {
        //This method adds a new account to accounts
        accounts.add(account);
    }

    public boolean checkDuplicateId(String id){
        //Check if the given username matches an existing username in accounts
        for(Account account : accounts){
            if(account.username.equals(id)){
                return false;
            }
        }
        return true;
    }
}
