package inMemoryDB;

import entities.account.Account;
import entities.account.Archive;
import entities.account.Semester;
import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.course.Course;
import entities.course.Outline;
import inMemoryDB.entities.*;
import ports.database.EntityFactory;
import weightScheme.WeightScheme;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Outline createOutline() {
        return new OutlineImpl();
    }

    @Override
    public Assessment createAssessment(String title, WeightScheme weightScheme) {
        return new AssessmentImpl(title, weightScheme);
    }

    @Override
    public Assessment createAssessment(String title, WeightScheme weightScheme, List<AssessmentInstance> instances) {
        if (instances.size() > weightScheme.getNumberOfInstances()) {
            throw new IllegalArgumentException("instances size exceeds weightScheme's number of instances");
        }
        Assessment assessment = createAssessment(title, weightScheme);
        for (AssessmentInstance instance : instances) {
            assessment.addInstance(instance);
        }
        return assessment;
    }

    @Override
    public AssessmentInstance createAssessmentInstance(String title, LocalDateTime deadline, Double mark,
                                                       boolean isCommitted, boolean isSubmitted)
                                                            throws IllegalArgumentException {
        if (mark != null && !AssessmentInstance.isMarkValid(mark)) {
            throw new IllegalArgumentException(String.format("Mark %f is not valid", mark));
        }
        if (isCommitted && !isSubmitted) {
            // TODO: is this a valid exception? Would it be better to override isSubmitted as true?
            throw new IllegalArgumentException("AssessmentIntance cannot be committed and not submitted");
        }

        AssessmentInstance instance = new AssessmentInstanceImpl(title, deadline);
        instance.setSubmitted(isSubmitted);
        instance.setCommitted(isCommitted);
        instance.setMark(mark);

        return instance;
    }
}
