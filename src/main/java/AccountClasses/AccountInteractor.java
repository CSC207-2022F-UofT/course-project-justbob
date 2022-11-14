package AccountClasses;

import java.util.*;

public class AccountInteractor {
    public Scanner scanner;

    public AccountInteractor() {
        scanner = new Scanner(System.in);
    }

    public void createAccount() {
        String id = idInput();
        for (Account account : AccountList.accounts) {
            if (Objects.equals(account.username, id)) {
                System.out.println("Username already exists, please choose another username");
                createAccount();
                return;
            }
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
            if (Objects.equals(account.username, username)) {
                if (Objects.equals(account.password, password)) {
                    closeScanner();
                    System.out.println("Login is successful");
                    return;
                }else{
                    System.out.println("Incorrect password");
                    login();
                }
            }else{
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
        if (!(8 <= password.length() && password.length() <= 16)) {
            System.out.println("Invalid password,password must be between 8 to 16 characters");
            passwordCheck();
        }
        closeScanner();
        return password;
    }

    public void closeScanner() {
        scanner.close();
    }

    public void removeAccount(Account account) {
        AccountList.removeAccount(account);
    }
}
