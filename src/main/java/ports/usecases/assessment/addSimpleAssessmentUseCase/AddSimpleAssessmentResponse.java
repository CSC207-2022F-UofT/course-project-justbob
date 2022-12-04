package ports.usecases.assessment.addSimpleAssessmentUseCase;

import inMemoryDB.entities.AssessmentImpl;
import inMemoryDB.entities.OutlineImpl;
import usecases.dataStorage_DEPRECATED.weightScheme.WeightSchemeDsModel;

public class AddSimpleAssessmentResponse {

    public String assessmentTitle;

    public double totalWeight;

    public int maximumNumberOfInstances;

    public AddSimpleAssessmentResponse() {}

    public AddSimpleAssessmentResponse(String assessmentTitle, double totalWeight, int maximumNumberOfInstances) {
        this.assessmentTitle = assessmentTitle;
        this.totalWeight = totalWeight;
        this.maximumNumberOfInstances = maximumNumberOfInstances;
    }

}
