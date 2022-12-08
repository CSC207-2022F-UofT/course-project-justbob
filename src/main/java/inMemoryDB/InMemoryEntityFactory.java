package inMemoryDB;

import entities.account.Account;
import entities.account.Archive;
import entities.account.Semester;
import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.course.Course;
import entities.course.CourseEvent;
import entities.course.Outline;
import entities.weightScheme.WeightScheme;
import inMemoryDB.entities.*;
import ports.database.EntityFactory;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class InMemoryEntityFactory implements EntityFactory {
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
    public CourseEvent createCourseEvent(String title, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location) {
        return new CourseEventImpl(title, day, startTime, endTime, location);
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
            throw new IllegalArgumentException("Submit the AssessmentInstance before it is committed.");
        }

        AssessmentInstance instance = new AssessmentInstanceImpl(title);
        instance.setSubmitted(isSubmitted);
        instance.setCommitted(isCommitted);
        instance.setMark(mark);

        return instance;
    }
}
