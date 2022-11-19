public class mathGpaCgpa {
    private double percentage;

    /**
     * Construct a mathGpaCgpa class which consists of methods needed in GPA and CGPA class
     * @param percentage number in terms of percentage for course between 0% to 100%
     */
    public mathGpaCgpa(double percentage){
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    /**
     * Converts the mark from in terms of percentage (double) to GPA value in terms of
     * UofT GPA scale (double)
     * @return a double of in terms of GPA scale
     */
    public double percentToGPA(){
        if(percentage >= 85){
            return 4.0;
        }else if(percentage >= 80){
            return 3.7;
        }else if(percentage >= 77){
            return 3.3;
        }else if(percentage >= 73){
            return 3.0;
        }else if(percentage >= 70){
            return 2.7;
        }else if(percentage >= 67){
            return 2.3;
        }else if(percentage >= 63){
            return 2.0;
        }else if (percentage >=60){
            return 1.7;
        }else if (percentage >= 57){
            return 1.3;
        }else if (percentage >= 53){
            return 1.0;
        }else if (percentage >= 50){
            return 0.7;
        }else {
            return 0.0;
        }
    }

    /**
     * Converts percentage (double) to a lettered Grade (String)
     * @return a String of a lettered Grade ranging from F to A+
     */

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
