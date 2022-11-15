package accountClasses;

public class Account {
    public String username;
    public String password;
    public RunningCourses runningCourses;
    public Archive archive;

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
}

