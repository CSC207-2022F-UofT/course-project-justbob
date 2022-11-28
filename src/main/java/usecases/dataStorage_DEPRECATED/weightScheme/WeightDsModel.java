package usecases.dataStorage_DEPRECATED.weightScheme;

import java.io.Serializable;

public class WeightDsModel implements Serializable {
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
