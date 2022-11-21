package entities.assessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;

public class AssessmentInstance {
    private String assessmentInstanceName;
    private LocalDate dueDate;
    private LocalTime dueTime;
    private Double mark;
    private boolean isCommitted;
    private boolean isSubmitted;

    /**
     * Create a new AssessmentInstance object with the given name and date
     * @param assessmentInstanceName the name of the assessment instance
     *                               e.g. "Quiz #1", "Midterm #1", "Homework Assignment #1"
     */

    public AssessmentInstance(String assessmentInstanceName) {
        this.assessmentInstanceName = assessmentInstanceName;
        this.isCommitted = false;
        this.isSubmitted = false;
        this.dueDate = null;
        this.dueTime = null;
        this.mark = null;
    }

    public void commit() {
        isSubmitted = true;
        isCommitted = true;
    }
    public void uncommit() {
        isCommitted = false;
    }
    public void submit() {
        isSubmitted = true;
    }
    public void unsubmit() throws IllegalStateException {
        if (!isCommitted) {
            isSubmitted = false;
        }
        else{
            throw new IllegalStateException("Cannot unsubmit a committed instance. Instance must be uncommitted first.");
        }
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

    public void setMark(double mark) throws IllegalArgumentException {
        if (mark >= 0 && mark <= 1) {
            this.mark = mark;
        }
        else {
            throw new IllegalArgumentException("Mark must be between 0 and 1");
        }
    }

    public Double getMark() {
        return mark;
    }
}
