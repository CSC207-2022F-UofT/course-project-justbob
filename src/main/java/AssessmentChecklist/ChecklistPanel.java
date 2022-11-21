package AssessmentChecklist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ChecklistPanel extends JPanel{
    private JTextField courseName;
    private JTextField name;
    private JButton DDLButton;
    private JButton weightButton;
    private JButton contributionButton;
    private JButton finishedButton;
    private JPanel Checklist;
    private JTextArea AssessmentClList;
    private JButton showDetailsButton;
    private JButton showPastAssessmentClsButton;
    private JButton notShowDetailButton;
    private JButton notShowPastButton;

    public ChecklistPanel(Checklist checklist){
        this.setLayout(null);

        JLabel title = new JLabel("AssessmentCl Checklist");
        title.setBounds(150, 0, 200, 25);
        title.setFont(new Font("Georgia", Font.BOLD, 16));
        this.add(title);

        AssessmentClList = new JTextArea();
        AssessmentClList.setBounds(0, 30, 500, 500);
        AssessmentClList.append(checklist.toString());
        this.add(AssessmentClList);

        JLabel courseNameL = new JLabel("Course Name:");
        courseNameL.setBounds(10, 540, 100, 25);
        courseNameL.setFont(new Font("Georgia", Font.PLAIN, 14));
        this.add(courseNameL);

        this.courseName = new JTextField();
        courseName.setBounds(120, 540, 150, 25);
        this.add(courseName);

        JLabel nameL = new JLabel("Name:");
        nameL.setBounds(10, 570, 100, 25);
        nameL.setFont(new Font("Georgia", Font.PLAIN, 14));
        this.add(nameL);

        this.name = new JTextField();
        name.setBounds(120, 570, 150, 25);
        this.add(name);
        String a = courseName.getText();
        String b = name.getText();

        finishedButton = new JButton("Finished!!!");
        finishedButton.setBounds(320, 570, 100, 25);
        this.add(finishedButton);
        finishedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssessmentCl theAssessmentCl = checklist.findAssessmentCl(a, b);
                theAssessmentCl.markAsFinished();
                List c = checklist.getAllTasks();
                checklist.refresher();
                checklist.addAssessmentCls(c);
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });

        JLabel sortIn = new JLabel("Sort in:");
        sortIn.setBounds(10, 600, 100, 25);
        sortIn.setFont(new Font("Georgia", Font.PLAIN, 14));
        this.add(sortIn);

        DDLButton = new JButton("DDL");
        DDLButton.setBounds(120, 600, 100, 25);
        this.add(DDLButton);
        DDLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.sortInDdl(checklist.getAllTasks());
                checklist.sortInDdl(checklist.getTaskToDo());
                checklist.sortInDdl(checklist.getTaskFinished());
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });
        weightButton = new JButton("Weight");
        weightButton.setBounds(230, 600, 100, 25);
        this.add(weightButton);
        weightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.sortInWeight(checklist.getAllTasks());
                checklist.sortInWeight(checklist.getTaskToDo());
                checklist.sortInWeight(checklist.getTaskFinished());
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });
        contributionButton = new JButton("Contribution");
        contributionButton.setBounds(340, 600, 120, 25);
        this.add(contributionButton);
        contributionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.sortInContribution(checklist.getAllTasks());
                checklist.sortInContribution(checklist.getTaskToDo());
                checklist.sortInContribution(checklist.getTaskFinished());
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });

        JLabel showDetail = new JLabel("Show Details:");
        showDetail.setBounds(10, 630, 200, 25);
        showDetail.setFont(new Font("Georgia", Font.PLAIN, 14));
        this.add(showDetail);

        showDetailsButton = new JButton("Yes");
        showDetailsButton.setBounds(210, 630, 70, 25);
        this.add(showDetailsButton);
        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toShowDetail();
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });

        notShowDetailButton = new JButton("No");
        notShowDetailButton.setBounds(290, 630, 70, 25);
        this.add(notShowDetailButton);
        notShowDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toNotShowDetail();
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });

        JLabel showPast = new JLabel("Show Past AssessmentCls:");
        showPast.setBounds(10, 660, 200, 25);
        showPast.setFont(new Font("Georgia", Font.PLAIN, 14));
        this.add(showPast);

        showPastAssessmentClsButton = new JButton("Yes");
        showPastAssessmentClsButton.setBounds(210, 660, 70, 25);
        this.add(showPastAssessmentClsButton);
        showPastAssessmentClsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toShowPast();
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });

        notShowPastButton = new JButton("No");
        notShowPastButton.setBounds(290, 660, 70, 25);
        this.add(notShowPastButton);
        notShowPastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toNotShowPast();
                AssessmentClList.setText(null);
                AssessmentClList.append(checklist.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame a = new JFrame();
        /*List<AssessmentCl> assessmentClList = new ArrayList();
        AssessmentCl assessmentCl7 = new AssessmentCl("1", "2");
        AssessmentCl assessmentCl1 = new AssessmentCl("CSC207", "Final Exam");
        AssessmentCl assessmentCl2 = new AssessmentCl("CSC207", "Project");
        AssessmentCl assessmentCl3 = new AssessmentCl("CSC236", "Final Exam");
        AssessmentCl assessmentCl4 = new AssessmentCl("CSC236", "Term Test 1");
        AssessmentCl assessmentCl5 = new AssessmentCl("CSC236", "Term Test 2");
        AssessmentCl assessmentCl6 = new AssessmentCl("CSC236", "Term Test 3");
        assessmentCl5.markAsFinished();
        assessmentCl6.markAsFinished();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        assessmentClList.add(assessmentCl5);
        assessmentClList.add(assessmentCl6);
        assessmentClList.add(assessmentCl7);
        assessmentCl1.setDdl(LocalDate.of(2022, 12, 16));
        assessmentCl1.setDdlTime(LocalTime.of(8, 0));
        assessmentCl2.setDdl(LocalDate.of(2022, 12, 16));
        assessmentCl2.setDdlTime(LocalTime.of(9, 0));
        assessmentCl3.setDdl(LocalDate.of(2022, 12, 14));
        assessmentCl3.setDdlTime(LocalTime.of(9, 0));
        assessmentCl4.setDdl(LocalDate.of(2022, 11, 16));
        assessmentCl4.setDdlTime(LocalTime.of(9, 0));
        assessmentCl5.setDdl(LocalDate.of(2022, 12, 20));
        assessmentCl5.setDdlTime(LocalTime.of(9, 0));
        assessmentCl6.setDdl(LocalDate.of(2022, 9, 16));
        assessmentCl6.setDdlTime(LocalTime.of(9, 0));
        assessmentCl1.setWeight(35);
        assessmentCl2.setWeight(20);
        assessmentCl2.setMark(50);
        assessmentCl3.setWeight(50);
        assessmentCl4.setWeight(2);
        assessmentCl5.setWeight(5);
        assessmentCl5.setMark(70);
        assessmentCl6.setWeight(5);
        assessmentCl6.setMark(90);
        Checklist checklist = new Checklist();
        checklist.addAssessmentCls(assessmentClList);

         */
        AssessmentChecklist.Checklist checklist = new Checklist();
        ChecklistPanel b = new ChecklistPanel(checklist);
        a.setSize(500, 800);
        a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        a.add(b);
        a.setVisible(true);
    }
}
