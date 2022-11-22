package entities.assessment;

import weightScheme.WeightScheme;

public interface AssessmentFactoryInterface {
    Assessment create(String title, WeightScheme weightScheme);
}
