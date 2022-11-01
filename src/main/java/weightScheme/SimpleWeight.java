package weightScheme;

import java.util.stream.DoubleStream;

public class SimpleWeight implements WeightScheme {
    private Weight weight;

    public SimpleWeight(Weight weight) {
        this.weight = weight;
    }

    public SimpleWeight(int numberOfInstances, double weightOfEachInstance) {
        this.weight = new Weight(numberOfInstances, weightOfEachInstance);
    }

    @Override
    public double computeWeight(double[] marks) {
        return DoubleStream.of(marks)
                .map(mark -> mark * weight.getWeightOfEachInstance())
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
