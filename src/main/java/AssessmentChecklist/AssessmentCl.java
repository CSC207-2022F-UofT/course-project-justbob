package AssessmentChecklist;

import java.time.LocalDate;
import java.time.LocalTime;

public class AssessmentCl implements AssessmentClInterface{
    private String courseName;
    private String name;
    private LocalDate ddlDate;
    private LocalTime ddlTime;
    private double weight = 0;
    private boolean finished = false;
    private boolean haveMark = false;
    private double mark = 0;
    private boolean showDetail = false;

    /**
     * Create a main.AssessmentCl object with specific  course name and assessmentCl name.
     * @param courseName the course that this assessmentCl belongs to
     *                   e.g. "CSC207"
     * @param name the name of this assessmentCl
     *             e.g. "Final Exam"
     */
    public AssessmentCl(String courseName, String name){
        this.courseName = courseName;
        this.name = name;
    }

    @Override
    public void setWeight(double weight){
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setDdl(LocalDate ddl) {
        this.ddlDate = ddl;
    }

    @Override
    public void setDdlTime(LocalTime ddlTime){
        this.ddlTime = ddlTime;
    }
    @Override
    public LocalDate getDdlDate() {
        return ddlDate;
    }

    @Override
    public LocalTime getDdlTime(){
        return this.ddlTime;
    }

    @Override
    public void markAsFinished(){
        this.finished = true;
    }

    @Override
    public void markAsNotFinished(){
        this.finished = false;
    }

    @Override
    public boolean getFinished(){
        return this.finished;
    }


    @Override
    public void setMark(double mark){
        this.haveMark = true;
        this.mark = mark;
    }

    @Override
    public void removeMark(){
        this.haveMark = false;
        this.mark = 0;
    }
    @Override
    public double getMark() {
        return mark;
    }

    @Override
    public boolean isHaveMark() {
        return haveMark;
    }

    @Override
    public boolean isShowDetail() {
        return showDetail;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public double getContribution(){
        return this.getWeight() * this.getMark() * 0.01;
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
        String result = this.courseName + " " + this.name;
        if (this.isShowDetail()){
            if (this.getDdlDate() != null){
                result += "  DDL: " + this.ddlDate.toString() + " " + this.ddlTime.toString();
            }
            if (this.getWeight() != 0){
                result += "  " + "Worth: " + this.weight + " percent";
            }
            if (this.getFinished()){
                result = result + "\n" + "Finished!!!  :)";
            }
            if (this.isHaveMark()){
                result = result + "\nMark: " + this.mark + "  Contribution:" + this.getContribution();
            }
        }
        return result;
    }
}
