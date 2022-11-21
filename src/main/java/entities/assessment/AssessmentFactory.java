package entities.assessment;

import weightScheme.WeightScheme;

public class AssessmentFactory implements AssessmentFactoryInterface{

    @Override
    public Assessment create(String title, WeightScheme weightScheme) {
        return new Assessment(title, weightScheme);
    }
}
