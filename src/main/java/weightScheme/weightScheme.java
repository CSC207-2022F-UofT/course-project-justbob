package weightScheme;

import java.util.List;

public interface weightScheme {
    /**
     * Compute the weight earned with (marks) according to this weightScheme.
     *
     * Precondition: marks.length == getNumberOfInstances()
     * @param marks
     * @return
     */
    public double computeWeight(List<Double> marks);
    public double getTotalWeight();
    public int getNumberOfInstances();
}
