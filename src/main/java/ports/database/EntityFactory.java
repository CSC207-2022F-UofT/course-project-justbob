package ports.database;

import entities.account.Account.AccountFactory;
import entities.account.Archive.ArchiveFactory;
import entities.account.Semester.SemesterFactory;
import entities.assessment.Assessment.AssessmentFactory;
import entities.assessment.AssessmentInstance.AssessmentInstanceFactory;
import entities.course.Course.CourseFactory;
import entities.course.Outline.OutlineFactory;


public interface EntityFactory extends
        AccountFactory,
        SemesterFactory,
        ArchiveFactory,
        CourseFactory,
        OutlineFactory,
        AssessmentFactory,
        AssessmentInstanceFactory
{}
