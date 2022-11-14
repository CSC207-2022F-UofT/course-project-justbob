package weightScheme;

import java.util.stream.DoubleStream;

import static java.lang.Math.round;

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
        return exactWeightEarned / (marks.length * weight.getWeightOfEachInstance());

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
