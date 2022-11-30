package ports.usecases.assessment.commitMarkUseCase;

public class CommitMarkResponse {

    public boolean commitSuccessful;

    public CommitMarkResponse() {}

    public CommitMarkResponse(boolean commitSuccessful) {
        this.commitSuccessful = commitSuccessful;
    }
}
