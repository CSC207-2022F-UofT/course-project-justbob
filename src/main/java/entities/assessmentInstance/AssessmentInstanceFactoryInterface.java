package entities.assessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AssessmentInstanceFactoryInterface {
    AssessmentInstance create(String assessmentInstanceName);
    public AssessmentInstance create(String assessmentInstanceName, LocalDate dueDate, LocalTime dueTime,
                                     boolean isCommitted, boolean isSubmitted, Double mark);
}
