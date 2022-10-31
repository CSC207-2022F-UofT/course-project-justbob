package AccountClasses;

import java.util.List;

public class Account {
    String username;
    RunningCourses runningCourses;
    Archive archive;
    String password;

    public Account(String id, String password) {
        this.username = id;
        this.password = password;
    }

    public RunningCourses getRunningCourses() {
        return runningCourses;
    }

    public Archive getArchive() {
        return archive;
    }

    public String getUsername() {
        return username;
    }
}

