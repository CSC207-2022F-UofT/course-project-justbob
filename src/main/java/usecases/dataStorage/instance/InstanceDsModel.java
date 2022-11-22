package usecases.dataStorage.instance;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class InstanceDsModel implements Serializable {
    private String assessmentInstanceName;
    private LocalDate dueDate;
    private LocalTime dueTime;
    private double mark;
    private boolean isCommitted;
    private boolean isSubmitted;

    public InstanceDsModel(String assessmentInstanceName,
                           LocalDate dueDate,
                           LocalTime dueTime,
                           double mark,
                           boolean isCommitted,
                           boolean isSubmitted) {
        this.assessmentInstanceName = assessmentInstanceName;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.isCommitted = isCommitted;
        this.isSubmitted = isSubmitted;
        this.mark = mark;
    }

    public String getAssessmentInstanceName() {
        return assessmentInstanceName;
    }

    public void setAssessmentInstanceName(String assessmentInstanceName) {
        this.assessmentInstanceName = assessmentInstanceName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalTime getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalTime dueTime) {
        this.dueTime = dueTime;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public boolean isCommitted() {
        return isCommitted;
    }

    public void setCommitted(boolean committed) {
        isCommitted = committed;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
