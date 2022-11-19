package Calculations;

import java.util.ArrayList;
import java.util.List;

public class GPA extends mathGpaCgpa  {
    private double percentage;
    private double gpa;
    private String grade = "";
    private outline courseMarks;
    private runningCourse semester;

    /**
     * Construct a Calculations.GPA, giving them the semester list from runningCourse and courseMarks from the outline.
     * @param percentage The course mark in terms of percentage scale from 0% to 100%
     * @param gpa The course mark in terms of point scale varying from 0 to 4.0
     * @param grade The course mark in terms of lettered Grades ranging from F to A+
     * @param courseMarks List of the course marks in terms of percentage
     * @param semester List of the course marks for the semester in terms of percentage
     */
    public GPA(double percentage, double gpa, String grade, outline courseMarks, runningCourse semester){
        super(percentage);
        this.gpa = gpa;
        this.grade = grade;
        this.courseMarks = courseMarks;
        this.runningCourse = semester;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getGpa() {
        return gpa;
    }

    public String getGrade() {
        return grade;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Converts the mark from in terms of percentage (double) to Calculations.GPA value in terms of
     * UofT Calculations.GPA scale (double)
     * @return a double of in terms of Calculations.GPA scale
     */

    /**
    public double percentToGPA(){
        if(percentage >= 85){
            return 4.0;
        }else if(percentage >= 80){
            return 3.7;
        }else if(percentage >= 77){
            return 3.3;
        }else if(percentage >= 73){
            return 3.0;
        }else if(percentage >= 70){
            return 2.7;
        }else if(percentage >= 67){
            return 2.3;
        }else if(percentage >= 63){
            return 2.0;
        }else if (percentage >=60){
            return 1.7;
        }else if (percentage >= 57){
            return 1.3;
        }else if (percentage >= 53){
            return 1.0;
        }else if (percentage >= 50){
            return 0.7;
        }else {
            return 0.0;
        }
    }
     */


    /**
     * Takes a list of the courseMarks from the outline class (in terms of pecentage) and then
     * loops through list converting it into the Calculations.GPA scale using helper function above. Calculations.GPA scale
     * added to new Arraylist called gpalist
     *
     * @return an Arraylist of double consisting of marks in Calculations.GPA scale
     */
    public List<Double> calculateCourseGPA(){
        List<Double> list = courseMarks.getList();
        List<Double> gpalist = new ArrayList<>();

        for(int i = 0; i < list.size(); i ++) {
            gpalist.add(percentToGPA(list.get(i)));
        }
        return gpalist;
    }

    /**
     * Converts percentage (double) to a lettered Grade (String)
     * @return a String of a lettered Grade ranging from F to A+
     */
/**
    public String percentToGrade(){
        if(percentage >= 90){
            return "A+";
        }else if(percentage >= 85){
            return "A";
        }else if(percentage >= 80){
            return "A-";
        }else if(percentage >= 77){
            return "B+";
        }else if(percentage >= 73){
            return "B";
        }else if(percentage >= 70){
            return "B-";
        }else if(percentage >= 67){
            return "C+";
        }else if(percentage >= 63){
            return "C";
        }else if(percentage >= 60){
            return "C-";
        }else if(percentage >= 57){
            return "D+";
        }else if(percentage >= 55){
            return "D";
        }else if(percentage >= 50){
            return "D-";
        }else {
            return "F";
        }

    }
 *
 */

    /**
     * Take a list of courseMarks from the outline class (in terms of pecentage) and then
     * loops through list converting it from percentage to lettered Grade using helper function
     * above. Lettered Grades added to new arraylist called gradeList
     *
     * @return Arraylist (gradeList) of Strings of lettered Grades
     */
    public List<String> showGrade(){
        List<Double> list1 = courseMarks.getList();
        List<String> gradeList = new ArrayList<>();

        for(int i = 0; i < list1.size(); i ++){
            gradeList.add(percentToGrade(list1.get(i)));
        }
        return gradeList;
    }

    /**
     * Takes list of doubles called semlist which is list of percentages for courses in semester.
     * Calculates the total average of the courses in terms of percentage by dividing sum of
     * all courses by the size of list
     *
     * @return a double of average
     */
    public double showPercentSemester(){
        List<Double> semlist = semester.getList();
        double average;
        double sum = 0;
        for(int i = 0; i < semlist.size(); i++){
            sum += semlist.get(i);
        }
        average = (sum / semlist.size());
        return average;

    }

    /**
     * Calls calculateCourseGPA() to receive list of marks in Calculations.GPA scale.
     * Takes list and take sum of all GPAs and outputs the average Calculations.GPA for semester
     * @return a double of semester Calculations.GPA
     */
    public double showGPASemester(){
        calculateCourseGPA();
        double sumGPA = 0;
        double semesterGPA = 0;
        for(int i = 0; i < calculateCourseGPA().size(); i ++){
            sumGPA += calculateCourseGPA().get(i);
        }
        semesterGPA = (sumGPA / calculateCourseGPA().size());
        return semesterGPA;
    }
    ;
}
