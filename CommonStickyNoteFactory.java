package entities.calendarSystem;

public class CommonStickyNoteFactory implements StickyNoteFactory {
    @Override
    public StickyNoteInterface create(String title, String type, String location, String[] dotJots, String[] dates) {
        return new CommonStickyNote(title, type, location, dotJots, dates);
    }
}
