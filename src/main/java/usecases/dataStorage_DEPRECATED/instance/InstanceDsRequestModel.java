package usecases.dataStorage_DEPRECATED.instance;

import usecases.dataStorage_DEPRECATED.assessment.AssessmentDsRequestModel;

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
