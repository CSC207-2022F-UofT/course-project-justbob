package ports.usecases.assessment.setInstanceMetaData;

public class SetInstanceMetaDataResponse {
    public String newTitle;
    public String newDeadline;

    public SetInstanceMetaDataResponse() {}

    public SetInstanceMetaDataResponse(String newTitle, String newDeadline) {
        this.newTitle = newTitle;
        this.newDeadline = newDeadline;
    }
}
