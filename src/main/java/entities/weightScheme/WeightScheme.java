package entities.weightScheme;

import java.util.List;

public interface WeightScheme {
    /**
     * Compute the average mark earned with (marks) according to this weightScheme.
     * <p>
     * Preconditions:
     * marks.length <= getNumberOfInstances()
     * for each mark in marks, 0 <= mark <= 100
     *
     * @param marks
     * @return
     */
    public double computeWeighted(double[] marks);

    public double getTotalWeight();

    public int getNumberOfInstances();
}
