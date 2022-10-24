import java.util.List;

public class Account {
    String username;
    RunningCourses runningCourses;
    Archive archive;

    public Account(String id) {
        this.username = id;
    }

    public Account(String id, RunningCourses runningCourses) {
        this.username = id;
        this.runningCourses = runningCourses;
    }

    public Account(String id, Archive archive) {
        this.username = id;
        this.archive = archive;
    }

    public Account(String id, RunningCourses runningCourses, Archive archive) {
        this.username = id;
        this.runningCourses = runningCourses;
        this.archive = archive;
    }
}