package weightScheme;

public class Weight {
    private int numberOfInstances;
    private float weightOfEachInstance;

    public Weight(int numberOfInstances, float weightOfEachInstance) {
        this.numberOfInstances = numberOfInstances;
        this.weightOfEachInstance = weightOfEachInstance;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }
    public float getWeightOfEachInstance() {
        return weightOfEachInstance;
    }

    public float getTotalWeight() {
        return numberOfInstances * weightOfEachInstance;
    }
}
