
import entities.account.Account;
import usecases.RegisterAccount;

import java.io.IOException;
import java.util.*;

public class AccountInteractor {

    public static String createAccount(String id, String password) throws IOException { //Checks the username and create account for user
        if (!(CredentialsChecker.checkDuplicateId(id))) { //if branch accounts for duplicate usernames
            return "duplicate"; //tell the controller that there exists a duplicate username
        } else if (!(CredentialsChecker.idLengthCheck(id))) { //else branch accounts for illegal usernames
            return "illegal id"; //tell the controller that the input username is illegal
        } else {
            if (CredentialsChecker.passwordLengthCheck(password)) { //checks for illegal passwords
                Account newAcc = new Account(id, password);
                RegisterAccount.register(newAcc);
                return "good"; //tell the controller that account is created
                /*need to direct user to the Account GUI*/
            } else {
                return "illegal password"; //tell the controller that the password is illegal
            }
        }
    }

    public static String login(String id, String password) { //Check the existence of account and correctness of password
        for (Account account : AccountList.accounts) { //for loop checks if account exists
            if (Objects.equals(account.getUsername(), id)) { //Account exists branch
                if (Objects.equals(account.getPassword(), password)) {
                    return "good"; //login successful, report to controller
                } else {
                    return "false password"; //Password incorrect, report to controller
                }
            }
        }
        return "account not found"; //Account does not exist, report to controller
    }
}