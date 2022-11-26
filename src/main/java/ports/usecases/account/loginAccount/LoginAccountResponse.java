package ports.usecases.account.loginAccount;

import ports.usecases.gpaTrend.TrendModel;

public class LoginAccountResponse {
    public String semesterTitle;
    public String[] courseCodes;
    public TrendModel trendModel;

    // TODO: may need more info:
    //  data of one course to display
    //  checklist data
    //  calendar data
    //  number of courses in archive

    public LoginAccountResponse() {}

    public LoginAccountResponse(String semesterTitle, String[] courseCodes, TrendModel trendModel) {
        this.semesterTitle = semesterTitle;
        this.courseCodes = courseCodes;
        this.trendModel = trendModel;
    }
}
