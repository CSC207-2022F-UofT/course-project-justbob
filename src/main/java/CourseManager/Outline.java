package CourseManager;

import weightScheme.WeightScheme;

import java.util.ArrayList;
import java.util.Map;

public class Outline {
    private float runningGrade;
    private float hypothethicalGrade;

    private float percentageCompleted;
    private int numberOfAssessmentsCompleted; /*do these need to be their own instance variables?*/
    private ArrayList<Assessment> assessments;

    public Outline () {
        this.runningGrade = 0.0f;
        this.hypothethicalGrade = 0.0f;
    }

    public void setRunningGrade(float runningGrade) {

        this.runningGrade = runningGrade;
    }

    public void setHypothethicalGrade(float hypothethicalGrade) {

        this.hypothethicalGrade = hypothethicalGrade;
    }

    public void addAssessment(Assessment assessment, WeightScheme scheme) {

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

    public Map<String, WeightScheme> getAssessmentData(int index) {
        return Map.of(assessments.get(index).getTitle(), assessments.get(index).getWeightScheme());
    }

    public float getPercentageCompleted() {
        float percentageCompleted = 0.0f;
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

    /*public void computeRunningGrade() {
        float rgrade = 0.0f;

        *//*use only committed assessment instances to calculate this course's running grade average

        iterate through each Assessment and each of its instances*//*

        for (Assessment assessment : assessments) {
            for (AssessmentInstance instance : Assessment.getInstanceList()) {
                if (instance.isCommitted()) {
                    rgrade += instance.getWeightedGrade();
                }
            }
        }

        *//*for each instance, calculate the weighted grade and add it to the running grade
        divide the running grade by the total number of committed instances

        set the running grade to the calculated value*//*
        this.setRunningGrade(rgrade);
    }*/

    public void computeHypotheticalGrade() {
        float hgrade = 0.0f;
        /*use all assessment instances with a mark to calculate this course's running grade average*/

        /*iterate through each Assessment and each of its instances*/
        /*for each instance, calculate the weighted grade and add it to the running grade*/
        /*divide the running grade by the total number of instances*/

        /*set the running grade to the calculated value*/
        this.setHypothethicalGrade(hgrade);
    }

    public float getRunningGrade() {
        return runningGrade;
    }

    public float getHypothethicalGrade() {
        return hypothethicalGrade;
    }
}

