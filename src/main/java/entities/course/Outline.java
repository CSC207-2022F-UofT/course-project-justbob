package entities.course;

import entities.assessment.Assessment;

import java.util.ArrayList;

public abstract class Outline {
    public abstract ArrayList<Assessment> getAssessments();
    public abstract Assessment getAssessment(int index) throws IndexOutOfBoundsException;
    public abstract void addAssessment(Assessment assessment);
    public abstract void removeAssessment(Assessment assessment);

    public double getPercentageCompleted() {
        double percentageCompleted = 0.0f;
        for (Assessment assessment : getAssessments()) {
            percentageCompleted += assessment.getSubmittedWeight();
        }
        return percentageCompleted;
    }

    public int getNumberOfAssessmentInstancesCompleted() {
        int numberOfAssessmentsCompleted = 0;
        for (Assessment assessment : getAssessments()) {
            numberOfAssessmentsCompleted += assessment.getNumberOfSubmittedInstances();
        }
        return numberOfAssessmentsCompleted;
    }

    public double getTotalCommmittedWeight() {
        double totalCompletedWeight = 0.0f;
        for (Assessment assessment : getAssessments()) {
            totalCompletedWeight += assessment.getCommittedWeight();
        }
        return totalCompletedWeight;
    }

    public double getTotalHypotheticalWeight() {
        double totalHypotheticalWeight = 0.0f;
        for (Assessment assessment : getAssessments()) {
            totalHypotheticalWeight += assessment.getHypotheticalWeight();
        }
        return totalHypotheticalWeight;
    }

    public double computeRunningGrade() {
        double runningGrade = 0.0;
        for (Assessment assessment : getAssessments()) {
            runningGrade += assessment.getWeightScheme().computeWeighted(assessment.getCommittedMarks());
        }
        return runningGrade/this.getTotalCommmittedWeight();
    }

    public double computeHypotheticalGrade() {
        double hypotheticalGrade = 0.0;
        for (Assessment assessment : getAssessments()) {
            hypotheticalGrade += assessment.getWeightScheme().computeWeighted(assessment.getAllMarks());
        }
        if (this.getTotalHypotheticalWeight() == 0) {
            return 0;
        }
        return hypotheticalGrade/this.getTotalHypotheticalWeight();
    }

    public interface OutlineFactory {
        public Outline createOutline();
    }
}

