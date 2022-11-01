package weightScheme;

import java.util.stream.Stream;
import java.util.stream.DoubleStream;

public class OrderedWeight implements WeightScheme {
    private Weight[] orderedWeights;

    /**
     * Create new OrderedWeight, with (orderedWeights) sorted from lowest impact to highest impact.
     * @param orderedWeights
     */
    public OrderedWeight(Weight[] orderedWeights) {
        this.orderedWeights = orderedWeights;
    }

    @Override
    public double computeWeighted(double[] marks) {
        double result = 0;
        int numberOfMarksComputed = 0;
        for (Weight weight : orderedWeights) {
            result += DoubleStream.of(marks)
                    .sorted()
                    .skip(numberOfMarksComputed)
                    .limit(weight.getNumberOfInstances())
                    .map(mark -> mark * weight.getWeightOfEachInstance())
                    .sum()
                    ;
            numberOfMarksComputed += weight.getNumberOfInstances();
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
