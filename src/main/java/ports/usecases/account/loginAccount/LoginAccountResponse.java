package ports.usecases.account.loginAccount;

import ports.usecases.gpaTrend.TrendModel;

public class LoginAccountResponse {
    public String semesterTitle;
    public String[] courseCodes;
    public String[] courseTitles;
    public Double[] courseGrades;
    public TrendModel trendModel;

    public LoginAccountResponse() {
    }

    public LoginAccountResponse(String semesterTitle, String[] courseCodes, String[] courseTitles, Double[] courseGrades, TrendModel trendModel) {
        this.semesterTitle = semesterTitle;
        this.courseCodes = courseCodes;
        this.courseTitles = courseTitles;
        this.courseGrades = courseGrades;
        this.trendModel = trendModel;
    }
}
