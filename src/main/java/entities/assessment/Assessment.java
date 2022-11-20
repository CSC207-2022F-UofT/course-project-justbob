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

