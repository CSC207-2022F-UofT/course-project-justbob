import java.util.ArrayList;
import java.util.List;

public class GPA {
    private double percentage;
    private double gpa;
    private String grade = "";
    private outline courseMarks;

    public GPA(double percentage, double gpa, String grade, outline courseMarks){
        this.percentage = percentage;
        this.gpa = gpa;
        this.grade = grade;
        this.courseMarks = courseMarks;
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

    public List calculateCourseGPA(){
        List<Double> list = courseMarks.getList();
        List<Double> gpalist = new ArrayList<>();

        for(int i = 0; i < list.size(); i ++){
            if(list.get(i) >= 85){
                gpalist.add(4.0);
            }else if(list.get(i) >= 80){
                gpalist.add(3.7);
            }else if(list.get(i) >= 77){
                gpalist.add(3.3);
            }else if(list.get(i) >= 73){
                gpalist.add(3.0);
            }else if(list.get(i) >= 70){
                gpalist.add(2.7);
            }else if(list.get(i) >= 67){
                gpalist.add(2.3);
            }else if(list.get(i) >= 63){
                gpalist.add(2.0);
            }else if (list.get(i) >=60){
                gpalist.add(1.7);
            }else if (list.get(i) >= 57){
                gpalist.add(1.3);
            }else if (list.get(i) >= 53){
                gpalist.add(1.0);
            }else if (list.get(i) >= 50){
                gpalist.add(0.7);
            }else {
                gpalist.add(0.0);
            }
        }


        return gpalist;
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
