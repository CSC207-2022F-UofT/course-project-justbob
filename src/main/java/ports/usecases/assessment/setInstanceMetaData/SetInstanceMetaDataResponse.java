package ports.usecases.assessment.setInstanceMetaData;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SetInstanceMetaDataResponse {
    public String newTitle;
    public LocalDateTime newDeadline;

    public SetInstanceMetaDataResponse() {}

    public SetInstanceMetaDataResponse(String newTitle, LocalDateTime newDeadline) {
        this.newTitle = newTitle;
        this.newDeadline = newDeadline;
    }
}
