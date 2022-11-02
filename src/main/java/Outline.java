import java.util.ArrayList;
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

    public void editAssessment(Assessment assessment, WeightScheme scheme) {
        /*some operations on assessment, I need to ask Armon what exactly*/
    }

    public String getAssessmentData(Assessment assessment) {
        /*some data of assessment, I need to ask Armon what exactly*/
        return "";
    }

   /* public void computeRunningGrade() {
        float rgrade = 0.0f;
        *//*use only committed assessment instances to calculate this course's running grade average*//*

        *//*iterate through each Assessment and each of its instances*//*
        for (Assessment assessment : assessments) {
            for (InstanceList AssessmentInstance : assessment.getInstanceList()) {
                if (AssessmentInstance.isCommitted()) {
                    rgrade += AssessmentInstance.mark * assessment.getweightScheme.getWeight(AssessmentInstance);
                }
            }
        }
        *//*for each instance, calculate the weighted grade and add it to the running grade*//*
        *//*divide the running grade by the total number of committed instances*//*

        *//*set the running grade to the calculated value*//*
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

    /*public float getPercentageCompleted() {
        *//*add up all the weights of submitted assessment instances*//*
        for(Assessment assessment:this.assessments){
            for(InstanceList AssessmentInstance:assessment.getInstanceList()){
                if(AssessmentInstance.isSubmitted()){
                    this.percentageCompleted+=assessment.weightScheme.getWeight(instanceList);
                }
            }
        }
        return percentageCompleted;
    }*/

    public int getNumberOfAssessmentsCompleted() {
        /*add up the number submitted assessment instances*/
        return numberOfAssessmentsCompleted;
    }
}
