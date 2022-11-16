package accountClasses;

import java.util.*;

public class AccountInteractor {

    public void createAccount(String id, String password) {
        if (!(CredentialsChecker.checkDuplicateId(id))) {
            System.out.println("Username already exists, please choose another username");
            //report to controller
        } else if (!(CredentialsChecker.idLengthCheck(id))) {
            System.out.println("Username too short or too long, username must be 8-16 characters");
            //report to controller
        } else {
            Account newAcc = new Account(id, password);
            AccountList.addAccount(newAcc);
            System.out.println("Account has been successfully created");
            //report to controller
        }
    }

    public void login(String id, String password) {
        for (Account account : AccountList.accounts) {
            if (Objects.equals(account.getUsername(), id)) {
                if (Objects.equals(account.getPassword(), password)) {
                    closeScanner();
                    System.out.println("Login is successful");
                    //report to controller
                } else {
                    System.out.println("Incorrect password, please try again");
                    //report to controller
                }
            } else {
                System.out.println("Username does not exist, please re-enter");
                //report to controller
            }
        }
    }
}
