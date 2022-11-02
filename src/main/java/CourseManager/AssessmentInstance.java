package CourseManager;

public class AssessmentInstance {
    private String assessmentInstanceName;
    private String date;
    private double mark;
    public boolean isCommitted;
    public boolean isSubmitted;

    public AssessmentInstance(String assessmentInstanceName, String deadline) {
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

    public String getName() {
        return assessmentInstanceName;
    }

    public void setName(String name) {
        this.assessmentInstanceName = name;
    }

    public String getDeadline() {
        return date;
    }

    public void setDeadline(String deadline) {
        this.date = deadline;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getMark() {
        return mark;
    }
}
