package entities.account;

import entities.archive.Archive;
import entities.semester.Semester;

public class Account implements AccountInterface {
    private final String username;
    private final String password;
    private Semester semester;
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
        this.semester = new Semester();
        this.archive = new Archive();
    }
    @Override
    public String getUsername(){
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Archive getArchive() {
        return archive;
    }

    @Override
    public Semester getSemester() {
        return semester;
    }
}

