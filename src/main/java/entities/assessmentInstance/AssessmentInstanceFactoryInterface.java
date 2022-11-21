package entities.assessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AssessmentInstanceFactoryInterface {
    AssessmentInstance create(String assessmentInstanceName);
    AssessmentInstance create(String assessmentInstanceName, LocalDate dueDate, LocalTime dueTime, Double mark,
                              boolean isCommitted, boolean isSubmitted);
}
