package Calculations;

import java.util.List;

public class generalAverage {

    public static double computeAverage(List<Double> marks){
        double average;
        double sum = 0;
        for(int i = 0; i < marks.size(); i++){
            sum += marks.get(i);
        }
        average = (sum / marks.size());
        System.out.println(average);
        return average;
    }
    public static void main(String[] args) {
        System.out.println("Output: ");
        computeAverage(List.of(90.0, 85.0, 73.0, 84.9));
    }


}
