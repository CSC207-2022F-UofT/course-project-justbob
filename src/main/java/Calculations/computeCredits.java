package Calculations;

import java.util.List;

public class computeCredits {
    private double credit;

    public computeCredits(double credit){
        this.credit = credit;
    }
    public static double totalCredits(List<Double> courseCredits){
        int total = 0;
        for(int i = 0; i < courseCredits.size(); i++){
            total += courseCredits.get(i);
        }
        return total;
    }
}
