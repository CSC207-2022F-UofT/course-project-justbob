package ports.usecases.addAccount;

public interface AddAccountInputBoundary {
    void execute(AddAccountRequest request) throws UsernameAlreadyInUseError;

    // TODO: Include info about the username
    class UsernameAlreadyInUseError extends Error {}
}
