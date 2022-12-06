package ports.usecases.assessment.setMark;

public class SetMarkRequest {
    public String username; /*abstract to path class*/

    public String courseCode; /*abstract to path class*/

    public String assessmentTitle; /*abstract to path class*/

    public int instanceNumber; /*abstract to path class*/

    public double mark;

    public SetMarkRequest() {}

    public SetMarkRequest(String username, String courseCode, String assessmentTitle, int instanceNumber, double mark) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
        this.instanceNumber = instanceNumber;
        this.mark = mark;
    }
}
