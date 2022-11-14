package AccountClasses;

import java.util.List;

public class Account {
    public String username;
    public RunningCourses runningCourses;
    public Archive archive;
    public String password;

    public Account(String id, String password) {
        this.username = id;
        this.password = password;
    }
}

