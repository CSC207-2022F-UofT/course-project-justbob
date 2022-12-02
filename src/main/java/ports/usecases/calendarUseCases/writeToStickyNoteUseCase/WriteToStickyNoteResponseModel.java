package ports.usecases.calendarUseCases.writeToStickyNoteUseCase;

import entities.calendarSystem.CalendarInterface;
//import entities.calendarSystem.StickyNoteCalendar;
import entities.calendarSystem.StickyNoteInterface;

import java.time.*;

public class WriteToStickyNoteResponseModel {
//setters, and getters
    //should output an updated calendar
    private String title;
    private String type;
    private String location;
    private String time;
    private String[] dotJots;
    private String[] dates;
    //private CalendarInterface calendar;
    private StickyNoteInterface stickyNote;

    public WriteToStickyNoteResponseModel(/*CalendarInterface calendar, */StickyNoteInterface stickyNote) {
        //this.calendar = calendar;
        this.stickyNote = stickyNote;
    }
}
