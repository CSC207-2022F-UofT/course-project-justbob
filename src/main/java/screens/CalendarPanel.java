package screens;

import ports.usecases.calendar.writeToStickyNoteUseCase.WriteToStickyNoteDsGateway;
import ports.usecases.calendar.writeToStickyNoteUseCase.WriteToStickyNoteInteractor;
import ports.usecases.calendar.writeToStickyNoteUseCase.WriteToStickyNoteOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class CalendarPanel extends JPanel implements ActionListener {
    public CalendarPanel() throws IOException {
        JButton goToSeekedDateButton = new JButton("Enter");
        JTextField goToSeekedDateTextfield = new JTextField(10);
        JLabel goToSeekedDateLabel = new JLabel("Go to: ");
        //JButton nextPage = new BasicArrowButton(BasicArrowButton.EAST);
        //JButton prevPage = new BasicArrowButton(BasicArrowButton.WEST);
        JLabel viewDayOrWeekOrMonthLabel = new JLabel("View: ");
        JComboBox<String> viewDayOrWeekOrMonth = new JComboBox<>(new String[]{"Daily", "Weekly", "Monthly"});
        JToggleButton toggleAssessmentButton = new JCheckBox("Assessments");
        JToggleButton toggleTimetableButton = new JCheckBox("Timetable");
        JToggleButton toggleMiscellaneousButton = new JCheckBox("Miscellaneous");

        WriteToStickyNoteOutputBoundary outputBoundary = new WriteToStickyNotePresenter();
        StickyNoteFactory stickyNoteFactory = new CommonStickyNoteFactory();
        WriteToStickyNoteDsGateway stickyNoteGateway = new WriteToStickyNoteDataAccess();
        WriteToStickyNoteInteractor interactor = new WriteToStickyNoteInteractor(stickyNoteGateway, stickyNoteFactory, outputBoundary);
        WriteToStickyNoteController writeToStickyNoteController = new WriteToStickyNoteController(interactor);
        StickyNoteEditorScreen stickyNoteEditorScreen = new StickyNoteEditorScreen(writeToStickyNoteController);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 2, 5);
        CardLayout cardLayout = new CardLayout();

        CalendarFactory calendar = new StickyNoteCalendarFactory();
        //Start-up:
        //create starting calendar with getMonthData use case (or getWeekData or getDayData)
        //load sticky notes associated with the account.
        //The account doesn't have to have its own calendar, because a calendar is constant, e.g. Dec 1st, 2022 is always
        //a Thursday. It can't become a Monday. The account does at least need to save the sticky notes (text files)
        //somewhere to be able to retrieve them every time the app is reopened, e.g. a folder named the account's username.
        //The nextPage and prevPage buttons can use the GoToSeekedDate use case, and
        //LocalDate.minus/plus(1 day, 7 days, or 1 month) to move by 1 day, 1 week, or 1 month depending on which view
        //the calendar is currently set to. Note that the minus and plus methods work with both negative and positive
        //values, so it is possible to only use one of them for both nextPage and prevPage.

        DayCell cell = new DayCell(calendar.create().getSeekedDate());
        DayScreen dayScreen = new DayScreen(cell);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.gridheight = 6;
        this.add(dayScreen, gbc);

        gbc.gridx = 1/*+5*/;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(viewDayOrWeekOrMonthLabel, gbc);

        gbc.gridx = 2/*+5*/;
        this.add(viewDayOrWeekOrMonth, gbc);

        gbc.gridx = 3/*+5*/;
        this.add(goToSeekedDateLabel, gbc);

        gbc.gridx = 4/*+5*/;
        this.add(goToSeekedDateTextfield, gbc);

        gbc.gridx = 5/*+5*/;
        this.add(goToSeekedDateButton, gbc);

        gbc.gridx = 1/*+5*/;
        gbc.gridy = 2;
        this.add(toggleAssessmentButton, gbc);
        gbc.gridy = 3;
        this.add(toggleMiscellaneousButton, gbc);
        gbc.gridy = 4;
        this.add(toggleTimetableButton, gbc);

        gbc.gridy = 5;
        this.add(stickyNoteEditorScreen);
    }
        @Override
        public void actionPerformed (ActionEvent event){
            String eventName = event.getActionCommand();

            if (eventName.equals("Enter")) {

            }
            if (eventName.equals("Daily")) {}
            if (eventName.equals("Weekly")) {}
            if (eventName.equals("Monthly")) {}
        }
}
