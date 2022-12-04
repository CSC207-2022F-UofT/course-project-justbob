package views;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.loginAccount.LoginAccountResponse;

import javax.swing.*;
import java.awt.*;

public class ApplicationView {
    public ApplicationView(EntityGateway entityGateway, EntityFactory entityFactory, LoginAccountResponse response) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Just Bob");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 225));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String title = response.semesterTitle;
        String[] courseCodes = response.courseCodes;

        // Title label constructor
        JLabel label1 = new JLabel(title);
        label1.setBounds(100, 8, 70, 20);
        panel.add(label1);

        // Courses Table constructor
        String[][] data = {};
        String[] column = {"Course Codes"};
        JTable coursesTable = new JTable(data, column);
        coursesTable.setBounds(100, 27, 193, 100);
        panel.add(coursesTable);

        // add course button
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(100, 150, 193, 28);
        panel.add(addCourseButton);

        addCourseButton.addActionListener(e -> {
            // TODO: create addCourseView
        });

        frame.setVisible(true);

    }
}


