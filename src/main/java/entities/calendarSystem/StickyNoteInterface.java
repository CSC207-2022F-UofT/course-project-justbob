package entities.calendarSystem;

import java.time.LocalDate;

public interface StickyNoteInterface {

    String getTitle();

    String getType();

    String getLocation();

    String[] getDotJots();

    LocalDate[] getDates();

    String getTime();
}
