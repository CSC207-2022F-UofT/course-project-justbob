package views;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.viewAccount.ViewAccountRequest;
import ports.usecases.account.viewSemester.ViewSemesterRequest;
import ports.usecases.account.viewSemester.ViewSemesterResponse;
import usecases.account.ViewAccount.ViewAccountController;
import usecases.account.ViewSemester.ViewSemesterController;

import javax.swing.*;
import java.awt.*;

public class ArchiveView {
    public final int WIDTH = 600;
    public final int HEIGHT = 600;

    public ArchiveView(EntityGateway entityGateway, EntityFactory entityFactory, ViewSemesterResponse response, JFrame parentFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Archived Courses");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Courses Table constructor
        String[] courseCodes = response.courseCodes;
        String[] courseTitles = response.courseTitles;
        Double[] courseGrades = response.courseGrades;

        boolean isEmpty = courseCodes.length == 0;
        if (isEmpty) {
            courseCodes = new String[]{"NCA"};
            courseTitles = new String[]{"No Course Archived"};
            courseGrades = new Double[]{0.0};
        }

        String[][] dataColumns = new String[3][courseCodes.length];
        dataColumns[0] = courseCodes;
        dataColumns[1] = courseTitles;
        dataColumns[2] = doubleListToStringList(courseGrades);

        String[][] data = transpose(dataColumns);
        String[] column = {"Course Codes", "Course Titles", "Course Grades"};

        JTable coursesTable = new JTable(data, column);
        coursesTable.setBounds((int) (0.066 * WIDTH), (int) (0.133 * HEIGHT), (int) (WIDTH - (0.133 * WIDTH)), (int) (HEIGHT * 0.533));
        panel.add(coursesTable);

        // back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(coursesTable.getX() + 360, coursesTable.getY() + 360, 160, 50);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            frame.dispose();
            parentFrame.dispose(); // parentFrame.setVisible(true);
            ViewAccountRequest request = new ViewAccountRequest(response.username);
            new ViewAccountController(request, frame, entityGateway, entityFactory, frame);
        });

        frame.setVisible(true);


    }
        private static String[][] transpose (String[][]matrix){
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

        private String[] doubleListToStringList (Double[]doubleList){
            String[] stringList = new String[doubleList.length];
            int index = 0;
            for (Double d : doubleList) {
                stringList[index] = d.toString();
                index += 1;
            }
            return stringList;
        }

    }

