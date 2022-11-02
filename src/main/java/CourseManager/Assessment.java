package CourseManager;

import weightScheme.WeightScheme;

import java.util.ArrayList;
public class Assessment {
    private String title;
    private InstanceList instanceList;
    private WeightScheme weightScheme;


    public Assessment(String title, WeightScheme weightScheme, InstanceList instanceList) {
        this.title = title;
        this.weightScheme = weightScheme;
        this.instanceList = instanceList;
    }

    public float getTotalWeight() {
        float totalWeight = 0.0f;
        /*iterate through each instance in the instance list and add its weight to the total weight*/
        return totalWeight;
    }

    public float getCommittedWeight() {
        float committedWeight = 0.0f;
        /*iterate through the instance list and add committed instances' weight*/
        return committedWeight;
    }

    public float getSubmittedWeight() {
        float submittedWeight = 0.0f;
        /*iterate through the instance list and add submitted instances' weight*/
        return submittedWeight;
    }

    public float getHypotheticalWeight() {
        float hypotheticalWeight = 0.0f;
        /*iterate through the instance list and add all submitted weights together*/
        return hypotheticalWeight;
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

