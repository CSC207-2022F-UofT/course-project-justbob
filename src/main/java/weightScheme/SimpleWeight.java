package weightScheme;

import java.util.stream.DoubleStream;

public class SimpleWeight implements WeightScheme {
    private Weight weight;

    public SimpleWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public double computeWeighted(double[] marks) {
        double exactWeightEarned = DoubleStream.of(marks)
                .map(mark -> mark * weight.getWeightOfEachInstance())
                .sum();
        return exactWeightEarned;
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
