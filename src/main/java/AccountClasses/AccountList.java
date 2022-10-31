package AccountClasses;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    List<Account> accounts = new ArrayList<Account>();

    public AccountList(){}

    public AccountList(List<Account> accounts){
        this.accounts = accounts;
    }
}
