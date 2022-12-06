package usecases.account.LoginAccount;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import ports.usecases.account.loginAccount.LoginAccountInputBoundary;
import ports.usecases.account.loginAccount.LoginAccountRequest;
import usecases.gpaTrend.GetAccountTrendUseCase;

// TODO: implement testing
public class LoginAccountUseCase implements LoginAccountInputBoundary {
    private final EntityGateway entityGateway;

    public LoginAccountUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public ApplicationResponse execute(LoginAccountRequest request) throws LoginError {
        if (!entityGateway.existsAccount(request.username)) {
            throw new LoginError("Username not found.");
        }
        Account account = entityGateway.loadAccount(request.username);
        if (!account.getPassword().equals(request.password)) {
            throw new LoginError("Incorrect Password");
        }
        return createResponse(account);
    }

    private ApplicationResponse createResponse(Account account) {
        ApplicationResponse response = new ApplicationResponse();
        response.username = account.getUsername();
        response.semesterTitle = account.getSemester().getTitle();
        response.courseCodes = account.getSemester().getRunningCourses().stream()
                .map(Course::getCourseCode)
                .toArray(String[]::new);
        response.courseTitles = account.getSemester().getRunningCourses().stream()
                .map(Course::getCourseName)
                .toArray(String[]::new);
        response.courseGrades = new Double[response.courseCodes.length];
        int index = 0;
        for (Course course : account.getSemester().getRunningCourses()) {
            response.courseGrades[index] = course.getOutline().computeRunningGrade();
            index += 1;
        }
        response.trendModel = new GetAccountTrendUseCase(entityGateway).execute(account.getUsername());
        return response;
    }
}
