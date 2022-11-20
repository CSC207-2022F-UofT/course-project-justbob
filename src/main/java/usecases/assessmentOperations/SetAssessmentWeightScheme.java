package usecases.assessmentOperations;

import entities.assessment.Assessment;
import weightScheme.WeightScheme;

public class SetAssessmentWeightScheme {
    public void setWeightScheme(Assessment assessment, WeightScheme weightScheme) {
        assessment.weightScheme = weightScheme;
    }
}
