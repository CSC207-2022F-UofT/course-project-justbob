package entities.assessment;

import entities.instanceList.InstanceList;
import weightScheme.WeightScheme;

public interface AssessmentInterface {

    double getTotalWeight();

    InstanceList getInstanceList();

    String getTitle();

    void setWeightScheme(WeightScheme weightScheme);

    WeightScheme getWeightScheme();

    double getCommittedWeight();

    double getSubmittedWeight();

    double getHypotheticalWeight();

    void setTitle(String title);
}
