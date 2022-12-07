package ports.usecases.course.viewCourse;

public class ViewCourseResponse {
    public String username;

    public String courseCode;

    public String courseTitle;

    public String credit;

    public String[] assessmentTitles;

    public Integer[] assessmentNumberOfInstances;

    public Double[] assessmentWeights;

    public String runningGrade;

    public String hypotheticalGrade;

    public ViewCourseResponse(){}

    public ViewCourseResponse(String username, String courseCode, String courseTitle, String credit,
                              String[] assessmentTitles, Integer[] assessmentNumberOfInstances, Double[] assessmentWeights,
                              String runningGrade, String hypotheticalGrade) {
        this.username = username;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.assessmentTitles = assessmentTitles;
        this.assessmentNumberOfInstances = assessmentNumberOfInstances;
        this.assessmentWeights = assessmentWeights;
        this.runningGrade = runningGrade;
        this.hypotheticalGrade = hypotheticalGrade;
    }
}
