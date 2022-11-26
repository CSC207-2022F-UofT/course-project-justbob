package ports.usecases.loginAccount;

public interface LoginAccountInputBoundary {
    /**
     * Log into an Account
     * @param request the username and password to use
     * @return preliminary account data
     * @throws LoginError if the username is not found or the password is incorrect.
     */
    public LoginAccountResponse execute(LoginAccountRequest request) throws LoginError;
}
