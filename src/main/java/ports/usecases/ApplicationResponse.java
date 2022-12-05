package ports.usecases;

import ports.usecases.gpaTrend.TrendModel;

public class ApplicationResponse {
    public String username;
    public String semesterTitle;
    public String[] courseCodes;
    public String[] courseTitles;
    public Double[] courseGrades;
    public TrendModel trendModel;

    public ApplicationResponse() {
    }

    public ApplicationResponse(String username, String semesterTitle, String[] courseCodes, String[] courseTitles, Double[] courseGrades, TrendModel trendModel) {
        this.username = username;
        this.semesterTitle = semesterTitle;
        this.courseCodes = courseCodes;
        this.courseTitles = courseTitles;
        this.courseGrades = courseGrades;
        this.trendModel = trendModel;
    }
}
