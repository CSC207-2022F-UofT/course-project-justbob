package entities.calendarSystem;

import java.time.LocalDate;

public class CommonStickyNote implements StickyNoteInterface {
    private final String title;
    private final String type;
    private final String location;
    private final String time;
    private final String[] dotJots;
    private final LocalDate[] dates;

    CommonStickyNote(String title, String type, String location, String time, String[] dotJots, LocalDate[] dates) {
        this.title = title;
        this.type = type;
        this.location = location;
        this.time = time;
        this.dotJots = dotJots;
        this.dates = dates;
    }

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
    public String getTime() {
        return time;
    }

    @Override
    public String[] getDotJots() {
        return dotJots;
    }

    @Override
    public LocalDate[] getDates() {
        return dates;
    }
}
