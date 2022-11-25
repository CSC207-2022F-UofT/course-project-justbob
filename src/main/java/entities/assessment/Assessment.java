package entities.assessment;

import weightScheme.WeightScheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Assessment {
    public abstract String getTitle();
    public abstract WeightScheme getWeightScheme();
    public abstract ArrayList<AssessmentInstance> getInstances();

    public abstract void setTitle(String title);
    public abstract void setWeightScheme(WeightScheme weightScheme);

    public abstract void addInstance(AssessmentInstance instance);
    public abstract void removeInstance(AssessmentInstance instance);

    public double getTotalWeight() {
        return getWeightScheme().getTotalWeight();
    }

    public int getTotalNumberOfInstances() {
        return getWeightScheme().getNumberOfInstances();
    }

    public int getCurrentNumberOfInstances() {
        return getInstances().size();
    }

    public int getNumberOfCommittedInstances() {
        return (int) getInstances().stream()
                .filter(instance -> instance.isCommitted())
                .count();
    }

    public int getNumberOfSubmittedInstances() {
        return (int) getInstances().stream()
                .filter(instance -> instance.isSubmitted())
                .count();
    }



    public double[] getCommittedMarks() {
        return getInstances().stream()
                .filter(instance -> instance.isCommitted())
                .mapToDouble(instance -> instance.getMark())
                .toArray();
    }

    public double[] getAllMarks() {
        return getInstances().stream()
                .filter(instance -> instance.getMark() != null)
                .mapToDouble(instance -> instance.getMark())
                .toArray();
    }

    // TODO: test that this works!
    private double getMaxWeight(int numberOfInstances) {
        double[] marksToWeigh = new double[getWeightScheme().getNumberOfInstances()];
        Arrays.fill(marksToWeigh, 0, numberOfInstances, 100);
        return getWeightScheme().computeWeighted(marksToWeigh) / 100;
    }

    public double getCommittedWeight() {
        return getMaxWeight(getNumberOfCommittedInstances());
    }

    public double getSubmittedWeight() {
        return getMaxWeight(getNumberOfSubmittedInstances());
    }

    // TODO: make this use number of marked instances instead.
    public double getHypotheticalWeight() {
        return getMaxWeight(getTotalNumberOfInstances());
    }

    // TODO: reimplement toSinglar function

    public interface AssessmentFactory {
        Assessment createAssessment(String title, WeightScheme weightScheme);
        Assessment createAssessment(String title, WeightScheme weightScheme, List<AssessmentInstance> instances);
    }
}
