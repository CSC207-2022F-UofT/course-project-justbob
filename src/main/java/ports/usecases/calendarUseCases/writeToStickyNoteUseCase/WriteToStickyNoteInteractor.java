package ports.usecases.calendarUseCases.writeToStickyNoteUseCase;

import entities.calendarSystem.CalendarFactory;
import entities.calendarSystem.CommonStickyNoteFactory;
import entities.calendarSystem.StickyNoteFactory;
import entities.calendarSystem.StickyNoteInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

public class WriteToStickyNoteInteractor implements WriteToStickyNoteInputBoundary {
    final WriteToStickyNoteDsGateway writeToStickyNoteDsGateway;
    final WriteToStickyNoteOutputBoundary writeToStickyNoteOutputBoundary;
    final StickyNoteFactory stickyNoteFactory;
//    final CalendarFactory calendarFactory;
    // requires file writer,

    public WriteToStickyNoteInteractor(StickyNoteFactory stickyNoteFactory, WriteToStickyNoteOutputBoundary writeToStickyNoteOutputBoundary, WriteToStickyNoteDsGateway writeToStickyNoteDsGateway) {
        this.stickyNoteFactory = stickyNoteFactory;
        this.writeToStickyNoteOutputBoundary = writeToStickyNoteOutputBoundary;
        this.writeToStickyNoteDsGateway = writeToStickyNoteDsGateway;
    }

    /**
     * Writes a sticky note, and adds it to the calendar.
     * */
    @Override
    public WriteToStickyNoteResponseModel execute(WriteToStickyNoteRequestModel requestModel) throws IOException {
        StickyNoteInterface stickyNote = stickyNoteFactory.create(requestModel.getTitle(), requestModel.getType(), requestModel.getLocation(), requestModel.getTime(), requestModel.getDotJots(), requestModel.getDates());
        //pass calendar, and add sticky note to its arraylist

        //        if (!user.passwordIsValid()) {
//            return userPresenter.prepareFailView("User password must have more than 5 characters.");
//        }
//
//        LocalDateTime now = LocalDateTime.now();
//        UserRegisterDsRequestModel userDsModel = new UserRegisterDsRequestModel(user.getName(), user.getPassword(), now);
//        userDsGateway.save(userDsModel);
//
//        WriteToStickyNoteResponseModel stickyNoteResponseModel = new WriteToStickyNoteResponseModel(user.getName(), now.toString());
//        return writeToStickyNoteOutputBoundary.prepareSuccessView(stickyNoteResponseModel);
        //this task should go in the data access gateway. Maybe break the reading and writing into separate classes
        //BufferedWriter out = new BufferedWriter(new FileWriter(System.getProperty("user.dir"), "src/main/java/ports/database/" + account.getUsername()/*please create a username folder during account creation*/ + "/StickyNotes\\" + requestModel.getTitle() + ".txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(System.getProperty("user.dir"), "src/main/java/test.txt"));
        out.write(stickyNote.getTitle());
        out.newLine();
        out.write(stickyNote.getType());
        out.newLine();
        out.write(stickyNote.getLocation());
        out.newLine();
        for (int i = 0; i < stickyNote.getDates().length; i++) {
            out.write(String.valueOf(stickyNote.getDates()[i]));
            out.newLine();
        }
        out.write(stickyNote.getTime());
        out.newLine();
        for (int j = 0; j < stickyNote.getDotJots().length; j++) {
            out.write(stickyNote.getDotJots()[j]);
        }
        out.close();
        WriteToStickyNoteResponseModel stickyNoteResponseModel = new WriteToStickyNoteResponseModel(stickyNote);
        return stickyNoteResponseModel;
        return null;
    }
}
