package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    public static void registerStatus(String username, String password){
        String status = AccountInteractor.createAccount(username, password);
        if(status.equals("good")){
            panel.instruction.setText("Account has been successfully created"); //notify user of successful creation
            panel.isAccountPage();
        } else if (status.equals("illegal id")) {
            panel.instruction.setText("Username too short or too long, username must be 8-16 characters");
        } else if (status.equals("illegal password")) {
            panel.instruction.setText("password too short or too long, password must be 8-16 characters");
        } else{
            panel.instruction.setText("Username already exists, please choose another username");
            //notify user of duplicate username
        }
    }

    public static void loginStatus(String username, String password){
        String status = AccountInteractor.login(username, password);
        if(status.equals("good")){
            panel.instruction.setText("Login is successful");
            panel.isAccountPage();
        } else if (status.equals("false password")) {
            panel.instruction.setText("Incorrect password, please try again");
        } else {
            panel.instruction.setText("Username does not exist, please re-enter");
        }
    }

    public static List<String> extractArchived(){
        List<Course> archivedCourses = Archive.getArchived();
        List<String> courses = new ArrayList<>();
        for(Course course : archivedCourses){
            courses.add(course.getCourseCode() + course.getCourseName() + course.getSemester());
        }
        return courses;
    }
}
