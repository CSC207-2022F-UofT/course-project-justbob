package AccountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    List<Account> accounts = new ArrayList<Account>();

    public AccountList(){}

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }
}
