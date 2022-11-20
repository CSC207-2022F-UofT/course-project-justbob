package usecases.assessmentOperations;

import entities.assessment.Assessment;

public class AssessmentHypotheticalWeightCalculator {
    public double calcHypotheticalWeight(Assessment assessment) {
        double[] hypotheticalMarksForWeight = new double[assessment.instanceList.getTotalNumberOfInstances()];
        for (int i = 0; i < assessment.instanceList.getTotalNumberOfInstances(); i++) {
            if (assessment.instanceList.getInstanceData(i).getMark() != null) {
                hypotheticalMarksForWeight[i] = 100;
            }
            else {
                hypotheticalMarksForWeight[i] = 0;
            }
        }
        return assessment.weightScheme.computeWeighted(hypotheticalMarksForWeight) / 100;

    }
}
