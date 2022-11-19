package accountClasses;

import courseManager.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountController {
    public static void registerStatus(String username, String password, MyPanel panel) throws IOException {
        String status = AccountInteractor.createAccount(username, password);
        if(status.equals("good")){
            panel.isAccountPage();
        } else if (status.equals("illegal id")) {
            panel.instruction.setText("<html>" + "Username too short or too long, username must be 8-16 characters" + "<html>");
        } else if (status.equals("illegal password")) {
            panel.instruction.setText("<html>" + "password too short or too long, password must be 8-16 characters" + "<html>");
        } else{
            panel.instruction.setText("<html>" + "Username already exists, please choose another username" + "<html>");
            //notify user of duplicate username
        }
    }

    public static void loginStatus(String username, String password, MyPanel panel) throws IOException {
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

    public static List<String> extractArchived(){
        List<Course> archivedCourses = Archive.getArchived();
        List<String> courses = new ArrayList<>();
        for(Course course : archivedCourses){
            courses.add(course.getCourseCode() + course.getCourseName() + course.getSemester());
        }
        return courses;
    }
}
