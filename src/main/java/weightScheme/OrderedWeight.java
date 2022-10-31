package weightScheme;

import java.util.stream.Stream;

public class OrderedWeight implements WeightScheme {
    private Weight[] orderedWeights;

    @Override
    public double computeWeight(double[] marks) {
        return 0;
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
