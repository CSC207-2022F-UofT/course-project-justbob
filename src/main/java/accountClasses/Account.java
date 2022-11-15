package accountClasses;

public class Account {
    private String username;
    private String password;
    private RunningCourses runningCourses;
    private Archive archive;

    /**
     * Creates an account object
     * @param id the username of the account
     *           e.g. 'JimBob123'
     * @param password the password of the account
     *           e.g. 'JimmyJimmy321'
     */
    public Account(String id, String password) {
        this.username = id;
        this.password = password;
        this.runningCourses = new RunningCourses();
        this.archive = new Archive();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Archive getArchive() {
        return archive;
    }

    public RunningCourses getRunningCourses() {
        return runningCourses;
    }
}

