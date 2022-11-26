package usecases.accountOperations;

import entities.account.Account;
import ports.database.EntityGateway;
import ports.usecases.account.loginAccount.LoginAccountInputBoundary;
import ports.usecases.account.loginAccount.LoginAccountRequest;
import ports.usecases.account.loginAccount.LoginAccountResponse;

public class LoginAccountUseCase implements LoginAccountInputBoundary {
    private EntityGateway entityGateway;

    public LoginAccountUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public LoginAccountResponse execute(LoginAccountRequest request) throws LoginError {
        if (!entityGateway.existsAccount(request.username)) {
            // TODO: specify that username was not found.
            throw new LoginError();
        }
        Account account = entityGateway.loadAccount(request.username);
        if (account.getPassword() != request.password) {
            // TODO: specify that password is incorrect.
            throw new LoginError();
        }
        return createResponse(account);
    }

    private LoginAccountResponse createResponse(Account account) {
        LoginAccountResponse response = new LoginAccountResponse();
        response.semesterTitle = account.getSemester().getTitle();
        response.courseCodes = (String[]) account.getSemester().getRunningCourses().stream()
                .map(course -> course.getCourseCode())
                .toArray();
        return response;
    }
}
