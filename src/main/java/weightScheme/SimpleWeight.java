package weightScheme;

import java.util.ArrayList;
import java.util.List;

public class SimpleWeight implements WeightScheme {
    private Weight weight;

    public SimpleWeight(int numberOfInstances, double weightOfEachInstance) {
        this.weight = new Weight(numberOfInstances, weightOfEachInstance);
    }
    @Override
    public double computeWeight(List<Double> marks) {
        return new ArrayList<>(marks).stream()
                .mapToDouble(mark -> mark * weight.getWeightOfEachInstance())
                .sum();
    }

    @Override
    public double getTotalWeight() {
        return weight.getTotalWeight();
    }

    @Override
    public int getNumberOfInstances() {
        return weight.getNumberOfInstances();
    }
}
