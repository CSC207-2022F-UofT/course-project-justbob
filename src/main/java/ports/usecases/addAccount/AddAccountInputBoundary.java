package ports.usecases.addAccount;

public interface AddAccountInputBoundary {
    void execute(AddAccountRequest request) throws UsernameAlreadyInUseError;
}
