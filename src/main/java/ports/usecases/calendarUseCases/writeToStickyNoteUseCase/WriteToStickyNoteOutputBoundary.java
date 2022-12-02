package ports.usecases.calendarUseCases.writeToStickyNoteUseCase;

public interface WriteToStickyNoteOutputBoundary {
    WriteToStickyNoteResponseModel prepareSuccessView(WriteToStickyNoteRequestModel writeToStickyNoteRequestModel);
}
