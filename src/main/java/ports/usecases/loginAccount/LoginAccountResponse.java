package ports.usecases.loginAccount;

public class LoginAccountResponse {
    public String semesterTitle;
    public String[] courseCodes;

    // TODO: may need more info:
    //  data of one course to display
    //  checklist data
    //  calendar data
    //  number of courses in archive

    public LoginAccountResponse() {}

    public LoginAccountResponse(String semesterTitle, String[] courseCodes) {
        this.semesterTitle = semesterTitle;
        this.courseCodes = courseCodes;
    }
}
