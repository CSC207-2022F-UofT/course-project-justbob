package inMemoryDB.entities;


import entities.assessment.Assessment;
import entities.assessment.assessmentInstance.AssessmentInstance;
import weightScheme.WeightScheme;

import java.util.ArrayList;

public class AssessmentImpl extends Assessment {
    private String title;
    private WeightScheme weightScheme;
    private ArrayList<AssessmentInstance> instances;

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
    public ArrayList<AssessmentInstance> getInstances() {
        return instances;
    }

    @Override
    public void addInstance(AssessmentInstance instance) {
        if (!instances.contains(instance)) {
            instances.add(instance);
        }
    }

    @Override
    public void removeInstance(AssessmentInstance instance) {
        instances.remove(instance);
    }
}