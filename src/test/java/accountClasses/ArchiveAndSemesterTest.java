package accountClasses;

import entities.account.Account;
import entities.archive.Archive;
import entities.semester.Semester;
import entities.course.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArchiveAndSemesterTest {
    private final Account goodCommonAccount1 = new Account("Bobby001", "goodbob1998");
    private final Account duplicateCommonAccount = new Account("Bobby001", "goodbob1997");
    private final Account badCommonAccount = new Account("Bob", "goodbob1996");
    private final Course course1 = new Course("CSC101", "Intro to CS", "Fall 2021", true, 1.0F);
    private final Course course2 = new Course("CSC207", "Software Design", "Fall 2022", false, 0.5F);
    private Archive testArchive = new Archive();
    private Semester testSemester = new Semester();

    @Test
    public void addCourseToArchive(){
        testArchive.addCourse(course1);
        Assertions.assertEquals(testArchive.getCourses().get(0), course1);
        Assertions.assertTrue(course1.isArchived());
    }

    @Test
    public void removeCourseFromArchive(){
        testArchive.addCourse(course1);
        testArchive.RemoveCourse(course1);
        Assertions.assertTrue(testArchive.getCourses().isEmpty());
        Assertions.assertFalse(course1.isArchived());
    }

    @Test
    public void addCourseToSemester(){
        testSemester.addCourse(course1);
        Assertions.assertEquals(testSemester.getSemester().get(0), course1);
    }
    @Test
    public void removeCourseFromSemester(){
        testSemester.addCourse(course1);
        testSemester.removeCourse(course1);
        Assertions.assertTrue(testSemester.getSemester().isEmpty());
    }

    @Test
    public void addDuplicateCourseToSemester(){
        testSemester.addCourse(course1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> testSemester.addCourse(course1));
    }
}