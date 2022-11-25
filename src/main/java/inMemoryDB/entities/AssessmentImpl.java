package inMemoryDB.entities;


import entities.assessment.Assessment;
import entities.assessment.AssessmentInstance;
import entities.weightScheme.WeightScheme;

import java.util.ArrayList;

public class AssessmentImpl extends Assessment {
    private String title;
    private WeightScheme weightScheme;
    private ArrayList<AssessmentInstance> instances = new ArrayList<>();

    public AssessmentImpl(String title, WeightScheme weightScheme) {
        this.title = title;
        this.weightScheme = weightScheme;
    }

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

    // TODO: ensure setting weightscheme adjusts instance list
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
        if (getCurrentNumberOfInstances() < getTotalNumberOfInstances()) {
            // TODO: throw appropriate error
        }
        if (!instances.contains(instance)) {
            instances.add(instance);
        }
    }

    @Override
    public void removeInstance(AssessmentInstance instance) {
        instances.remove(instance);
    }
}