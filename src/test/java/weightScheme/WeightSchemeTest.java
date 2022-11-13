package weightScheme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WeightSchemeTest {
    private double[] marks = {100, 95, 80, 75.2, 64, 0, 99.5};

    private Weight[] weights = {
            new Weight(1, 0.05),
            new Weight(2, 0.30),
            new Weight(4, 0.025)
    };

    @Test
    public void SimpleWeightComputation() {
        Weight weight = new Weight(marks.length, 0.05);
        WeightScheme simpleWeight = new SimpleWeight(weight);
        Assertions.assertEquals(25.685, simpleWeight.computeWeighted(marks), 0.001);
    }

    @Test
    public void SimpleWeightRunningComputation() {
        double[] test_marks = {75, 50};
        Weight weight = new Weight(3, 0.10);
        WeightScheme simpleWeight = new SimpleWeight(weight);
        Assertions.assertEquals(18.75, simpleWeight.computeWeighted(test_marks), 0.001);
    }

    @Test
    public void OrderedWeightNumberOfInstances() {
        Assertions.assertEquals(new OrderedWeight(weights).getNumberOfInstances(), 7);
    }

    @Test
    public void OrderedWeightTotalWeight() {
        Assertions.assertEquals(new OrderedWeight(weights).getTotalWeight(), 0.75);
    }

    @Test
    public void OrderedWeightComputation() {
        Assertions.assertEquals(51.1225, new OrderedWeight(weights).computeWeighted(marks), 0.001);
    }

    @Test
    public void OrderedWeightRunningComputation() {
        double[] test_marks = {
                50, 100, 80
        };
        // Top Mark: 20%, Next 3 highest: each 10%, Lowest mark: 5%. Total marks: 5. Total Weight: 55%.
        Weight[] test_weights = {
                new Weight(1, 0.05),
                new Weight(3, 0.1),
                new Weight(1, 0.2),
        };
        Assertions.assertEquals(45.375, new OrderedWeight(test_weights).computeWeighted(test_marks), 0.001);

    }
}
