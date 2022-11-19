package accountClasses;

import courseManager.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountController { //communicates between interactor and GUI
    public static void registerStatus(String username, String password, MyPanel panel) throws IOException {
        //this method checks duplicate usernames, illegal usernames, and illegal passwords by calling the interactor.
        //the method will also respond to each outcome differently and change the GUI
        String status = AccountInteractor.createAccount(username, password);
        switch (status) {
            case "good":
                panel.isAccountPage();
                break;
            case "illegal id":
                panel.instruction.setText("<html>" + "Username too short or too long, username must be 8-16 characters" + "<html>");
                break;
            case "illegal password":
                panel.instruction.setText("<html>" + "password too short or too long, password must be 8-16 characters" + "<html>");
                break;
            default:
                panel.instruction.setText("<html>" + "Username already exists, please choose another username" + "<html>");
                //notify user of duplicate username
                break;
        }
    }

    public static void loginStatus(String username, String password, MyPanel panel) throws IOException {
        //Similar to the previous method, this method calls the interactor to check for non-existing usernames and
        //wrong passwords. This method also changes the GUI according to results from the interactor.
        String status = AccountInteractor.login(username, password);
        if(status.equals("good")){
            panel.instruction.setText("Login is successful");
            panel.isAccountPage();
        } else if (status.equals("false password")) {
            panel.instruction.setText("<html>" + "Incorrect password, please try again" + "<html>");
        } else {
            panel.instruction.setText("<html>" + "Username does not exist, please re-enter" + "<html>");
        }
    }
}
