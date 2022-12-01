package entities.calendarSystem;

import java.time.LocalDate;

public class CommonStickyNoteFactory implements StickyNoteFactory {
    @Override
    public StickyNoteInterface create(String title, String type, String location, String[] dotJots, LocalDate[] dates) {
        return new CommonStickyNote(title, type, location, dotJots, dates);
    }
}
