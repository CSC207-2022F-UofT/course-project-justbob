package screens;

import entities.calendarSystem.CalendarFactory;
import entities.calendarSystem.StickyNoteCalendarFactory;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.event.*;

public class CalendarMain extends JPanel implements ActionListener {
    JButton goToSeekedDateButton = new JButton();
    JButton nextPage = new BasicArrowButton(BasicArrowButton.EAST);
    JButton prevPage = new BasicArrowButton(BasicArrowButton.WEST);
    JComboBox<String> viewDayOrWeekOrMonth = new JComboBox<>(new String[]{"Daily", "Weekly", "Monthly"});
    JToggleButton toggleAssessmentButton = new JToggleButton("Assessments");
    JToggleButton toggleTimetableButton = new JToggleButton("Timetable");
    JToggleButton toggleMiscellaneousButton = new JToggleButton("Miscellaneous");

    CalendarFactory calendar = new StickyNoteCalendarFactory();
    //Start-up:
    //create starting calendar with getMonthData use case (or getWeekData or getDayData)
    //load sticky notes associated with the account
    //the account doesn't have to have its own calendar, because a calendar is constant, e.g. Dec 1st, 2022 is always
    //a Thursday. It can't become a Monday. The account does at least need to save the sticky notes (text files)
    //somewhere to be able to retrieve them every time the app is reopened, e.g. a folder named the account's username.
    //The nextPage and prevPage buttons can use the GoToSeekedDate use case, and
    //LocalDate.minus/plus(1 day, 7 days, or 1 month) to move by 1 day, 1 week, or 1 month depending on which view
    //the calendar is currently set to. Note that the minus and plus methods work with both negative and positive
    //values, so it is possible to only use one of them for both nextPage and prevPage.

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
