package inMemoryDB.entities;

import entities.assessment.AssessmentInstance;

import java.time.LocalDateTime;

public class AssessmentInstanceImpl extends AssessmentInstance {
    private String singularTitle;
    private LocalDateTime deadline;
    private boolean isCommitted;
    private boolean isSubmitted;
    private Double mark;

    public AssessmentInstanceImpl(String singularTitle) {
        this.singularTitle = singularTitle;
    }

    @Override
    public String getTitle() {
        return singularTitle;
    }

    @Override
    public void setTitle(String newTitle) {
        this.singularTitle = newTitle;
    }

    @Override
    public LocalDateTime getDeadline() {
        return deadline;
    }

    @Override
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean isCommitted() {
        return isCommitted;
    }

    @Override
    public void setCommitted(boolean committed) {
        isCommitted = committed;
    }

    @Override
    public boolean isSubmitted() {
        return isSubmitted;
    }

    @Override
    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    @Override
    public Double getMark() {
        return mark;
    }

    @Override
    public void setMark(Double mark) {
        this.mark = mark;
    }
}
