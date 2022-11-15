package accountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    static List<Account> accounts = new ArrayList<Account>(); //The list of registered accounts.

    static public void addAccount(Account account) {
        //This method adds a new account to accounts
        accounts.add(account);
    }

    public static boolean checkDuplicateId(String id){
        //Check if the given username matches an existing username in accounts
        for(Account account : accounts){
            if(account.getUsername().equals(id)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkIdLength(String id){
        //check if the username is within 8 to 16 characters, inclusive
        return !(8 <= id.length() && id.length() <= 16);
    }
}
