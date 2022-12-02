package screens;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StickyNoteDataAccess {
    private ArrayList<String> stickyNoteText = new ArrayList<>();
    private String line;
    private int count;
    public StickyNoteDataAccess(String filename) throws IOException {
        count = 0;
        BufferedReader in = new BufferedReader(new FileReader(filename));
        line = in.readLine();
        while (line != null) {
            stickyNoteText.add(line);
            line = in.readLine();
        }
        in.close();
    }

    JPanel formatStickyNote() {
        JPanel stickyNotePanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        stickyNotePanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int i = 0; i < stickyNoteText.toArray().length; i++) {
            stickyNotePanel.add(new JLabel(stickyNoteText.get(i)));
            gbc.gridy++;
        }
        JScrollPane scrollPane = new JScrollPane();
        stickyNotePanel.add(scrollPane);
        //add check what type of sticky note, and change background colour
        //pink for assessments, light blue for timetable, and yellow for miscellaneous
        if (stickyNoteText.get(1).equalsIgnoreCase("Assessments")) {
            stickyNotePanel.setBackground(new Color(255, 204, 204));
        }
        else if (stickyNoteText.get(1).equalsIgnoreCase("Timetable")) {
            stickyNotePanel.setBackground(new Color(204, 255, 255));
        }
        else {
            stickyNotePanel.setBackground(new Color(255, 239 ,213));
        }
        return stickyNotePanel;
    }
}
