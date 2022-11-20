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
                .filter(mark -> mark >= 0)
                .map(mark -> mark * weight.getWeightOfEachInstance())
                .sum();
        int actual_length = (int) DoubleStream.of(marks)
                .filter(mark -> mark >= 0)
                .count();
        if (actual_length == 0) {
            return 0;
        }
        return exactWeightEarned /* (1.0/ (actual_length * weight.getWeightOfEachInstance()))*/;

    }

    @Override
    public double getTotalWeight() {
        return weight.getTotalWeight();
    }

    @Override
    public int getNumberOfInstances() {
        return weight.getNumberOfInstances();
    }

    @Override
    public double getWeightOfEachInstance() {
        return weight.getWeightOfEachInstance();
    }
}
