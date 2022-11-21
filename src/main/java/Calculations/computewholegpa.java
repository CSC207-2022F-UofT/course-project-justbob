package Calculations;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class computewholegpa extends computeGPA{

    public computewholegpa(double percentage) {
        super(percentage);
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

        totalGpa = Math.round((sumGPA / sumCredits) * 100.0)/100.0;
        System.out.println(totalGpa);
        return totalGpa;

    }
    public static void main(String[] args) {
        System.out.println("Output: ");
        overallGPA(List.of(90.0, 75.0, 73.0, 81.0), List.of(1.0, 0.5, 0.5, 1.0));
    }
}
