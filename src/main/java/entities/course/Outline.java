package entities.course;

import entities.assessment.Assessment;

import java.util.ArrayList;

public abstract class Outline {
    public abstract ArrayList<Assessment> getAssessments();

    public abstract ArrayList<String> getAssessmentsTitles();

    public abstract Assessment getAssessment(int index) throws IndexOutOfBoundsException;
    public abstract void addAssessment(Assessment assessment);
    public abstract void removeAssessment(Assessment assessment);

    // TODO: rename to getNumberOfInstancesSubmitted (more descriptive)
    public int getNumberOfAssessmentInstancesCompleted() {
        return getAssessments().stream()
                .mapToInt(assessment -> assessment.getNumberOfSubmittedInstances())
                .sum();
    }

    public double getPercentageCompleted() {
        return getAssessments().stream()
                .mapToDouble(assessment -> assessment.getMaxPossibleSubmittedWeight())
                .sum();
    }

    private double getTotalCommittedWeight() {
        return getAssessments().stream()
                .mapToDouble(assessment -> assessment.getMaxPossibleCommittedWeight())
                .sum();
    }

    private double getTotalHypotheticalWeight() {
        return getAssessments().stream()
                .mapToDouble(assessment -> assessment.getMaxPossibleHypotheticalWeight())
                .sum();
    }

    public double computeRunningGrade() {
        if (getTotalCommittedWeight() <= 0) {
            return 0;
        }
        return getAssessments().stream()
                .mapToDouble(assessment -> assessment.getActualCommittedWeight())
                .sum() / getTotalCommittedWeight();
    }

    public double computeHypotheticalGrade() {
        if (getTotalHypotheticalWeight() <= 0) {
            return 0;
        }
        return getAssessments().stream()
                .mapToDouble(assessment -> assessment.getActualHypotheticalWeight())
                .sum() / getTotalHypotheticalWeight();
    }

    public interface OutlineFactory {
        public Outline createOutline();
    }
}

