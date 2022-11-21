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
    private JTextArea AssessmentList;
    private JButton showDetailsButton;
    private JButton showPastAssessmentsButton;
    private JButton notShowDetailButton;
    private JButton notShowPastButton;

    public ChecklistPanel(Checklist checklist){
        this.setLayout(null);

        JLabel title = new JLabel("Assessment Checklist");
        title.setBounds(150, 0, 200, 25);
        title.setFont(new Font("Georgia", Font.BOLD, 16));
        this.add(title);

        AssessmentList = new JTextArea();
        AssessmentList.setBounds(0, 30, 500, 500);
        AssessmentList.append(checklist.toString());
        this.add(AssessmentList);

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
                Assessment theAssessment = checklist.findAssessment(a, b);
                theAssessment.markAsFinished();
                List c = checklist.getAllTasks();
                checklist.refresher();
                checklist.addAssessments(c);
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
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
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
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
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
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
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
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
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
            }
        });

        notShowDetailButton = new JButton("No");
        notShowDetailButton.setBounds(290, 630, 70, 25);
        this.add(notShowDetailButton);
        notShowDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toNotShowDetail();
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
            }
        });

        JLabel showPast = new JLabel("Show Past Assessments:");
        showPast.setBounds(10, 660, 200, 25);
        showPast.setFont(new Font("Georgia", Font.PLAIN, 14));
        this.add(showPast);

        showPastAssessmentsButton = new JButton("Yes");
        showPastAssessmentsButton.setBounds(210, 660, 70, 25);
        this.add(showPastAssessmentsButton);
        showPastAssessmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toShowPast();
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
            }
        });

        notShowPastButton = new JButton("No");
        notShowPastButton.setBounds(290, 660, 70, 25);
        this.add(notShowPastButton);
        notShowPastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklist.toNotShowPast();
                AssessmentList.setText(null);
                AssessmentList.append(checklist.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame a = new JFrame();
        List<Assessment> assessmentList = new ArrayList();
        Assessment assessment7 = new Assessment("1", "2");
        Assessment assessment1 = new Assessment("CSC207", "Final Exam");
        Assessment assessment2 = new Assessment("CSC207", "Project");
        Assessment assessment3 = new Assessment("CSC236", "Final Exam");
        Assessment assessment4 = new Assessment("CSC236", "Term Test 1");
        Assessment assessment5 = new Assessment("CSC236", "Term Test 2");
        Assessment assessment6 = new Assessment("CSC236", "Term Test 3");
        assessment5.markAsFinished();
        assessment6.markAsFinished();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        assessmentList.add(assessment5);
        assessmentList.add(assessment6);
        assessmentList.add(assessment7);
        assessment1.setDdl(LocalDate.of(2022, 12, 16));
        assessment1.setDdlTime(LocalTime.of(8, 0));
        assessment2.setDdl(LocalDate.of(2022, 12, 16));
        assessment2.setDdlTime(LocalTime.of(9, 0));
        assessment3.setDdl(LocalDate.of(2022, 12, 14));
        assessment3.setDdlTime(LocalTime.of(9, 0));
        assessment4.setDdl(LocalDate.of(2022, 11, 16));
        assessment4.setDdlTime(LocalTime.of(9, 0));
        assessment5.setDdl(LocalDate.of(2022, 12, 20));
        assessment5.setDdlTime(LocalTime.of(9, 0));
        assessment6.setDdl(LocalDate.of(2022, 9, 16));
        assessment6.setDdlTime(LocalTime.of(9, 0));
        assessment1.setWeight(35);
        assessment2.setWeight(20);
        assessment2.setMark(50);
        assessment3.setWeight(50);
        assessment4.setWeight(2);
        assessment5.setWeight(5);
        assessment5.setMark(70);
        assessment6.setWeight(5);
        assessment6.setMark(90);
        Checklist checklist = new Checklist();
        checklist.addAssessments(assessmentList);
        ChecklistPanel b = new ChecklistPanel(checklist);
        a.setSize(500, 800);
        a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        a.add(b);
        a.setVisible(true);
    }
}
