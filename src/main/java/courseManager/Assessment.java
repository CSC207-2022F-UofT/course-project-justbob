package courseManager;

import weightScheme.WeightScheme;

import java.util.ArrayList;

public class Assessment {
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

    public double getTotalWeight() {
        return weightScheme.getTotalWeight();
    }

    public double getCommittedWeight() {;
        return this.instanceList.getNumberOfCommittedInstances() * weightScheme.getWeightOfEachInstance();
    }

    public double getSubmittedWeight() {
        return this.instanceList.getNumberOfSubmittedInstances() * weightScheme.getWeightOfEachInstance();
    }

    public double getHypotheticalWeight() {
        return this.instanceList.getNumberOfMarkedInstances() * weightScheme.getWeightOfEachInstance();

    }

    public InstanceList getInstanceList() {

        return instanceList;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setWeightScheme(WeightScheme weightScheme) {
        this.weightScheme = weightScheme;
    }
    public WeightScheme getWeightScheme() {
        return weightScheme;
    }
}

