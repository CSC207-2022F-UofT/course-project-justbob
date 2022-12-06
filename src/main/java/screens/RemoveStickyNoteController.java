package screens;

import ports.usecases.calendar.removeStickyNoteUseCase.RemoveStickyNoteInputBoundary;
import ports.usecases.calendar.removeStickyNoteUseCase.RemoveStickyNoteResponseModel;

public class RemoveStickyNoteController {
    final RemoveStickyNoteInputBoundary userInput;

    public RemoveStickyNoteController(RemoveStickyNoteInputBoundary inputBoundary) {
        this.userInput = inputBoundary;
    }

    //RemoveStickyNoteResponseModel delete() {}
}
