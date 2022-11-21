package usecases.dataStorage.instance;

import java.time.LocalDate;

public class InstanceDsModel {
    private String assessmentInstanceName;
    private LocalDate date;
    private double mark;
    private boolean isCommitted;
    private boolean isSubmitted;

    public InstanceDsModel(String assessmentInstanceName,
                           LocalDate date,
                           double mark,
                           boolean isCommitted,
                           boolean isSubmitted) {
        this.assessmentInstanceName = assessmentInstanceName;
        this.date = date;
        this.mark = mark;
        this.isCommitted = isCommitted;
        this.isSubmitted = isSubmitted;
    }

    public String getAssessmentInstanceName() {
        return assessmentInstanceName;
    }

    public void setAssessmentInstanceName(String assessmentInstanceName) {
        this.assessmentInstanceName = assessmentInstanceName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
