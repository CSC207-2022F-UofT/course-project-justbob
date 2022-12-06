package views;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;

import javax.swing.*;
import java.awt.*;

public class ApplicationView {
    public ApplicationView(EntityGateway entityGateway, EntityFactory entityFactory, ApplicationResponse response) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Just Bob");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 225));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title label constructor
        JLabel label1 = new JLabel(response.semesterTitle);
        label1.setBounds(100, 10, 370, 20);
        panel.add(label1);

        // Courses Table constructor
        String[] courseCodes = response.courseCodes;
        String[] courseTitles = response.courseTitles;
        Double[] courseGrades = response.courseGrades;

        if (courseCodes.length == 0) {
            courseCodes = new String[]{"NCA"};
            courseTitles = new String[]{"No Course Added"};
            courseGrades = new Double[]{0.0};
        }

        String[][] dataColumns = new String[3][courseCodes.length];
        dataColumns[0] = courseCodes;
        dataColumns[1] = courseTitles;
        dataColumns[2] = doubleListToStringList(courseGrades);

        String[][] data = transpose(dataColumns);
        String[] column = {"Course Codes", "Course Titles", "Course Grades"};

        JTable coursesTable = new JTable(data, column);
        coursesTable.setBounds(10, 30, 370, 100);
        panel.add(coursesTable);

        // add course button
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(100, 150, 193, 28);
        panel.add(addCourseButton);

        addCourseButton.addActionListener(e -> new AddCourseView(entityGateway, entityFactory, response.username, frame));

        frame.setVisible(true);

    }

    private static String[][] transpose(String[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        String[][] transposedMatrix = new String[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                transposedMatrix[x][y] = matrix[y][x];
            }
        }

        return transposedMatrix;
    }

    private String[] doubleListToStringList(Double[] doubleList) {
        String[] stringList = new String[doubleList.length];
        int index = 0;
        for (Double d : doubleList) {
            stringList[index] = d.toString();
            index += 1;
        }
        return stringList;
    }

}


