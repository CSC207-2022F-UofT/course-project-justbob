package ports.usecases.calendar.removeStickyNoteUseCase;

import screens.RemoveStickyNoteDataAccess;
import screens.RemoveStickyNotePresenter;

import java.io.File;

public class RemoveStickyNoteInteractor implements RemoveStickyNoteInputBoundary {
    private RemoveStickyNoteDataAccess dataAccessGateway;
    private RemoveStickyNotePresenter removeStickyNotePresenter;

    public RemoveStickyNoteInteractor(RemoveStickyNoteDataAccess dataAccessGateway, RemoveStickyNotePresenter presenter) {
        this.dataAccessGateway = dataAccessGateway;
        this.removeStickyNotePresenter = presenter;
    }

    @Override
    public RemoveStickyNoteResponseModel execute(RemoveStickyNoteRequestModel requestModel) {
        dataAccessGateway.delete(requestModel);
        //File fileName = new File(System.getProperty("user.dir"), "src/main/java/inMemoryDB/StickyNotes/" + requestModel.getTitle() + ".txt");
        //RemoveStickyNoteResponseModel responseModel = new RemoveStickyNoteResponseModel(fileName.exists());
        return removeStickyNotePresenter.prepareSuccessView(requestModel);
    }
}
