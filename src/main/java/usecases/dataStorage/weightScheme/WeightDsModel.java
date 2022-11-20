package usecases.dataStorage.weightScheme;

public class WeightDsModel {
    private int numberOfInstances;
    private double weightOfEachInstance;

    public WeightDsModel(int numberOfInstances, double weightOfEachInstance) {
        this.numberOfInstances = numberOfInstances;
        this.weightOfEachInstance = weightOfEachInstance;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public double getWeightOfEachInstance() {
        return weightOfEachInstance;
    }
}
