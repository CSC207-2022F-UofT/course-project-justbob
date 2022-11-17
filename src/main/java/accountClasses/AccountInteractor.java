package accountClasses;

import java.util.*;

public class AccountInteractor {

    public static void createAccount(String id, String password) {
        if (!(CredentialsChecker.checkDuplicateId(id))) {
            AccountGui.instruction.setText("Username already exists, please choose another username");
        } else if (!(CredentialsChecker.idLengthCheck(id))) {
            AccountGui.instruction.setText("Username too short or too long, username must be 8-16 characters");
        } else {
            if(CredentialsChecker.passwordLengthCheck(password)){
                Account newAcc = new Account(id, password);
                AccountList.addAccount(newAcc);
                AccountGui.instruction.setText("Account has been successfully created");
            }else{
                AccountGui.instruction.setText("password too short or too long, password must be 8-16 characters");
            }
        }
    }

    public static void login(String id, String password) {
        for (Account account : AccountList.accounts) {
            if (Objects.equals(account.getUsername(), id)) {
                if (Objects.equals(account.getPassword(), password)) {
                    AccountGui.instruction.setText("Login is successful");
                } else {
                    AccountGui.instruction.setText("Incorrect password, please try again");
                }
            } else {
                AccountGui.instruction.setText("Username does not exist, please re-enter");
            }
        }
    }
}
