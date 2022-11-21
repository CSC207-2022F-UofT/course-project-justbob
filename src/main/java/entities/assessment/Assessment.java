package entities.assessment;

import entities.instanceList.InstanceList;
import weightScheme.WeightScheme;

public class Assessment implements AssessmentInterface{
    private String title;
    private final InstanceList instanceList;
    private WeightScheme weightScheme;

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
    @Override
    public double getTotalWeight() {
        return weightScheme.getTotalWeight();
    }

    @Override
    public double getCommittedWeight() {
        double[] committedMarksForWeight = new double[this.instanceList.getTotalNumberOfInstances()];
        for (int i = 0; i < this.instanceList.getTotalNumberOfInstances(); i++) {
            if (this.instanceList.getInstanceData(i).isCommitted()) {
                committedMarksForWeight[i] = 100;
            }
            else {
                committedMarksForWeight[i] = 0;
            }
        }
        return weightScheme.computeWeighted(committedMarksForWeight) / 100;
    }

    @Override
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

    @Override
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
    @Override
    public InstanceList getInstanceList() {

        return instanceList;
    }
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setWeightScheme(WeightScheme weightScheme) {
        this.weightScheme = weightScheme;
    }

    @Override
    public WeightScheme getWeightScheme() {
        return weightScheme;
    }
}
