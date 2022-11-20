package Calculations;

public class GPA extends mathGpaCgpa  {
    private double percentage;
    private double gpa;
    private String grade = "";


    /**
     * Construct a Calculations.GPA, giving them the semester list from runningCourse and courseMarks from the outline.
     * @param percentage The course mark in terms of percentage scale from 0% to 100%
     * @param gpa The course mark in terms of point scale varying from 0 to 4.0
     * @param grade The course mark in terms of lettered Grades ranging from F to A+
     */
    public GPA(double percentage, double gpa, String grade){
        super(percentage);
        this.gpa = gpa;
        this.grade = grade;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getGpa() {
        return gpa;
    }

    public String getGrade() {
        return grade;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Converts the mark from in terms of percentage (double) to Calculations.GPA value in terms of
     * UofT Calculations.GPA scale (double)
     *
     * @return a double of in terms of Calculations.GPA scale
     */
    // ArrayList<ArrayList<Double>> percentage
    public static Double[][] convertPercentToGPA(){
        /**
         * Take a 2D array consisting of first element being weight and then element being percentage
         * and then converting the list to showcase weight and GPA
         */
        Double marks[][]= {{0.5, 85.0}, {1.0, 78.0}, {0.5, 72.0}, {1.0, 77.0}};

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][1] = percentToGPA(marks[i][1]);
            }
        }
        for (Double[] x: marks) {
            System.out.println(x[0] + ", " + x[1]);

        }
        return marks;
    }



    /**
     * Takes a list of the courseMarks from the outline class (in terms of pecentage) and then
     * loops through list converting it into the Calculations.GPA scale using helper function above. Calculations.GPA scale
     * added to new Arraylist called gpalist
     *
     * @return an Arraylist of double consisting of marks in Calculations.GPA scale
     */

    /**
    public List<Double> calculateCourseGPA(){
        List<Double> list = courseMarks.getList();
        List<Double> gpalist = new ArrayList<>();

        for(int i = 0; i < list.size(); i ++) {
            gpalist.add(percentToGPA(list.get(i)));
        }
        return gpalist;
    }

    /**
     * Converts percentage (double) to a lettered Grade (String)
     * @return a String of a lettered Grade ranging from F to A+
     */
/**
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
 *
 */

    /**
     * Take a list of courseMarks from the outline class (in terms of pecentage) and then
     * loops through list converting it from percentage to lettered Grade using helper function
     * above. Lettered Grades added to new arraylist called gradeList
     *
     * @return Arraylist (gradeList) of Strings of lettered Grades
     */



//    public List<String> showGrade(){
//        List<Double> list1 = courseMarks.getList();
//        List<String> gradeList = new ArrayList<>();
//
//        for(int i = 0; i < list1.size(); i ++){
//            gradeList.add(percentToGrade(list1.get(i)));
//        }
//        return gradeList;
//    }

    /**
     * Takes list of doubles called semlist which is list of percentages for courses in semester.
     * Calculates the total average of the courses in terms of percentage by dividing sum of
     * all courses by the size of list
     *
     * @return a double of average
     */
//    public double showPercentSemester(){
//        List<Double> semlist = semester.getList();
//        double average;
//        double sum = 0;
//        for(int i = 0; i < semlist.size(); i++){
//            sum += semlist.get(i);
//        }
//        average = (sum / semlist.size());
//        return average;
//
//    }

    /**
     * Calls calculateCourseGPA() to receive list of marks in Calculations.GPA scale.
     * Takes list and take sum of all GPAs and outputs the average Calculations.GPA for semester
     * @return a double of semester Calculations.GPA
     */
//    public double showGPASemester(){
//        calculateCourseGPA();
//        double sumGPA = 0;
//        double semesterGPA = 0;
//        for(int i = 0; i < calculateCourseGPA().size(); i ++){
//            sumGPA += calculateCourseGPA().get(i);
//        }
//        semesterGPA = (sumGPA / calculateCourseGPA().size());
//        return semesterGPA;
//    }
    ;
    public static void main(String[] args)
    {

        System.out.println("2D ArrayList :");
        convertPercentToGPA();
    }
}

