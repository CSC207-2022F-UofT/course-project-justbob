package inMemoryDB.entities;

import entities.assessment.AssessmentInstance;
import entities.task.Task;

public class TaskImpl extends Task {
    private String courseName;
    private AssessmentInstance assessmentInstance;
    private boolean showDetail = false;


    public TaskImpl(String courseName, AssessmentInstance assessmentInstanceImpl){
        this.courseName = courseName;
        this.assessmentInstance = assessmentInstanceImpl;
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