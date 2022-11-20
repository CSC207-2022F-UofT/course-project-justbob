package Calculations;

public class computeGradeLetter {
    private double percentage1;

    public computeGradeLetter(double percentage1){
        this.percentage1 = percentage1;
    }

    public double getPercentage() {
        return percentage1;
    }

    public void setPercentage(double percentage1) {
        this.percentage1 = percentage1;
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
}
