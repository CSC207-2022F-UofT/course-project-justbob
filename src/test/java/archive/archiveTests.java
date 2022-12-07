package archive;

import entities.account.Account;
import entities.account.Archive;
import entities.account.Semester;
import entities.course.Course;
import inMemoryDB.InMemoryEntityFactory;
import inMemoryDB.InMemoryEntityGateway;
import inMemoryDB.entities.AccountImpl;
import inMemoryDB.entities.CourseImpl;
import inMemoryDB.entities.OutlineImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ports.database.EntityGateway;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseInputBoundary;
import ports.usecases.account.archiveCourse.ArchiveCourseInputBoundary;
import ports.usecases.account.archiveCourse.ArchiveCourseInputBoundary.CourseNotCompletedError;
import usecases.account.ArchiveCourseUseCase;
import usecases.account.RemoveArchiveCourseUseCase;

import java.util.ArrayList;

public class archiveTests {
    private EntityGateway entityGateway;
    private InMemoryEntityFactory factory;

    /*@Test
    public void ArchiveCourseTest(){
        this.entityGateway = new InMemoryEntityGateway();
        this.factory = new InMemoryEntityFactory();
        Account account = factory.createAccount();
        Archive archive = factory.createArchive();
        Course course = factory.createCourse();
        Semester semester = factory.createSemester();
        account.setArchive(archive);
        account.setSemester(semester);
        account.setUsername("bob12345");
        course.setCourseCode("CSC207");
        course.setOutline(new OutlineImpl());
        semester.addCourse(course);
        entityGateway.saveAccount(account);
        ArchiveCourseUseCase myUseCase = new ArchiveCourseUseCase(entityGateway);
        myUseCase.execute("bob12345", "CSC207");
    }*/

    @Test
    public void RemoveCourseTest(){
        this.entityGateway = new InMemoryEntityGateway();
        this.factory = new InMemoryEntityFactory();
        Account account = factory.createAccount();
        Archive archive = factory.createArchive();
        Course course = factory.createCourse();
        account.setArchive(archive);
        account.setUsername("bob12345");
        course.setCourseCode("CSC207");
        archive.addCourse(course, "Fall 2022");
        entityGateway.saveAccount(account);
        RemoveArchiveCourseUseCase myUseCase = new RemoveArchiveCourseUseCase(entityGateway);
        myUseCase.execute("bob12345", "CSC207");
        Assertions.assertEquals(new ArrayList<>(), entityGateway.loadAccount("bob12345").getArchive().getCourses());
    }
}
