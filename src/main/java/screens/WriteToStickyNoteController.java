package screens;

import ports.usecases.calendarUseCases.writeToStickyNoteUseCase.WriteToStickyNoteInputBoundary;
import ports.usecases.calendarUseCases.writeToStickyNoteUseCase.WriteToStickyNoteRequestModel;
import ports.usecases.calendarUseCases.writeToStickyNoteUseCase.WriteToStickyNoteResponseModel;

import java.io.IOException;
import java.time.*;

public class WriteToStickyNoteController {
    final WriteToStickyNoteInputBoundary userInput;

    public WriteToStickyNoteController(WriteToStickyNoteInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    WriteToStickyNoteResponseModel create(String title, String type, String location, String time, String[] dotJots, String dates) throws IOException {
        String[] stringDates = dates.split(";");
        LocalDate[] listOfDates = new LocalDate[stringDates.length];
        for (int i = 0; i < listOfDates.length; i++) {
            //default date format: yyyy-mm-dd
            listOfDates[i] = LocalDate.parse(stringDates[i]);
        }
        WriteToStickyNoteRequestModel requestModel = new WriteToStickyNoteRequestModel(
                title, type, location, time, dotJots, listOfDates);

        return userInput.execute(requestModel);
    }
}
