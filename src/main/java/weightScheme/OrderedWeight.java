package weightScheme;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;

public class OrderedWeight implements WeightScheme {
    private Weight[] orderedWeights;

    public OrderedWeight(Weight[] orderedWeights) {
        this.orderedWeights = orderedWeights;
    }

    @Override
    public double computeWeight(double[] marks) {
        double result = 0;
        int current_index = 0;
        for (Weight weight : orderedWeights) {
            result += DoubleStream.of(marks)
                    .sorted()
                    .skip(current_index)
                    .limit(weight.getNumberOfInstances())
                    .map(mark -> mark * weight.getWeightOfEachInstance())
                    .sum();
            current_index += weight.getNumberOfInstances();
        }
        return result;
    }

    @Override
    public int getNumberOfInstances() {
        return Stream.of(orderedWeights)
                .mapToInt(weight -> weight.getNumberOfInstances())
                .sum();
    }

    @Override
    public double getTotalWeight() {
        return Stream.of(orderedWeights)
                .mapToDouble(weight -> weight.getTotalWeight())
                .sum();
    }
}
