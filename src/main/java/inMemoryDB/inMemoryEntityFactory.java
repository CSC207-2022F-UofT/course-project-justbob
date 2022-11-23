package inMemoryDB;

import entities.account.Account;
import entities.account.archive.Archive;
import entities.account.semester.Semester;
import entities.course.Course;
import inMemoryDB.entities.AccountImpl;
import inMemoryDB.entities.ArchiveImpl;
import inMemoryDB.entities.CourseImpl;
import inMemoryDB.entities.SemesterImpl;
import ports.database.EntityFactory;

public class inMemoryEntityFactory implements EntityFactory {
    @Override
    public Account createAccount() {
        return new AccountImpl();
    }

    @Override
    public Archive createArchive() {
        return new ArchiveImpl();
    }

    @Override
    public Semester createSemester() {
        return new SemesterImpl();
    }

    @Override
    public Course createCourse() {
        return new CourseImpl();
    }
}
