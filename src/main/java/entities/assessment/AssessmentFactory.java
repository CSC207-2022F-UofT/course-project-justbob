package entities.assessment;

import weightScheme.WeightScheme;

public class AssessmentFactory {
    public Assessment create(String title, WeightScheme weightScheme) {
        return new Assessment(title, weightScheme);
    }

    public Assessment create(String title, WeightScheme weightScheme, boolean populate) {
        return new Assessment(title, weightScheme, populate);
    }

}
