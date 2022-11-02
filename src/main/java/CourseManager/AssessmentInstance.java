package CourseManager;


import java.sql.Time;
import java.time.LocalDate;

public class AssessmentInstance {
    private String assessmentInstanceName;
    private LocalDate date;
    private double mark;
    private boolean isCommitted;
    private boolean isSubmitted;

    public AssessmentInstance(String assessmentInstanceName, LocalDate date) {
        this.assessmentInstanceName = assessmentInstanceName;
        this.date = date;
        this.isCommitted = false;
        this.isSubmitted = false;
    }

    public void commit() {
        isCommitted = true;
    }
    public void uncommit() {
        isCommitted = false;
    }
    public void submit() {
        isSubmitted = true;
    }
    public void unsubmit() {
        isSubmitted = false;
    }

    public boolean isCommitted() {
        return isCommitted;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public String getName() {
        return assessmentInstanceName;
    }

    public void setName(String name) {
        this.assessmentInstanceName = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getMark() {
        return mark;
    }
}
