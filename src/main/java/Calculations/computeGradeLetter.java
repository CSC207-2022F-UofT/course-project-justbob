package Calculations;

public class computeGradeLetter {
    private double percentage;

    public computeGradeLetter(double percentage){
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public String percentToGrade(){
        if(percentage >= 90){
            return "A+";
        }else if(percentage >= 85){
            return "A";
        }else if(percentage >= 80){
            return "A-";
        }else if(percentage >= 77){
            return "B+";
        }else if(percentage >= 73){
            return "B";
        }else if(percentage >= 70){
            return "B-";
        }else if(percentage >= 67){
            return "C+";
        }else if(percentage >= 63){
            return "C";
        }else if(percentage >= 60){
            return "C-";
        }else if(percentage >= 57){
            return "D+";
        }else if(percentage >= 55){
            return "D";
        }else if(percentage >= 50){
            return "D-";
        }else {
            return "F";
        }
    }
}
