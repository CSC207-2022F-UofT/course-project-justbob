package screens;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DayScreen extends JPanel implements ActionListener {
    DayCell cell;
    JButton nextPage;
    JButton prevPage;
    public DayScreen(DayCell cell) {
        this.cell = cell;
        nextPage = new BasicArrowButton(BasicArrowButton.EAST);
        nextPage.addActionListener(this);
        prevPage = new BasicArrowButton(BasicArrowButton.WEST);
        prevPage.addActionListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(prevPage, gbc);
        JLabel monthAndYear = new JLabel(this.cell.getDate().getMonth().toString() + " " + this.cell.getDate().getYear());
        monthAndYear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(1, 125, 1, 125)));
        gbc.gridx = 1;
        this.add(monthAndYear, gbc);
        gbc.gridx = 2;
        this.add(nextPage, gbc);

        JLabel dayOfWeek = new JLabel(this.cell.getDate().getDayOfWeek().toString());
        dayOfWeek.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(1, 175, 1, 175)));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        this.add(dayOfWeek, gbc);

        gbc.gridy = 2;
        this.add(this.cell);
    }

    void setCell(DayCell cell) {
        this.cell = cell;
    }

    DayCell getCell() {
        return this.cell;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextPage) {
            DayCell cell2;
            try {
                cell2 = new DayCell(cell.getDate().plusDays(1));
                this.cell = cell2;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //DayScreen dayScreen = new DayScreen(cell2);
        }
        if (e.getSource() == prevPage) {
            DayCell cell2;
            try {
                cell2 = new DayCell(cell.getDate().minusDays(1));
                this.cell = cell2;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //this.dayScreen = new DayScreen(cell2);
        }
    }
}
