package CourseManager;

public class AssessmentInstance {
    private String name;
    private String deadline;
    private double mark;
    private boolean isCommitted;
    private boolean isSubmitted;

    public AssessmentInstance(String name, String deadline) {
        this.name = name;
        this.deadline = deadline;
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
    public void setMark(double mark) {
        this.mark = mark;
    }
}
