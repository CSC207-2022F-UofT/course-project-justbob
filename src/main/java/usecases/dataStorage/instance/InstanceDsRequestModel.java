package usecases.dataStorage.instance;

import usecases.dataStorage.assessment.AssessmentDsRequestModel;

public class InstanceDsRequestModel extends AssessmentDsRequestModel {
    private int instanceIndex;

    public InstanceDsRequestModel(String username, String courseCode, String assessmentTitle, int instanceIndex) {
        super(username, courseCode, assessmentTitle);
        this.instanceIndex = instanceIndex;
    }

    public int getInstanceIndex() {
        return instanceIndex;
    }
}
