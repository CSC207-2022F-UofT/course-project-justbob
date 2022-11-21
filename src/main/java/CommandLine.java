import entities.account.Account;

import java.util.Objects;
import java.util.Scanner;

public class CommandLine {
    Account userAccount;

    public String welcome() {
        System.out.println("Welcome to our program! Would you like to login or register an account?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void loginOrRegister(String ans) {
        if (Objects.equals(ans, "login")) {
            login();
        } else if (Objects.equals(ans, "register")) {
            register();
        } else {
            System.out.println("Invalid input, please enter <login> or <register>");
            welcome();
        }
    }

    public void login() {
        System.out.println("Please enter your username");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        if (Objects.equals(username, userAccount.getUsername())) {
            System.out.println("Please enter your password");
            String password = scanner.next();
            scanner.close();
            if (Objects.equals(password, userAccount.getPassword())) {
                System.out.println("login successful");
                System.out.println("What would you like do to next? <>");
            } else {
                System.out.println("password incorrect, please try again");
                login();
            }
        } else {
            System.out.println("Account does not exists, please try again");
            login();
        }
    }

    public void register() {
        System.out.println("Please choose a username");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        if (this.userAccount.getUsername() == username) {
            System.out.println("Username already exists, please choose a different username");
            register();
        } else {
            System.out.println("please choose a password");
            String password = scanner.next();
            scanner.close();
            userAccount = new Account(username, password);
            System.out.println("Account has been registered");
            System.out.println("What would you like to do next? <>");
        }
    }
}


