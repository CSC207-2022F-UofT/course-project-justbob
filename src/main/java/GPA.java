import java.util.ArrayList;
import java.util.List;

public class GPA {
    private double percentage;
    private double gpa;
    private String grade = "";
    private outline courseMarks;
    private runningCourse semester;

    /**
     * Construct a GPA, giving them the semster list from runningCourse and courseMarks from the outline.
     * @param percentage
     * @param gpa
     * @param grade
     * @param courseMarks
     * @param semester
     */
    public GPA(double percentage, double gpa, String grade, outline courseMarks, runningCourse semester){
        this.percentage = percentage;
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
    public List<Double> calculateCourseGPA(){
        List<Double> list = courseMarks.getList();
        List<Double> gpalist = new ArrayList<>();

        for(int i = 0; i < list.size(); i ++) {
            gpalist.add(percentToGPA(list.get(i)));
        }
        return gpalist;
    }
    public String percentToGrade(double percent){
        if(percent >= 90){
            return "A+";
        }else if(percent >= 85){
            return "A";
        }else if(percent >= 80){
            return "A-";
        }else if(percent >= 77){
            return "B+";
        }else if(percent >= 73){
            return "B";
        }else if(percent >= 70){
            return "B-";
        }else if(percent >= 67){
            return "C+";
        }else if(percent >= 63){
            return "C";
        }else if(percent >= 60){
            return "C-";
        }else if(percent >= 57){
            return "D+";
        }else if(percent >= 55){
            return "D";
        }else if(percent >= 50){
            return "D-";
        }else {
            return "F";
        }

    }
    public List<String> showGrade(){
        List<Double> list1 = courseMarks.getList();
        List<String> gradeList = new ArrayList<>();

        for(int i = 0; i < list1.size(); i ++){
            gradeList.add(percentToGrade(list1.get(i)));
        }
        return gradeList;
    }
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
