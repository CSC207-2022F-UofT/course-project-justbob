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
    public List showGrade(){
        List<Double> list1 = courseMarks.getList();
        List<String> gradeList = new ArrayList<>();

        for(int i = 0; i < list1.size(); i ++){
            if(list1.get(i) >= 90){
                gradeList.add("A+");
            }else if(list1.get(i) >= 85){
                gradeList.add("A");
            }else if(list1.get(i) >= 80){
                gradeList.add("A-");
            }else if(list1.get(i) >= 77){
                gradeList.add("B+");
            }else if(list1.get(i) >= 73){
                gradeList.add("B");
            }else if(list1.get(i) >= 70){
                gradeList.add("B-");
            }else if(list1.get(i) >= 67){
                gradeList.add("C+");
            }else if(list1.get(i) >= 63){
                gradeList.add("C");
            }else if(list1.get(i) >= 60){
                gradeList.add("C-");
            }else if(list1.get(i) >= 57){
                gradeList.add("D+");
            }else if(list1.get(i) >= 55){
                gradeList.add("D");
            }else if(list1.get(i) >= 50){
                gradeList.add("D-");
            }else {
                gradeList.add("F");
            }
        }
        return gradeList;

    }

    public double showSemester(){
        List<Double> semlist = semester.getList();
        int average = 0;
        int sum = 0;
        for(int i = 0; i < semlist.size(); i++){
            sum += semlist.get(i);
        }
        average = (sum / semlist.size());
        return average;


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
