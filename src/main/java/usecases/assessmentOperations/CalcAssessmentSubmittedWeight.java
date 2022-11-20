package usecases.assessmentOperations;

import entities.assessment.Assessment;

public class CalcAssessmentSubmittedWeight {

    public double getSubmittedWeight(Assessment assessment) {
        double[] submittedMarksForWeight = new double[assessment.instanceList.getTotalNumberOfInstances()];
        for (int i = 0; i < assessment.instanceList.getTotalNumberOfInstances(); i++) {
            if (assessment.instanceList.getInstanceData(i).isSubmitted()) {
                submittedMarksForWeight[i] = 100;
            }
            else {
                submittedMarksForWeight[i] = 0;
            }
        }
        return assessment.weightScheme.computeWeighted(submittedMarksForWeight) / 100;
    }
}
