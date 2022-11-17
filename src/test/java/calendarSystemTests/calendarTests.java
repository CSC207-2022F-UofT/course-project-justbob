package calendarSystemTests;

import calendarSystem.*;
import calendarSystem.Calendar;
import org.junit.*;
import java.util.*;
import java.time.*;

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


}
