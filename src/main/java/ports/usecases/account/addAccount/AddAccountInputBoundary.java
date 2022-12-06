package ports.usecases.account.addAccount;

public interface AddAccountInputBoundary {
    void execute(AddAccountRequest request) throws UsernameAlreadyInUseError;

    class UsernameAlreadyInUseError extends Error {
        public UsernameAlreadyInUseError(String username) {
            super("Username already in use: " + username);
        }
    }
}
