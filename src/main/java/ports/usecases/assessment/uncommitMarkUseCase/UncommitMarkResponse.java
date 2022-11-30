package ports.usecases.assessment.uncommitMarkUseCase;

public class UncommitMarkResponse {
    public boolean uncommitSuccessful;

    public UncommitMarkResponse() {}

    public UncommitMarkResponse(boolean uncommitSuccessful) {
        this.uncommitSuccessful = uncommitSuccessful;
    }
}

