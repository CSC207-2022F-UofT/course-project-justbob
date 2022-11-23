package ports.database;

import entities.account.Account.AccountFactory;
import entities.account.archive.Archive.ArchiveFactory;
import entities.account.semester.Semester.SemesterFactory;
import entities.course.Course.CourseFactory;

public interface EntityFactory extends
        AccountFactory,
        SemesterFactory,
        ArchiveFactory,
        CourseFactory
{}
