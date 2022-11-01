package weightScheme;

import java.util.List;

public interface WeightScheme {
    /**
     * Compute the average mark earned with (marks) according to this weightScheme.
     *
     * Precondition: marks.length == getNumberOfInstances()
     * @param marks
     * @return
     */
    public double computeWeighted(double[] marks);
    public double getTotalWeight();
    public int getNumberOfInstances();
}
