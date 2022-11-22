package entities.assessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;

public class AssessmentInstanceFactory {

    public AssessmentInstance create(String assessmentInstanceName) {
        return new AssessmentInstance(assessmentInstanceName);
    }

    /**
     * Create a new assessment instance with all data. Useful for constructing instances from a data storage model.
     * @param assessmentInstanceName
     * @param dueDate
     * @param dueTime
     * @param mark
     * @param isCommitted
     * @param isSubmitted
     * @return the constructed AssessmentInstance.
     */
    public AssessmentInstance create(String assessmentInstanceName, LocalDate dueDate, LocalTime dueTime, Double mark,
                                        boolean isCommitted, boolean isSubmitted) {
        AssessmentInstance assessmentInstance = new AssessmentInstance(assessmentInstanceName);
        assessmentInstance.setDueDate(dueDate);
        assessmentInstance.setDueTime(dueTime);
        assessmentInstance.setMark(mark);
        if (isSubmitted) {
            assessmentInstance.submit();
        }
        if (isCommitted) {
            assessmentInstance.commit();
        }
        return assessmentInstance;
    }
}
