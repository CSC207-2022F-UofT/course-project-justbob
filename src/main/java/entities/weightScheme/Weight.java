package entities.weightScheme;

public class Weight {
    private int numberOfInstances;
    private double weightOfEachInstance;

    /**
     * Create a new Weight object
     *
     * @param numberOfInstances    must be positive
     * @param weightOfEachInstance must be between 0 and 1
     */
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
