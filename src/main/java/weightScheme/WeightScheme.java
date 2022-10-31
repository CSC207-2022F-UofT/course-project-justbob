package weightScheme;

import java.util.List;

public interface WeightScheme {
    /**
     * Compute the weight earned with (marks) according to this weightScheme.
     *
     * Precondition: marks.length == getNumberOfInstances()
     * @param marks
     * @return
     */
    public double computeWeight(double[] marks);
    public double getTotalWeight();
    public int getNumberOfInstances();
}
