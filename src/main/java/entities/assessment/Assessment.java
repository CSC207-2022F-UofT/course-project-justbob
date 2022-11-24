package entities.assessment;

import entities.assessment.assessmentInstance.AssessmentInstance;
import entities.assessment.instanceList.InstanceList;
import weightScheme.WeightScheme;

import java.util.Arrays;

public abstract class Assessment {
    public abstract String getTitle();
    public abstract WeightScheme getWeightScheme();
    public abstract InstanceList getInstanceList();

    public abstract void setTitle(String title);
    public abstract void setWeightScheme(WeightScheme weightScheme);
    public abstract void setInstanceList(InstanceList instanceList);

    public double getTotalWeight() {
        return getWeightScheme().getTotalWeight();
    }

    public int getTotalNumberOfInstances() {
        return getWeightScheme().getNumberOfInstances();
    }

    // TODO: test that this works!
    private double getMaxWeight(int numberOfInstances) {
        double[] marksToWeigh = new double[getWeightScheme().getNumberOfInstances()];
        Arrays.fill(marksToWeigh, 0, numberOfInstances, 100);
        return getWeightScheme().computeWeighted(marksToWeigh) / 100;
    }

    public double getCommittedWeight() {
        return getMaxWeight(getInstanceList().getNumberOfCommittedInstances());
    }

    public double getSubmittedWeight() {
        return getMaxWeight(getInstanceList().getNumberOfSubmittedInstances());
    }

    // TODO: make this use number of marked instances instead.
    public double getHypotheticalWeight() {
        return getMaxWeight(getInstanceList().getTotalNumberOfInstances());
    }

    public interface AssessmentFactory {
        public Assessment createAssessment();
    }
}
