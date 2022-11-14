package calendarSystem;

import java.util.*;
import java.time.*;
import java.io.*;

public class Calendar {
    private LocalDateTime currDateAndTime;
    private LocalDate today;
    private LocalDate seekedDate;
    private ArrayList<StickyNote> stickyNotes = new ArrayList<>();
    //private ArrayList<Notification> notifications = new ArrayList<>();
    private int viewA = 1;
    private int viewT = 2;
    private int viewM = 3;

    public Calendar() {
        currDateAndTime = LocalDateTime.now();
        today = LocalDate.now();
        seekedDate = LocalDate.now();
    }

    public void updateDateAndTime() {
        currDateAndTime = LocalDateTime.now();
        today = LocalDate.now();
        seekedDate = LocalDate.now();
    }

    public LocalDate getToday() {
        return today;
    }

    public LocalDate getSeekedDate() {
        return seekedDate;
    }

    public void toggleAssessments() {
        viewA = -viewA;
    }

    public void toggleTimetable() {
        viewT = -viewT;
    }

    public void toggleMiscellaneous() {
        viewM = -viewM;
    }

    public LocalDate goToDate(int year, int month, int day) {
        seekedDate = LocalDate.of(year, month, day);
        return seekedDate;
    }

    public void postStickyNote(StickyNote post) {
        stickyNotes.add(post);
    }

    public void removeStickyNote(StickyNote post) {
        File f = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\UserDirectoryFilePathTest.txt");
        if (f.exists()/* && !f.isDirectory()*/) {
            f.delete();
        }
        stickyNotes.remove(post);
    }

    public ArrayList<StickyNote> getStickyNotes() {
        return stickyNotes;
    }

    //public Date getDay() {}

    //public Date[] getWeek() {}

    //public Date[][] getMonth() {}

    //public void nextPage() {}

    //public void prevPage() {}
}
