package views;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.course.viewCourse.ViewCourseRequest;
import ports.usecases.course.viewCourse.ViewCourseResponse;
import usecases.course.ViewCourse.ViewCourseUseCase;

import javax.swing.*;
import java.awt.*;

public class CourseView {

    public final int width = 500;

    public final int height = 400;

    public CourseView(EntityGateway entityGateway, EntityFactory entityFactory, String username, String courseCode) {

        ViewCourseRequest request = new ViewCourseRequest(username, courseCode);
        ViewCourseResponse response = new ViewCourseUseCase(entityGateway).execute(request);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Just Bob");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title label constructor
        JLabel label1 = new JLabel(response.courseCode + ": " + response.courseTitle + " - " + response.credit + " credits");
        label1.setBounds(100, 10, 370, 20);
        panel.add(label1);

        // TODO course event table

        // Assessments Table constructor
        String[] assessmentTitles = response.assessmentTitles;
        Integer[] assessmentNumberOfInstances = response.assessmentNumberOfInstances;
        Double[] assessmentWeights = response.assessmentWeights;

        boolean isEmpty = assessmentTitles.length == 0;
        if (isEmpty) {
            assessmentTitles = new String[]{"No Assessment"};
            assessmentNumberOfInstances = new Integer[]{0};
            assessmentWeights = new Double[]{0.0};
        }

        String[][] dataColumns = new String[3][assessmentTitles.length];
        dataColumns[0] = assessmentTitles;
        dataColumns[1] = integerListToStringList(assessmentNumberOfInstances);
        dataColumns[2] = doubleListToStringList(assessmentWeights);

        String[][] data = transpose(dataColumns);
        String[] column = {"Assessment Titles", "Assessment Number of Instances", "Assessment Weight"};

        JTable assessmentsTable = new JTable(data, column);
        assessmentsTable.setBounds(10, 30, width - 20, height - 300);
        panel.add(assessmentsTable);


        // grade labels
        JLabel label2 = new JLabel("Running Grade: " + response.runningGrade);
        label2.setBounds(50, 200, 370, 20);
        panel.add(label2);
        JLabel label3 = new JLabel("Hypothetical Grade: " + response.hypotheticalGrade);
        label3.setBounds(50, 220, 370, 20);
        panel.add(label3);

        // add assessment button
        JButton addSimpleAssessmentButton = new JButton("Add Assessment");
        addSimpleAssessmentButton.setBounds(300,200 , 193, 28);
        panel.add(addSimpleAssessmentButton);

        addSimpleAssessmentButton.addActionListener(e -> new AddSimpleAssessmentView(entityGateway, entityFactory, response.username, response.courseCode, frame));


        // back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(300, 220, 193, 28);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            frame.dispose();
            /*TODO persistency of previous view*/
            /*new ApplicationView(entityGateway, entityFactory, response.username);*/
        });

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

    private String[] integerListToStringList(Integer[] integerList) {
        String[] stringList = new String[integerList.length];
        int index = 0;
        for (Integer i : integerList) {
            stringList[index] = i.toString();
            index += 1;
        }
        return stringList;
    }

}
