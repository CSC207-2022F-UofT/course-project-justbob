package AccountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    static List<Account> accounts = new ArrayList<Account>();

    public static void addAccount(Account account){
        accounts.add(account);
    }

    public static void removeAccount(Account account){
        accounts.remove(account);
    }
}
