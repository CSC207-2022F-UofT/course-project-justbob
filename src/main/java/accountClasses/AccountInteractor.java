package accountClasses;

import java.util.*;

public class AccountInteractor {
    private Scanner scanner;

    /**
     * Initiate an Account interactor with a scanner for user inputs
     */
    public AccountInteractor() {
        scanner = new Scanner(System.in);
    }

    public void createAccount() {
        String id = idInput();
        if (!(CredentialsChecker.checkDuplicateId(id))) {
            System.out.println("Username already exists, please choose another username");
            createAccount();
        } else if (!(CredentialsChecker.idLengthCheck(id))) {
            System.out.println("Username too short or too long, username must be 8-16 characters");
            createAccount();
        }
        String password = passwordCheck();
        Account newAcc = new Account(id, password);
        AccountList.addAccount(newAcc);
        System.out.println("Account has been successfully created");
    }

    public void login() {
        String username = idInput();
        String password = passwordInput();
        for (Account account : AccountList.accounts) {
            if (Objects.equals(account.getUsername(), username)) {
                if (Objects.equals(account.getPassword(), password)) {
                    closeScanner();
                    System.out.println("Login is successful");
                    return; //need to make this line direct user into account interface
                } else {
                    System.out.println("Incorrect password");
                    login();
                }
            } else {
                System.out.println("Username does not exist");
                login();
            }
        }
    }

    private String idInput() {
        System.out.println("Enter Username");
        return scanner.nextLine();
    }

    private String passwordInput() {
        System.out.println("Enter Password (8-16 characters, alphabets and numbers only)");
        return scanner.nextLine();
    }

    private String passwordCheck() {
        String password = passwordInput();
        if (!(CredentialsChecker.passwordLengthCheck(password))) {
            System.out.println("Invalid password,password must be between 8 to 16 characters");
            passwordCheck();
        }
        closeScanner();
        return password;
    }

    private void closeScanner() {
        scanner.close();
    }
}
