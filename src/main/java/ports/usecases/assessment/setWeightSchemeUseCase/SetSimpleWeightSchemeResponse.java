package ports.usecases.assessment.setWeightSchemeUseCase;

public class SetSimpleWeightSchemeResponse {

    public double totalWeight;

    public int maximumNumberOfInstances;

    public SetSimpleWeightSchemeResponse() {}

    public SetSimpleWeightSchemeResponse(double totalWeight, int maximumNumberOfInstances) {
        this.totalWeight = totalWeight;
        this.maximumNumberOfInstances = maximumNumberOfInstances;
    }
}
