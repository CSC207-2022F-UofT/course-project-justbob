package weightScheme;

public class Weight {
    private int numberOfInstances;
    private double weightOfEachInstance;

    public Weight(int numberOfInstances, double weightOfEachInstance) {
        this.numberOfInstances = numberOfInstances;
        this.weightOfEachInstance = weightOfEachInstance;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }
    public double getWeightOfEachInstance() {
        return weightOfEachInstance;
    }

    public double getTotalWeight() {
        return numberOfInstances * weightOfEachInstance;
    }
}
