package accountClasses;

import accountClasses.entities.Account;
import accountClasses.entities.AccountFactory;
import accountClasses.usecases.RegisterAccount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AccountInteractor {

    public static String createAccount(String id, String password) throws IOException { //Checks the username and create account for user
        if (CredentialsChecker.checkDuplicateId(id)) { //if branch accounts for duplicate usernames
            return "duplicate"; //tell the controller that there exists a duplicate username
        } else if (!(CredentialsChecker.idLengthCheck(id))) { //else branch accounts for illegal usernames
            return "illegal id"; //tell the controller that the input username is illegal
        } else {
            if (CredentialsChecker.passwordLengthCheck(password)) { //checks for illegal passwords
                Account newAcc = AccountFactory.create(id, password);
                RegisterAccount.register(newAcc);
                return "good"; //tell the controller that account is created
                /*need to direct user to the Account GUI*/
            } else {
                return "illegal password"; //tell the controller that the password is illegal
            }
        }
    }

    public static String login(String id, String password) throws IOException { //Check the existence of account and correctness of password
        File file = new File("C:\\Users\\alanc\\IdeaProjects\\" +
                "course-project-justbob\\src\\main\\java\\accountClasses\\accountsStorage");
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
        while((line = bReader.readLine()) != null){
            String[] sepLine = line.split(" ");
            if(Objects.equals(sepLine[0], id)){
                if(Objects.equals(sepLine[1], password)){
                    return "good"; //login successful, report to controller
                }else{
                    return "false password"; //Password incorrect, report to controller
                }
            }
        }
        return "account not found"; //Account does not exist, report to controller
    }
}
