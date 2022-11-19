package main;

import java.time.LocalDate;
import java.time.LocalTime;

public class Assignment {
    private String courseName;
    private String name;
    private LocalDate ddl;
    private LocalTime ddlTime;
    private double weight = 0;
    private boolean finished = false;
    private boolean haveMark = false;
    private double mark = 0;
    private boolean showDetail = false;

    /**
     * Create a main.Assignment object with specific  course name and assignment name.
     * @param courseName the course that this assignment belongs to
     *                   e.g. "CSC207"
     * @param name the name of this assignment
     *             e.g. "Final Exam"
     */
    public Assignment(String courseName, String name){
        this.courseName = courseName;
        this.name = name;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setDdl(LocalDate ddl) {
        this.ddl = ddl;
    }

    public void setDdlTime(LocalTime ddlTime){
        this.ddlTime = ddlTime;
    }
    public LocalDate getDdl() {
        return ddl;
    }

    public LocalTime getDdlTime(){
        return this.ddlTime;
    }

    public void markAsFinished(){
        this.finished = true;
    }

    public void markAsNotFinished(){
        this.finished = false;
    }

    public boolean getFinished(){
        return this.finished;
    }


    public void setMark(double mark){
        this.haveMark = true;
        this.mark = mark;
    }

    public void removeMark(){
        this.haveMark = false;
        this.mark = 0;
    }
    public double getMark() {
        return mark;
    }

    public boolean isHaveMark() {
        return haveMark;
    }

    public boolean isShowDetail() {
        return showDetail;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getContribution(){
        return this.getWeight() * this.getMark() * 0.01;
    }

    public void toShowDetail(){
        this.showDetail = true;
    }

    public void toNotShowDetail(){
        this.showDetail = false;
    }

    public String toString() {
        String result = this.courseName + " " + this.name;
        if (this.isShowDetail()){
            if (this.getDdl() != null){
                result += "  DDL: " + this.ddl.toString() + " " + this.ddlTime.toString();
            }
            if (this.getWeight() != 0){
                result += "  " + "Worth: " + this.weight + " percent";
            }
            if (this.getFinished()){
                result = result + "\n" + "Finished!!!  :)";
            }
            if (this.isHaveMark()){
                result = result + "  Mark: " + this.mark + "  Contribution:" + this.getContribution();
            }
        }
        return result;
    }
}
