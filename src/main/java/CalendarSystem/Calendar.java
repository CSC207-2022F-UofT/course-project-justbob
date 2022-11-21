package CalendarSystem;

import java.util.*;
import java.time.*;
import java.io.*;

/**
 * Aggregated class. Manages sticky notes, and keeps track of the date.
 * */
public class Calendar {
    private LocalDateTime currDateAndTime;
    private LocalDate today;
    private LocalDate seekedDate;
    private ArrayList<StickyNote> stickyNotes = new ArrayList<>();
    //private ArrayList<Notification> notifications = new ArrayList<>();
    private int viewA = 1;
    private int viewT = 2;
    private int viewM = 3;

    /**
     * Constructor class keeps track of the current date and time,
     * and an additional tracking date to view other dates.
     * */
    public Calendar() {
        currDateAndTime = LocalDateTime.now();
        today = LocalDate.now();
        seekedDate = LocalDate.now();
    }

    /**
     * Updates current date and time.
     * */
    public void updateDateAndTime() {
        currDateAndTime = LocalDateTime.now();
        today = LocalDate.now();
        seekedDate = LocalDate.now();
    }

    /**
     * Returns today's date.
     * */
    public LocalDate getToday() {
        return today;
    }

    /**
     * Returns date user wants to view.
     * */
    public LocalDate getSeekedDate() {
        return seekedDate;
    }

    /**
     * Toggles assessment sticky notes.
     * */
    public void toggleAssessments() {
        viewA = -viewA;
    }

    /**
     * Toggles timetable sticky notes.
     * */
    public void toggleTimetable() {
        viewT = -viewT;
    }

    /**
     * Toggle miscellaneous sticky notes.
     * */
    public void toggleMiscellaneous() {
        viewM = -viewM;
    }

    /**
     * Registers year, month, and day as the tracked date.
     * Returns the tracked date.
     * */
    public LocalDate goToDate(int year, int month, int day) {
        seekedDate = LocalDate.of(year, month, day);
        return seekedDate;
    }

    /**
     * Adds the given sticky note to calendar.
     * */
    public void postStickyNote(StickyNote post) {
        stickyNotes.add(post);
    }

    /**
     * Removes the given sticky note from the calendar.
     * */
    public void removeStickyNote(StickyNote post) {
        File f = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\" + post.getTitle() + ".txt");
        if (f.exists()/* && !f.isDirectory()*/) {
            f.delete();
        }
        stickyNotes.remove(post);
    }


    /**
     * Returns all the sticky notes posted to the calendar.
     * */
    public ArrayList<StickyNote> getStickyNotes() {
        return stickyNotes;
    }

    //public Date getDay() {}

    //public Date[] getWeek() {}

    //public Date[][] getMonth() {}

    //public void nextPage() {}

    //public void prevPage() {}
}
