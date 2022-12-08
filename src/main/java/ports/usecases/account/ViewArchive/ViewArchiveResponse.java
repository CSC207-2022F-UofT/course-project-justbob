package ports.usecases.account.ViewArchive;

public class ViewArchiveResponse {
    public String username;
    public String semesterTitle;
    public String[] courseCodes;
    public String[] courseTitles;
    public Double[] courseGrades;

    public Double[] courseCredits;

    public String cGPA;

    public ViewArchiveResponse(){

    }

    public ViewArchiveResponse(String username, String semesterTitle, String[] courseCodes, String[] courseTitles, Double[] courseGrades,
                               String cGPA) {
        this.username = username;
        this.semesterTitle = semesterTitle;
        this.courseCodes = courseCodes;
        this.courseTitles = courseTitles;
        this.courseGrades = courseGrades;
        this.cGPA= cGPA;
    }

}
