package entities.weightScheme;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;

public class OrderedWeight implements WeightScheme {
    private Weight[] orderedWeights;

    /**
     * Create new OrderedWeight, with (orderedWeights) being an array of Weight objects
     * @param orderedWeights must be sorted from lowest impact to highest impact.
     */
    public OrderedWeight(Weight[] orderedWeights) {
        this.orderedWeights = orderedWeights;
    }

    /*
    private double getWeightPossible(int numberOfMarks) {
        int number_counted = 0;
        float result = 0f;
        int i = orderedWeights.length - 1;
        while (numberOfMarks - number_counted > 0) {
            Weight weight = orderedWeights[i];
            int numberInWeight = 0;
            if (number_counted + weight.getNumberOfInstances() <= numberOfMarks) {
                numberInWeight = weight.getNumberOfInstances();
            } else {
                numberInWeight = numberOfMarks - number_counted;
            }
            number_counted += numberInWeight;
            result += numberInWeight * weight.getWeightOfEachInstance();
            --i;
        }
        return result;
    }*/

    @Override
    public double computeWeighted(double[] marks) {
        double[] paddedMarks = Arrays.copyOf(marks, getNumberOfInstances());
        double exactWeightEarned = 0;
        int numberOfMarksComputed = 0;
        for (Weight weight : orderedWeights) {
            exactWeightEarned += DoubleStream.of(paddedMarks)
                    .sorted()
                    .skip(numberOfMarksComputed)
                    .limit(weight.getNumberOfInstances())
                    .map(mark -> mark * weight.getWeightOfEachInstance())
                    .sum()
            ;
            numberOfMarksComputed += weight.getNumberOfInstances();
        }
        return exactWeightEarned;
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
