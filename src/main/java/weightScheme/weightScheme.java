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
    public float computeWeight(List<Float> marks);
    public float getTotalWeight();
    public int getNumberOfInstances();
}
