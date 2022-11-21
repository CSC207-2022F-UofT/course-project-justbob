package CalendarSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class roughCalendarDriver implements ActionListener {
    JFrame frame;
    JPanel calendarPanel;
    JLabel monthLabel;
    GridBagConstraints gbc;

    public roughCalendarDriver() {
        frame = new JFrame("CALENDAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Calendar calendar = new Calendar();
        calendarPanel = new JPanel();
        monthLabel = new JLabel(calendar.getToday().getMonth().toString());
        monthLabel.setHorizontalAlignment(JLabel.CENTER);
        monthLabel.setBorder(BorderFactory.createLineBorder(Color.black));

        calendarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        calendarPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        //gbc.insets = new Insets(1, 2, 1, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        calendarPanel.add(monthLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridy = 1;
        for (int row = 1; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                JLabel temp = new JLabel("-_-");
                temp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(1, 2, 1, 2)));
                gbc.gridx = col;
                calendarPanel.add(temp, gbc);
            }
            gbc.gridy = row;
        }

        JToggleButton toggleAssessments = new JCheckBox("Assessments");
        JCheckBox toggleTimetable = new JCheckBox("Timetable");
        JToggleButton toggleMiscellaneous = new JCheckBox("Miscellaneous");

        frame.setContentPane(calendarPanel);
        //frame.setSize(500, 370);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
    }

    private static void runRoughCalendarDriver() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        roughCalendarDriver test = new roughCalendarDriver();
    }

    public static void main(String[] args) {
        try {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    runRoughCalendarDriver();
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
