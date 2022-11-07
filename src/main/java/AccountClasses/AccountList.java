package AccountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    static List<Account> accounts = new ArrayList<Account>();

    public AccountList(){}

    public static void addAccount(Account account){
        accounts.add(account);
    }
}
