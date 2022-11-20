package usecases.dataStorage;

public class InstanceDsRequestModel {
    private String username;
    private String courseCode;
    private String assessmentTitle;
    private int instanceIndex;

    public InstanceDsRequestModel(String username,
                                  String courseCode,
                                  String assessmentTitle,
                                  int instanceIndex) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
        this.instanceIndex = instanceIndex;
    }
}
