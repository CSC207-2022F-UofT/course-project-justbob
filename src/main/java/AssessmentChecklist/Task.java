package entities.task;

import entities.assessment.AssessmentInstance;

public class Task implements TaskInterface {
    private String courseName;
    private AssessmentInstance assessmentInstance;
    private boolean showDetail = false;


    public Task(String courseName, AssessmentInstance assessmentInstance){
        this.courseName = courseName;
        this.assessmentInstance = assessmentInstance;
    }

    @Override
    public boolean getSubmitted(){
        return assessmentInstance.isSubmitted();
    }

    @Override
    public boolean getCommitted(){
        return assessmentInstance.isCommitted();
    }

    @Override
    public boolean isHaveMark() {
        return assessmentInstance.getMark() != null;
    }

    @Override
    public boolean isShowDetail() {
        return showDetail;
    }

    @Override
    public void toShowDetail(){
        this.showDetail = true;
    }

    @Override
    public void toNotShowDetail(){
        this.showDetail = false;
    }

    @Override
    public String toString() {
        String result = this.courseName + " " + this.assessmentInstance.getTitle();
        if (this.isShowDetail()){
            if (this.assessmentInstance.getDeadline() != null){
                result += "  Due: " + this.assessmentInstance.getDeadline().toString();
            }
            if (this.assessmentInstance.isSubmitted()){
                result = result + "\n" + "Submitted";
            }
            if (this.assessmentInstance.isCommitted()){
                result = result + "\n" + "Committed";
            }
            if (this.isHaveMark()){
                result = result + "\nMark: " + this.assessmentInstance.getMark();
            }
        }
        return result;
    }
}