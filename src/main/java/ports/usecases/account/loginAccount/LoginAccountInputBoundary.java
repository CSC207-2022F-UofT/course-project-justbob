package ports.usecases.account.loginAccount;

public interface LoginAccountInputBoundary {
    /**
     * Log into an Account
     *
     * @param request the username and password to use
     * @return preliminary account data
     * @throws LoginError if the username is not found or the password is incorrect.
     */
    LoginAccountResponse execute(LoginAccountRequest request) throws LoginError;


    class LoginError extends Error {
        public LoginError(String message) {
            super("Login Error: " + message);
        }
    }
}
