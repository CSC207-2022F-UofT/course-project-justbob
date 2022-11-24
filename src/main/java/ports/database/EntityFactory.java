package ports.database;

import entities.account.Account.AccountFactory;
import entities.account.archive.Archive.ArchiveFactory;
import entities.account.semester.Semester.SemesterFactory;
import entities.assessment.Assessment.AssessmentFactory;
import entities.course.Course.CourseFactory;
import entities.course.outline.Outline.OutlineFactory;


public interface EntityFactory extends
        AccountFactory,
        SemesterFactory,
        ArchiveFactory,
        CourseFactory,
        OutlineFactory,
        AssessmentFactory
{}
