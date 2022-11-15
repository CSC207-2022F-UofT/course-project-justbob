import java.util.ArrayList;
import java.util.List;

public class GPA {
    private double percentage;
    private double gpa;
    private String grade = "";
    private outline courseMarks;
    private runningCourse semester;

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

    public double percentToGPA(double percent){
        if(percent >= 85){
            return 4.0;
        }else if(percent >= 80){
            return 3.7;
        }else if(percent >= 77){
            return 3.3;
        }else if(percent >= 73){
            return 3.0;
        }else if(percent >= 70){
            return 2.7;
        }else if(percent >= 67){
            return 2.3;
        }else if(percent >= 63){
            return 2.0;
        }else if (percent >=60){
            return 1.7;
        }else if (percent >= 57){
            return 1.3;
        }else if (percent >= 53){
            return 1.0;
        }else if (percent >= 50){
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


    }

/*
    if(percentage >= 90.0){
        grade = "A+";
        gpa = 4.0;
    }else if(85 <= percentage <= 89){
        grade = "A";
        gpa = 4.0;
    }else if(80 <= percentage <= 84){
        grade = "A-";
        gpa = 3.7;
    }else if(77 <= percentage <= 79){
        grade = "B+";
        gpa = 3.3;
    }else if(73 <= percentage <= 76){
        grade = "B";
        gpa = 3.0;
    }else if(70 <= percentage <= 72){
        grade = "B-";
        gpa = 2.7;
    }else if(67 <= percentage <= 69){
        grade = "C+";
        gpa =
    }
*/

    ;
}
