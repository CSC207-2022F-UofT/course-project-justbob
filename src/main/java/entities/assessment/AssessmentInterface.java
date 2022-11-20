package entities.assessment;

import entities.instanceList.InstanceList;
import weightScheme.WeightScheme;

public interface AssessmentInterface {

    double getTotalWeight();

    InstanceList getInstanceList();

    String getTitle();

    WeightScheme getWeightScheme();
}
