package entities.assessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;

public class AssessmentInstanceFactory implements AssessmentInstanceFactoryInterface{

    @Override
    public AssessmentInstance create(String assessmentInstanceName) {
        return new AssessmentInstance(assessmentInstanceName);
    }

    public AssessmentInstance create(String assessmentInstanceName, LocalDate dueDate, LocalTime dueTime,
                                     boolean isCommitted, boolean isSubmitted, Double mark) {
        AssessmentInstance instance = new AssessmentInstance(assessmentInstanceName);
        instance.setDueDate(dueDate);
        instance.setDueTime(dueTime);
        if (isSubmitted) {
            instance.submit();
        }
        if (isCommitted) {
            instance.commit();
        }
        instance.setMark(mark);
        return instance;
    }
}
