package entities.assessment;

import entities.instanceList.InstanceList;
import weightScheme.WeightScheme;

public class Assessment {
    public String title;
    public final InstanceList instanceList;
    public WeightScheme weightScheme;

    /**
     * Create a new Assessment object with a title and an associated WeightScheme
     * @param title The title of the assessment
     *              e.g. "Quizzes", "Midterm", "Homework Assignments"
     * @param weightScheme The WeightScheme associated with the assessment
     *              e.g. "Quizzes" might be associated with a SimpleWeight scheme with a weight of 10% for each quiz
     */

    public Assessment(String title, WeightScheme weightScheme) {
        this.title = title;
        this.weightScheme = weightScheme;
        this.instanceList = new InstanceList(this.title, weightScheme.getNumberOfInstances());
    }

    public double getTotalWeight() {
        return weightScheme.getTotalWeight();
    }

    public double getSubmittedWeight() {
        double[] submittedMarksForWeight = new double[this.instanceList.getTotalNumberOfInstances()];
        for (int i = 0; i < this.instanceList.getTotalNumberOfInstances(); i++) {
            if (this.instanceList.getInstanceData(i).isSubmitted()) {
                submittedMarksForWeight[i] = 100;
            }
            else {
                submittedMarksForWeight[i] = 0;
            }
        }
        return weightScheme.computeWeighted(submittedMarksForWeight) / 100;
    }

    public double getHypotheticalWeight() {
        double[] hypotheticalMarksForWeight = new double[this.instanceList.getTotalNumberOfInstances()];
        for (int i = 0; i < this.instanceList.getTotalNumberOfInstances(); i++) {
            if (this.instanceList.getInstanceData(i).getMark() != null) {
                hypotheticalMarksForWeight[i] = 100;
            }
            else {
                hypotheticalMarksForWeight[i] = 0;
            }
        }
        return weightScheme.computeWeighted(hypotheticalMarksForWeight) / 100;

    }

    public InstanceList getInstanceList() {

        return instanceList;
    }

    public String getTitle() {
        return title;
    }

    public WeightScheme getWeightScheme() {
        return weightScheme;
    }
}

