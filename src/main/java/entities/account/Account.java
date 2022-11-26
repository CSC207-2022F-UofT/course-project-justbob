package entities.account;

// TODO: create an abstract class to represent course collections that Archive and Semester can inherit from.

public abstract class Account {
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract Archive getArchive();
    public abstract Semester getSemester();

    public abstract void setUsername(String username);
    public abstract void setPassword(String password);
    public abstract void setArchive(Archive archive);
    public abstract void setSemester(Semester semester);

    //TODO: implement a static method to check if password is valid (more than 8 characters, etc.)

    public interface AccountFactory {
        Account createAccount();
    }
}

