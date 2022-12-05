package ports.usecases.assessment.setInstanceMetaData;

import java.time.LocalDateTime;

public class SetInstanceMetaDataRequest {
    public String username; /*abstract to path class*/

    public String courseCode; /*abstract to path class*/

    public String assessmentTitle; /*abstract to path class*/

    public int instanceNumber; /*abstract to path class*/

    public String newTitle;

    public LocalDateTime newDeadline;

    public SetInstanceMetaDataRequest() {};

    public SetInstanceMetaDataRequest(String username, String courseCode, String assessmentTitle, int instanceNumber,
                                      String newTitle, LocalDateTime newDeadline) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
        this.instanceNumber = instanceNumber;
        this.newTitle = newTitle;
        this.newDeadline = newDeadline;
    }
}
