package Calculations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class computeSemesterGPA extends computeGPA {

    public computeSemesterGPA(double percentage) {
        super(percentage);
    }
    public static List<Double> computeSemGPA(List<Double> markspercentage) {
        List<Double> gpalist = new ArrayList<>();
        for(int i = 0; i < markspercentage.size(); i++) {
            gpalist.add(computationGPA(markspercentage.get(i)));
            }
        System.out.println(gpalist);
        return gpalist;
    }
    public static void main(String[] args){
        System.out.println("Output: ");
        computeSemGPA(List.of(90.0, 85.0, 73.0, 84.9));
    }
}
