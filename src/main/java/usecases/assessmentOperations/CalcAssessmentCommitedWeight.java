package usecases.assessmentOperations;

import entities.assessment.Assessment;

public class CalcAssessmentCommitedWeight {
    public double getCommittedWeight(Assessment assessment) {
        double[] committedMarksForWeight = new double[assessment.instanceList.getTotalNumberOfInstances()];
        for (int i = 0; i < assessment.instanceList.getTotalNumberOfInstances(); i++) {
            if (assessment.instanceList.getInstanceData(i).isCommitted()) {
                committedMarksForWeight[i] = 100;
            }
            else {
                committedMarksForWeight[i] = 0;
            }
        }
        return assessment.weightScheme.computeWeighted(committedMarksForWeight) / 100;
    }
}
