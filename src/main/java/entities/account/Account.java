package entities.account;

import entities.course.Course;

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

    /*
    public void ArchiveCourse(Course course) throws IllegalArgumentException {
        if (!getSemester().getRunningCourses().contains(course)) {
            throw new IllegalArgumentException("course is not in this Account's semester");
        }
        getSemester().removeCourse(course);
        getArchive().addCourse(course, getSemester().getTitle());
    }
     */

    public interface AccountFactory {
        Account createAccount();
    }
}

