package entities.calendarSystem;

public class CommonStickyNote implements StickyNoteInterface {
    private final String title;
    private final String type;
    private final String location;
    private final String[] dotJots;
    private final String[] dates;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String[] getDotJots() {
        return dotJots;
    }

    @Override
    public String[] getDates() {
        return dates;
    }
}
