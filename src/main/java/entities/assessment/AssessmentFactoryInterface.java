package entities.assessment;

import entities.assessmentInstance.AssessmentInstance;
import weightScheme.WeightScheme;

public interface AssessmentFactoryInterface {
    Assessment create(String title, WeightScheme weightScheme);
}
