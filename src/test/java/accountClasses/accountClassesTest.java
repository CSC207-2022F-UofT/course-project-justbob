package accountClasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class accountClassesTest {
    private Account goodAccount1 = new Account("Bobby001", "goodbob1998");
    private Account duplicateAccount = new Account("Bobby001", "goodbob1997");
    private Account shortIdAccount = new Account("Bob", "goodbob1996");
    private Account longIdAccount = new Account("BooooooobIsLoooong", "goodbob1995");
    private Account getGoodAccount2 = new Account("Jimmy001", "badjim2022");

    @Test
    public void addGoodAccount() {
    }

    @Test
    public void addBadAccount() {
    }

    @Test
    public void loginCorrect() {
    }

    @Test
    public void loginIncorrect() {
    }

    @Test
    public void archiveArchived() {
    }

    @Test
    public void archiveRunning() {
    }

    @Test
    public void addRunningCourse() {
    }

    @Test
    public void addRunningCourseDuplicate() {
    }
}