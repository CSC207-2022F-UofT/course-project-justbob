package calendarSystemTests;

import CalendarSystem.Calendar;
import CalendarSystem.StickyNote;
import org.junit.*;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.*;

public class calendarTests {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTodayEqualsSeekedDate() {
        Calendar calendar = new Calendar();
        assertEquals("today's date should equal the seeked date at time of construction", calendar.getToday(), calendar.getSeekedDate());
    }

    @Test
    public void testTodayDoesNotEqualChangedSeekedDate() {
        Calendar calendar = new Calendar();
        calendar.goToDate(2022, 10, 6);
        assertFalse("today's date does not equal the seeked date after going to a different date", calendar.getToday() == calendar.getSeekedDate());
    }

    @Test
    public void testPostAndRemoveStickyNote() {
        StickyNote stickyNote = new StickyNote("CSC236 Problem Set 10", "Assessment");
        Calendar calendar = new Calendar();
        calendar.postStickyNote(stickyNote);
        String[] stickyNoteText = {"strings", "regular expressions"};
        stickyNote.writeToStickyNote(stickyNoteText);
        File test = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes");

        assertEquals("calendar has one sticky note", 1, calendar.getStickyNotes().size());
        assertEquals("there is one sticky note file", 1, test.list().length);
        calendar.removeStickyNote(stickyNote);
        assertEquals("calendar should have zero sticky notes", 0, calendar.getStickyNotes().size());
        assertEquals("there are zero sticky note files", 0, test.list().length);
    }

    /*@Test
    public void testRemoveStickyNote() {
        StickyNote stickyNote = new StickyNote("CSC236 Problem Set 10", "Assessment");
        StickyNote stickyNote2 = new StickyNote("Bobsledding", "Miscellaneous");
        Calendar calendar = new Calendar();
        calendar.postStickyNote(stickyNote);
        calendar.postStickyNote(stickyNote2);
        String[] stickyNoteText = {"strings", "regular expressions"};
        String[] stickyNoteText2 = {"buy a bobsled", "remember to bring a helmet"};
        stickyNote.writeToStickyNote(stickyNoteText);
        stickyNote2.writeToStickyNote(stickyNoteText2);
        calendar.removeStickyNote(stickyNote);
        calendar.removeStickyNote(stickyNote2);
        File test = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes");

        assertEquals("calendar should have zero sticky notes", 0, calendar.getStickyNotes().size());
        assertEquals("there are zero sticky note files", 0, test.list().length);
    }*/
}
