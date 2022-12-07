package ports.usecases.account.loginAccount;

import ports.usecases.gpaTrend.TrendModel;

import java.util.List;

public class LoginAccountResponse {
    public String semesterTitle;
    public List<String> courseCodes;
    public TrendModel trendModel;

    //  may need more info:
    //  data of one course to display
    //  checklist data
    //  calendar data
    //  number of courses in archive

    public LoginAccountResponse() {}

    public LoginAccountResponse(String semesterTitle, List<String> courseCodes, TrendModel trendModel) {
        this.semesterTitle = semesterTitle;
        this.courseCodes = courseCodes;
        this.trendModel = trendModel;
    }
}
