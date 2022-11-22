package entities.outline;

import entities.assessment.Assessment;

import java.util.ArrayList;

public class Outline {

    private ArrayList<Assessment> assessments;

    public Outline() {
        this.assessments = new ArrayList<>();
    }

    public void addAssessment(Assessment assessment) {

        assessments.add(assessment);
    }

    public void removeAssessment(Assessment assessment) {

        assessments.remove(assessment);
    }

    public Assessment getAssessment(int index) throws IndexOutOfBoundsException {
            try {
                return assessments.get(index);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
    }

    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    public double getPercentageCompleted() {
        double percentageCompleted = 0.0f;
        for (Assessment assessment : assessments) {
            percentageCompleted += assessment.getSubmittedWeight();
        }
        return percentageCompleted;
    }

    public int getNumberOfAssessmentInstancesCompleted() {
        int numberOfAssessmentsCompleted = 0;
        for (Assessment assessment : assessments) {
            numberOfAssessmentsCompleted += assessment.getInstanceList().getNumberOfSubmittedInstances();
        }
        return numberOfAssessmentsCompleted;
    }

    public double getTotalCommmittedWeight() {
        double totalCompletedWeight = 0.0f;
        for (Assessment assessment : assessments) {
            totalCompletedWeight += assessment.getCommittedWeight();
        }
        return totalCompletedWeight;
    }

    public double getTotalHypotheticalWeight() {
        double totalHypotheticalWeight = 0.0f;
        for (Assessment assessment : assessments) {
            totalHypotheticalWeight += assessment.getHypotheticalWeight();
        }
        return totalHypotheticalWeight;
    }

    public double computeRunningGrade() {
        double rgrade = 0.0;
        for (Assessment assessment : assessments) {
            rgrade += assessment.getWeightScheme().computeWeighted(assessment.getInstanceList().getCommittedMarks());
        }
        return rgrade/this.getTotalCommmittedWeight();
    }

    public double computeHypotheticalGrade() {
        double hgrade = 0.0;
        for (Assessment assessment : assessments) {
            hgrade += assessment.getWeightScheme().computeWeighted(assessment.getInstanceList().getAllMarks());
        }
        if (this.getTotalHypotheticalWeight() == 0) {
            return 0;
        }
        return hgrade/this.getTotalHypotheticalWeight();
    }
}

