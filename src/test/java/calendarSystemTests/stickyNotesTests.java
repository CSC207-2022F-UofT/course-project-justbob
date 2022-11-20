package calendarSystemTests;

import CalendarSystem.StickyNote;
import org.junit.*;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.*;

public class stickyNotesTests {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetTitle() {
        StickyNote stickyNote = new StickyNote("Study Break", "Miscellaneous");
        stickyNote.setTitle("Jogging");
        assertEquals("Sticky note title changed to Jogging", "Jogging", stickyNote.getTitle());
    }

    @Test
    public void testSetLocation() {
        StickyNote stickyNote = new StickyNote("CSC207 Exam", "Assessment");
        stickyNote.setLocation("EX 100");
        assertEquals("Activity location should be set to EX 100", "EX 100", stickyNote.getLocation());
    }

    @Test
    public void testSetTime() {
        StickyNote stickyNote = new StickyNote("CSC207 Exam", "Assessment");
        stickyNote.setLocation("EX 100");
        stickyNote.setTime("02:00 PM");
        assertEquals("Activity time should be set to 02:00 PM", "02:00 PM", stickyNote.getTime());
    }

    @Test
    public void testPostDaily() {
        StickyNote stickyNote = new StickyNote("CSC236 study time", "Miscellaneous");
        stickyNote.setTime("10:00 AM");
        stickyNote.postDaily(true);
        assertEquals("Sticky note is posted on Sundays", 7, stickyNote.getSundayPost());
        assertEquals("Sticky note is posted on Mondays", 1, stickyNote.getMondayPost());
        assertEquals("Sticky note is posted on Tuesdays", 2, stickyNote.getTuesdayPost());
        assertEquals("Sticky note is posted on Wednesdays", 3, stickyNote.getWednesdayPost());
        assertEquals("Sticky note is posted on Thursdays", 4, stickyNote.getThursdayPost());
        assertEquals("Sticky note is posted on Fridays", 5, stickyNote.getFridayPost());
        assertEquals("Sticky note is posted on Saturdays", 6, stickyNote.getSaturdayPost());

        stickyNote.postDaily(false);
        assertEquals("Sticky note is not posted on Sundays", -7, stickyNote.getSundayPost());
        assertEquals("Sticky note is not posted on Mondays", -1, stickyNote.getMondayPost());
        assertEquals("Sticky note is not posted on Tuesdays", -2, stickyNote.getTuesdayPost());
        assertEquals("Sticky note is not posted on Wednesdays", -3, stickyNote.getWednesdayPost());
        assertEquals("Sticky note is not posted on Thursdays", -4, stickyNote.getThursdayPost());
        assertEquals("Sticky note is not posted on Fridays", -5, stickyNote.getFridayPost());
        assertEquals("Sticky note is not posted on Saturdays", -6, stickyNote.getSaturdayPost());
    }

    @Test
    public void testPostWeekly() {
        StickyNote stickyNote = new StickyNote("CSC236 study time", "Miscellaneous");
        stickyNote.setTime("10:00 AM");
        stickyNote.postWeekly(new String[]{"Monday", "Friday"});
        assertEquals("Sticky note is posted on Mondays", 1, stickyNote.getMondayPost());
        assertEquals("Sticky note is posted on Fridays", 5, stickyNote.getFridayPost());
        stickyNote.postWeekly(new String[]{"Friday"});
        assertEquals("Sticky note is not posted on Mondays", -1, stickyNote.getMondayPost());
        assertEquals("Sticky note is still posted on Fridays", 5, stickyNote.getFridayPost());
    }

    @Test
    public void testSetAndRemoveNotification() {
        StickyNote stickyNote = new StickyNote("CSC207 Exam", "Assessment");
        stickyNote.setLocation("EX 100");
        stickyNote.setTime("02:00 PM");
        stickyNote.setNotification("December 16, 2022", "02:00 PM");

        assertEquals("A notification is set for this sticky note", 1, stickyNote.getNotifications().size());

        stickyNote.removeAllNotifications();

        assertEquals("All notifications are removed from the sticky note", 0, stickyNote.getNotifications().size());
    }

    @Test
    public void testWriteToStickyNote() {
        StickyNote stickyNote = new StickyNote("CSC207 Exam", "Assessment");
        stickyNote.setLocation("EX 100");
        stickyNote.setTime("02:00 PM");
        String[] stickyNoteText = {"Last names: A - J", "remember student card"};
        stickyNote.writeToStickyNote(stickyNoteText);
        File path = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes");
        File file = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes/" + stickyNote.getTitle() + ".txt");

        assertEquals("there is one sticky note file", 1, path.list().length);

        if (file.exists()) {
            file.delete();
        }

        assertEquals("sticky note file is deleted", 0, path.list().length);
    }
}
