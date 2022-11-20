package Calculations;

import java.util.ArrayList;
import java.util.List;

public class listofLetteredGrades extends computeGradeLetter{

    public listofLetteredGrades(double percentage){
        super(percentage);
    }
    public static List<String> computeGrade(List<Double> markspercentage) {
        List<String> gradelist = new ArrayList<>();
        for (int i = 0; i < markspercentage.size(); i++) {
            gradelist.add(percentToGrade(markspercentage.get(i)));
        }
        System.out.println(gradelist);
        return gradelist;
    }
    public static void main(String[] args) {
        System.out.println("Output: ");
        computeGrade(List.of(90.0, 85.0, 73.0, 84.9));
    }
}
