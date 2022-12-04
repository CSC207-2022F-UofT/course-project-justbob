package ports.usecases.assessment.setInstanceMetaDataUseCase;

public class SetInstanceMetaDataRequest {
    public String username; /*abstract to path class*/

    public String courseCode; /*abstract to path class*/

    public String assessmentTitle; /*abstract to path class*/

    public int instanceNumber; /*abstract to path class*/

    public String newTitle;

    public String newDeadline;

    public SetInstanceMetaDataRequest() {};

    public SetInstanceMetaDataRequest(String username, String courseCode, String assessmentTitle, int instanceNumber,
                                      String newTitle, String newDeadline) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
        this.instanceNumber = instanceNumber;
        this.newTitle = newTitle;
        this.newDeadline = newDeadline;
    }
}
