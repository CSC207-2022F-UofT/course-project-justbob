package usecases.account;

import entities.account.Account;
import ports.database.EntityGateway;
import ports.usecases.account.loginAccount.LoginAccountInputBoundary;
import ports.usecases.account.loginAccount.LoginAccountRequest;
import ports.usecases.account.loginAccount.LoginAccountResponse;
import usecases.gpaTrend.GetAccountTrendUseCase;

// TODO: implement testing
public class LoginAccountUseCase implements LoginAccountInputBoundary {
    private final EntityGateway entityGateway;

    public LoginAccountUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public LoginAccountResponse execute(LoginAccountRequest request) throws LoginError {
        if (!entityGateway.existsAccount(request.username)) {
            throw new LoginError("Username not found.");
        }
        Account account = entityGateway.loadAccount(request.username);
        if (account.getPassword().equals(request.password)) {
            throw new LoginError("Incorrect Password");
        }
        return createResponse(account);
    }

    private LoginAccountResponse createResponse(Account account) {
        LoginAccountResponse response = new LoginAccountResponse();
        response.semesterTitle = account.getSemester().getTitle();
        response.courseCodes = (String[]) account.getSemester().getRunningCourses().stream()
                .map(course -> course.getCourseCode())
                .toArray();
        response.trendModel = new GetAccountTrendUseCase(entityGateway).execute(account.getUsername());
        return response;
    }
}
