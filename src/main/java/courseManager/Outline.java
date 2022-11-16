package courseManager;

import weightScheme.WeightScheme;

import java.util.ArrayList;
import java.util.List;

public class Outline {
    private double runningGrade;
    private double hypothethicalGrade;

    private double percentageCompleted;
    private int numberOfAssessmentsCompleted; /*do these need to be their own instance variables?*/
    final private ArrayList<Assessment> assessments;

    public Outline () {
        this.runningGrade = 0.0f;
        this.hypothethicalGrade = 0.0f;
        this.assessments = new ArrayList<>();
    }

    public void setRunningGrade(double runningGrade) {

        this.runningGrade = runningGrade;
    }

    public void setHypothethicalGrade(double hypothethicalGrade) {

        this.hypothethicalGrade = hypothethicalGrade;
    }

    public void addAssessment(Assessment assessment) {

        assessments.add(assessment);
    }

    public void removeAssessment(Assessment assessment) {

        assessments.remove(assessment);
    }

    public void editAssessment(int index, String title) {
        assessments.get(index).setTitle(title);
    }
    public void editAssessment(int index, WeightScheme scheme) {
        assessments.get(index).setWeightScheme(scheme);
    }
    public void editAssessment(int index, String title, WeightScheme scheme) {
        assessments.get(index).setTitle(title);
        assessments.get(index).setWeightScheme(scheme);
    }

    public Assessment getAssessmentData(int index) {
        return assessments.get(index);
    }
    public List<Assessment> getAssessments() {
        return assessments;
    }

    public double getPercentageCompleted() {
        double percentageCompleted = 0.0f;
        for (Assessment assessment : assessments) {
            percentageCompleted += assessment.getSubmittedWeight();
        }
        return percentageCompleted;
    }

    public int getNumberOfAssessmentsCompleted() {
        int numberOfAssessmentsCompleted = 0;
        for (Assessment assessment : assessments) {
            numberOfAssessmentsCompleted += assessment.getInstanceList().getNumberOfSubmittedInstances();
        }
        return numberOfAssessmentsCompleted;
    }

    public void computeRunningGrade() {
        double rgrade = 0.0;
        for (Assessment assessment : assessments) {
            rgrade += assessment.getWeightScheme().computeWeighted(assessment.getInstanceList().getCommittedMarks());
        }
        setRunningGrade(rgrade);
    }

    public void computeHypotheticalGrade() {
        double hgrade = 0.0;
        for (Assessment assessment : assessments) {
            hgrade += assessment.getWeightScheme().computeWeighted(assessment.getInstanceList().getAllMarks());
        }
        setHypothethicalGrade(hgrade);
    }

    public double getRunningGrade() {
        computeRunningGrade();
        return runningGrade;
    }

    public double getHypothethicalGrade() {
        computeHypotheticalGrade();
        return hypothethicalGrade;
    }
}

