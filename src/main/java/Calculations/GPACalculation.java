package Calculations;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class GPACalculation {

    public static double computationGPA(double percentage){
        if(percentage >= 85.0){
            return 4.0;
        }else if(percentage >= 80.0){
            return 3.7;
        }else if(percentage >= 77.0){
            return 3.3;
        }else if(percentage >= 73.0){
            return 3.0;
        }else if(percentage >= 70.0){
            return 2.7;
        }else if(percentage >= 67.0){
            return 2.3;
        }else if(percentage >= 63.0){
            return 2.0;
        }else if (percentage >=60.0){
            return 1.7;
        }else if (percentage >= 57.0){
            return 1.3;
        }else if (percentage >= 53.0){
            return 1.0;
        }else if (percentage >= 50.0){
            return 0.7;
        }else {
            return 0.0;
        }

    }

    public static List<Double> computeSemGPA(List<Double> markspercentage) {
        List<Double> gpalist = new ArrayList<>();
        for(int i = 0; i < markspercentage.size(); i++) {
            gpalist.add(computationGPA(markspercentage.get(i)));
        }
        System.out.println(gpalist);
        return gpalist;
    }
    public static double computeAverage(List<Double> markspercentage) {
        double average;
        double sum = 0;
        for (int i = 0; i < markspercentage.size(); i++) {
            sum += markspercentage.get(i);
        }
        average = (sum / markspercentage.size());
        System.out.println(average);
        return average;
    }


    public static String percentToGrade(double percentage1){
        if(percentage1 >= 90){
            return "A+";
        }else if(percentage1 >= 85){
            return "A";
        }else if(percentage1 >= 80){
            return "A-";
        }else if(percentage1 >= 77){
            return "B+";
        }else if(percentage1 >= 73){
            return "B";
        }else if(percentage1 >= 70){
            return "B-";
        }else if(percentage1 >= 67){
            return "C+";
        }else if(percentage1 >= 63){
            return "C";
        }else if(percentage1 >= 60){
            return "C-";
        }else if(percentage1 >= 57){
            return "D+";
        }else if(percentage1 >= 55){
            return "D";
        }else if(percentage1 >= 50){
            return "D-";
        }else {
            return "F";
        }
    }

    public static List<String> computeGrade(List<Double> markspercentage) {
        List<String> gradelist = new ArrayList<>();
        for(int i = 0; i < markspercentage.size(); i++) {
            gradelist.add(percentToGrade(markspercentage.get(i)));
        }
        System.out.println(gradelist);
        return gradelist;
    }

    public static double overallGPA(List<Double> markpercentage, List<Double> courseCredits) {
        double sumGPA = 0;
        double sumCredits = 0;
        double totalGpa;
        List<Double> gpalist = new ArrayList<>();
        List<Double> overallGrade = new ArrayList<>();

        for(int i = 0; i < courseCredits.size(); i++) {
            sumCredits += courseCredits.get(i);
        }
        for(int j = 0; j < markpercentage.size(); j++) {
            gpalist.add(computationGPA(markpercentage.get(j)));
        }
        for(int s = 0; s < gpalist.size(); s ++){
            overallGrade.add(gpalist.get(s) * courseCredits.get(s));
        }
        for(int v = 0; v < overallGrade.size(); v++) {
            sumGPA += overallGrade.get(v);
        }
        System.out.println(courseCredits);
        System.out.println(sumCredits);
        System.out.println(gpalist);
        System.out.println(overallGrade);

        totalGpa = Math.round((sumGPA / sumCredits) * 100.0) / 100.0;
        System.out.println(totalGpa);
        return totalGpa;

    }







    public static void main(String[] args){
        System.out.println("GPA: ");
        computeSemGPA(List.of(90.0, 85.0, 73.0, 84.9));

        System.out.println("Average: ");
        computeAverage(List.of(90.0, 85.0, 73.0, 84.9));

        System.out.println("Letters: ");
        computeGrade(List.of(90.0, 85.0, 73.0, 84.9));

        System.out.println("Whole: ");
        overallGPA(List.of(90.0, 75.0, 73.0, 81.0), List.of(1.0, 0.5, 0.5, 1.0));
    }
}
