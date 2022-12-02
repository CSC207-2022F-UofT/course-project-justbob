package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StickyNoteEditorScreen extends JPanel implements ActionListener {

    JTextField title = new JTextField(20);
    JComboBox<String> type = new JComboBox<>(new String[]{"Assessment", "Timetable", "Miscellaneous"});
    JTextField dates = new JTextField(20);
    JTextField time = new JTextField(20);
    JTextField location = new JTextField(20);
    JTextArea dotJots = new JTextArea();
    WriteToStickyNoteController stickyNoteController;

    public StickyNoteEditorScreen(WriteToStickyNoteController controller) {
        this.stickyNoteController = controller;

        JLabel title = new JLabel("Title: ");
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        //JTextArea dotjots = new JTextArea();
        dotJots.setBounds(10, 30, 200, 200);
        dotJots.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new FlowLayout());
        this.add(title);
        this.add(dotJots);

        JButton saveButton = new JButton("Save");
        this.add(saveButton);
        JButton removeStickyNoteButton = new JButton("Remove");
        this.add(removeStickyNoteButton);
        JToggleButton notify = new JToggleButton("notify");
        this.add(notify);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();

        if (eventName.equals("Save")) {
            try {
                stickyNoteController.create(title.getText(), (String) type.getSelectedItem(), location.getText(), time.getText(), new String[]{"Testing1", "Testing2"}, dates.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
}
