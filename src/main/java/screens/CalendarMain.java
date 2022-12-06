package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Tests the calendar portion of the GUI. Add CalendarPanel to Main GUI for final version.
 * */
public class CalendarMain/* implements ActionListener*/ {
    CalendarPanel calPanel;
    JFrame frame;

    public CalendarMain() throws IOException {
        frame = new JFrame("Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calPanel = new CalendarPanel();
        frame.setContentPane(calPanel);
        frame.pack();
        frame.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        e.getActionCommand();
//    }

    private static void runCalendarMain() throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        CalendarMain cal = new CalendarMain();
    }

    public static void main(String[] args) {
        //Runnable interface allows for threading
        try {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        runCalendarMain();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
