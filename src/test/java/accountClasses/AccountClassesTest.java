package accountClasses;

import courseManager.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountClassesTest {
    private final Account goodAccount1 = new Account("Bobby001", "goodbob1998");
    private final Account duplicateAccount = new Account("Bobby001", "goodbob1997");
    private final Account badAccount = new Account("Bob", "goodbob1996");
    private final Course course1 = new Course("CSC101", "Intro to CS", "Fall 2021", true, 1.0F);
    private final Course course2 = new Course("CSC207", "Software Design", "Fall 2022", false, 0.5F);
    private Archive testArchive = new Archive();
    private RunningCourses testSemster = new RunningCourses();

    private final AccountInteractor testInteractor = new AccountInteractor();

    @Test
    public void addGoodAccount() {
        testInteractor.createAccount(goodAccount1.getUsername(), goodAccount1.getPassword());
        Assertions.assertEquals(AccountList.accounts.get(0), goodAccount1);
    }

    @Test
    public void addDuplicateAccount() {
        testInteractor.createAccount(duplicateAccount.getUsername(), duplicateAccount.getPassword());
        Assertions.assertEquals(AccountList.accounts.size(), 1);
    }

    @Test
    public void addBadAccount() {
        testInteractor.createAccount(badAccount.getUsername(), badAccount.getPassword());
        Assertions.assertEquals(AccountList.accounts.size(), 1);
    }

    @Test
    public void loginCorrect() {
        testInteractor.login(goodAccount1.getUsername(), goodAccount1.getPassword());
        //cannot be tested without a controller
    }

    @Test
    public void loginIncorrect() {//cannot be tested without a controller
    }

    @Test
    public void archiveArchived() {
        testArchive.addArchivedCourse(course1);
        Assertions.assertEquals(testArchive.getArchived().size(), 0);
    }

    @Test
    public void archiveRunning() {
        testArchive.addArchivedCourse(course2);
        Assertions.assertEquals(testArchive.getArchived().get(0), course2);
    }

    @Test
    public void addRunningCourse() {
        testSemster.addRunningCourse(course1);
        Assertions.assertEquals(testSemster.semester.get(0), course1);
    }

    @Test
    public void addRunningCourseDuplicate() {
        testSemster.addRunningCourse(course1);
        Assertions.assertEquals(testSemster.semester.size(), 1);
    }

    @Test
    public void removeRunningCourse() {
        testSemster.removeRunningCourse(course1);
        Assertions.assertEquals(testSemster.semester.size(), 0);
    }

    @Test
    public void removeRunningCourseMissing() {
        testSemster.removeRunningCourse(course1);
        //need controller to complete test
    }

    @Test
    public void calcArchiveGpa() {
    }

    @Test
    public void calcSemesterGpa() {
    }
}