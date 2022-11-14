package calendarSystemTests;

import CalendarSystem.*;
import org.junit.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class notificationTests {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testOneArgConstructor() {
        Notification notification = new Notification(LocalDateTime.of(2022, 11, 24, 21,00));
        StickyNote stickyNote = new StickyNote("CSC236 Problem Set 10", "Assessment");
        stickyNote.setNotification("November 24, 2022", "09:00 PM");
        assertEquals("The notification is set 24 hours before the event", "2022-11-23T21:00", notification.getNotificationTime());
        assertEquals("stickyNote has one notification", 1, stickyNote.getNotifications().size());
    }

    @Test
    public void testTwoArgConstructor() {
        Notification notification = new Notification(LocalDateTime.of(2022, 11, 25, 11,30), 604800000);
        StickyNote stickyNote = new StickyNote("Pudding Club Meeting", "Miscellaneous");
        stickyNote.setNotification("November 25, 2022", "11:00 AM");
        assertEquals("The notification is set 24 hours before the event", "2022-11-24T11:30", notification.getNotificationTime());
        assertEquals("The period is weekly in milliseconds", 604800000, notification.getPeriod());
        stickyNote.removeAllNotifications();
        assertEquals("stickyNote has zero notifications", 0, stickyNote.getNotifications().size());
    }
}
