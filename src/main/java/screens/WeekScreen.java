package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class WeekScreen extends JPanel implements ActionListener {
    GridBagConstraints gbc;

    public WeekScreen(DayCell[] sevenDays) {
        gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
