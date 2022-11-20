package usecases.dataStorage;

import java.time.LocalDate;

public class InstanceDsResponseModel {
    private String assessmentInstanceName;
    private LocalDate date;
    private double mark;
    private boolean isCommitted;
    private boolean isSubmitted;

    public InstanceDsResponseModel(String assessmentInstanceName,
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

    public LocalDate getDate() {
        return date;
    }

    public double getMark() {
        return mark;
    }

    public boolean isCommitted() {
        return isCommitted;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }
}
