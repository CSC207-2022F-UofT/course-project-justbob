package Calculations;

import java.util.List;

public class computeCredits {
    private double credit;

    public computeCredits(double credit){
        this.credit = credit;
    }
    public static double totalCredits(List<Double> courseCredits){
        double total = 0;
        for(int i = 0; i < courseCredits.size(); i++){
            total += courseCredits.get(i);
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        System.out.println("Output: ");
        totalCredits(List.of(0.5, 1.0, 0.5, 0.5));
    }
}

