package accountClasses;

import java.util.*;

public class AccountInteractor {

    public static void createAccount(String id, String password) { //Checks the username and create account for user
        if (!(CredentialsChecker.checkDuplicateId(id))) { //if branch accounts for duplicate usernames
            AccountGui.instruction.setText("Username already exists, please choose another username");
        } else if (!(CredentialsChecker.idLengthCheck(id))) { //else branch accounts for illegal usernames
            AccountGui.instruction.setText("Username too short or too long, username must be 8-16 characters");
        } else {
            if(CredentialsChecker.passwordLengthCheck(password)){ //checks for illegal passwords
                Account newAcc = new Account(id, password);
                AccountList.addAccount(newAcc);
                AccountGui.instruction.setText("Account has been successfully created"); //Account successfully created
                /*need to direct user to the Account GUI*/
            }else{
                AccountGui.instruction.setText("password too short or too long, password must be 8-16 characters");
            }
        }
    }

    public static void login(String id, String password) { //Check the existence of account and correctness of password
        for (Account account : AccountList.accounts) { //for loop checks if account exists
            if (Objects.equals(account.getUsername(), id)) { //Account exists branch
                if (Objects.equals(account.getPassword(), password)) { //login successful branch
                    AccountGui.instruction.setText("Login is successful");
                    /*need to direct user to the Account GUI*/
                } else { //Password incorrect
                    AccountGui.instruction.setText("Incorrect password, please try again");
                }
            } else { //Account username does not exist
                AccountGui.instruction.setText("Username does not exist, please re-enter");
            }
        }
    }
}
