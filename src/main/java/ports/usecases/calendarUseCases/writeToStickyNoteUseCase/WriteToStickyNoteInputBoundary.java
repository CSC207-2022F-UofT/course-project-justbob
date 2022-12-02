package ports.usecases.calendarUseCases.writeToStickyNoteUseCase;

import java.io.IOException;

public interface WriteToStickyNoteInputBoundary {
    WriteToStickyNoteResponseModel execute(WriteToStickyNoteRequestModel requestModel) throws IOException;
}
