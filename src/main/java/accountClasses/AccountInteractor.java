package accountClasses;

import java.util.*;

public class AccountInteractor {

    public void createAccount(String id, String password) {
        if (!(CredentialsChecker.checkDuplicateId(id))) {
            System.out.println("Username already exists, please choose another username");
        } else if (!(CredentialsChecker.idLengthCheck(id))) {
            System.out.println("Username too short or too long, username must be 8-16 characters");
        } else {
            Account newAcc = new Account(id, password);
            AccountList.addAccount(newAcc);
            System.out.println("Account has been successfully created");
        }
    }

    public void login(String id, String password) {
        for (Account account : AccountList.accounts) {
            if (Objects.equals(account.getUsername(), id)) {
                if (Objects.equals(account.getPassword(), password)) {
                    closeScanner();
                    System.out.println("Login is successful");
                } else {
                    System.out.println("Incorrect password, please try again");
                }
            } else {
                System.out.println("Username does not exist, please re-enter");
            }
        }
    }

    // the below code should be in a new AccountController class
    private String idInput() {
        System.out.println("Enter Username");
        return scanner.nextLine();
    }

    private String passwordInput() {
        System.out.println("Enter Password (8-16 characters, alphabets and numbers only)");
        return scanner.nextLine();
    }

    private void closeScanner() {
        scanner.close();
    }
}
