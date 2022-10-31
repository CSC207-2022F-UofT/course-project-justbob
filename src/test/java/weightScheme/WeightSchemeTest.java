package weightScheme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WeightSchemeTest {
    private Double[] marks = {1.0, 0.95, 0.8, 0.752};


    @Test
    public void SimpleWeightComputation() {
        double weightOfEachInstance = 0.25;
        WeightScheme simpleWeight = new SimpleWeight(marks.length, weightOfEachInstance);
        Assertions.assertEquals(0.8755, simpleWeight.computeWeight(Arrays.asList(marks)));
    }
}
