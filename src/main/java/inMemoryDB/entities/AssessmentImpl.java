package inMemoryDB.entities;


import entities.assessment.Assessment;
import entities.assessment.instanceList.InstanceList;
import weightScheme.WeightScheme;

public class AssessmentImpl extends Assessment {
    private String title;
    private WeightScheme weightScheme;
    private InstanceList instanceList;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public WeightScheme getWeightScheme() {
        return weightScheme;
    }

    @Override
    public void setWeightScheme(WeightScheme weightScheme) {
        this.weightScheme = weightScheme;
    }

    @Override
    public InstanceList getInstanceList() {
        return instanceList;
    }

    @Override
    public void setInstanceList(InstanceList instanceList) {
        this.instanceList = instanceList;
    }
}