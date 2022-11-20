package Calculations;

public class computeGPA {
    private double percentage;

    public computeGPA(double percentage){
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

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
}
