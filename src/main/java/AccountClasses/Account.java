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

    public Account(String id, String password, RunningCourses runningCourses) {
        this.username = id;
        this.password = password;
        this.runningCourses = runningCourses;
    }

    public Account(String id, String password, Archive archive) {
        this.username = id;
        this.password = password;
        this.archive = archive;
    }

    public Account(String id, String password, RunningCourses runningCourses, Archive archive) {
        this.username = id;
        this.password = password;
        this.runningCourses = runningCourses;
        this.archive = archive;
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

