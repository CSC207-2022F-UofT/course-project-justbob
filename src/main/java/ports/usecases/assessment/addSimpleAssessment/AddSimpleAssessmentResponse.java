package ports.usecases.assessment.addSimpleAssessment;

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
