package entities.assessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AssessmentInstanceInterface {

    void commit();

    void uncommit();

    void submit();

    void unsubmit();

    boolean isCommitted();

    boolean isSubmitted();

    String getName();

    void setName(String name);

    LocalDate getDueDate();

    void setDueDate(LocalDate dueDate);

    LocalTime getDueTime();

    void setDueTime(LocalTime dueTime);

    void setMark(double mark);

    Double getMark();
}
