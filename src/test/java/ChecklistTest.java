package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ChecklistTest {
    private Checklist checklist = new Checklist();
    private Assessment assessment1 = new Assessment("CSC207", "Final Exam");
    private Assessment assessment2 = new Assessment("CSC207", "Project");
    private Assessment assessment3 = new Assessment("CSC236", "Final Exam");
    private Assessment assessment4 = new Assessment("CSC236", "Term Test 1");
    private Assessment assessment5 = new Assessment("CSC236", "Term Test 2");
    private Assessment assessment6 = new Assessment("CSC236", "Term Test 3");

    @Test
    public void test_addAssessment(){
        checklist.addAssessment(assessment1);
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getAllTasks().toString());
        Assertions.assertEquals("[]", checklist.getTaskFinished().toString());
        assessment2.markAsFinished();
        checklist.addAssessment(assessment2);
        Assertions.assertEquals("[CSC207 Project]", checklist.getTaskFinished().toString());
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project]", checklist.getAllTasks().toString());
        assessment2.toShowDetail();
        Assertions.assertEquals("[CSC207 Project\n" +
                "Finished!!!  :)]", checklist.getTaskFinished().toString());
    }

    @Test
    public void test_addAssessments(){
        List<Assessment> assessmentList = new ArrayList();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        checklist.addAssessments(assessmentList);
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project, CSC236 Final Exam, CSC236 Term Test 1]",
                checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project, CSC236 Final Exam, CSC236 Term Test 1]",
                checklist.getAllTasks().toString());
    }

    @Test
    public void test_refresher(){
        checklist.addAssessment(assessment1);
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getAllTasks().toString());
        checklist.refresher();
        Assertions.assertEquals("[]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[]", checklist.getAllTasks().toString());
    }

    @Test
    public void test_toString(){
        List<Assessment> assessmentList = new ArrayList();
        assessment5.markAsFinished();
        assessment6.markAsFinished();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        assessmentList.add(assessment5);
        assessmentList.add(assessment6);
        checklist.addAssessments(assessmentList);
        checklist.toShowDetail();
        checklist.toShowPast();
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC236 Term Test 3\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC207 Final Exam\n" +
                "\n" +
                "CSC207 Project\n" +
                "\n" +
                "CSC236 Final Exam\n" +
                "\n" +
                "CSC236 Term Test 1\n" +
                "\n", checklist.toString());
        assessment1.setMark(86);
        assessment1.setWeight(45);
        assessment1.markAsFinished();
        assessment1.toShowDetail();
        assessment1.setDdl(LocalDate.of(2022, 12, 16));
        assessment1.setDdlTime(LocalTime.of(9, 0));
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC236 Term Test 3\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent\n" +
                "Finished!!!  :)\n" +
                "Mark: 86.0  Contribution:38.7\n" +
                "\n" +
                "CSC207 Project\n" +
                "\n" +
                "CSC236 Final Exam\n" +
                "\n" +
                "CSC236 Term Test 1\n" +
                "\n", checklist.toString());
        assessment2.setWeight(45);
        assessment2.setDdl(LocalDate.of(2022, 11, 16));
        assessment2.setDdlTime(LocalTime.of(9, 0));
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC236 Term Test 3\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent\n" +
                "Finished!!!  :)\n" +
                "Mark: 86.0  Contribution:38.7\n" +
                "\n" +
                "CSC207 Project  DDL: 2022-11-16 09:00  Worth: 45.0 percent\n" +
                "\n" +
                "CSC236 Final Exam\n" +
                "\n" +
                "CSC236 Term Test 1\n" +
                "\n", checklist.toString());
        checklist.toNotShowDetail();
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "\n" +
                "CSC236 Term Test 3\n" +
                "\n" +
                "CSC207 Final Exam\n" +
                "\n" +
                "CSC207 Project\n" +
                "\n" +
                "CSC236 Final Exam\n" +
                "\n" +
                "CSC236 Term Test 1\n" +
                "\n", checklist.toString());
    }

    @Test
    public void test_findAssessment(){
        List<Assessment> assessmentList = new ArrayList();
        assessment5.markAsFinished();
        assessment6.markAsFinished();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        assessmentList.add(assessment5);
        assessmentList.add(assessment6);
        checklist.addAssessments(assessmentList);
        Assertions.assertEquals("CSC207 Final Exam",
                checklist.findAssessment("CSC207", "Final Exam").toString());
    }

    @Test
    public void test_sortInDdl(){
        List<Assessment> assessmentList = new ArrayList();
        assessment5.markAsFinished();
        assessment6.markAsFinished();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        assessmentList.add(assessment5);
        assessmentList.add(assessment6);
        checklist.addAssessments(assessmentList);
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
        checklist.sortInDdl(checklist.getAllTasks());
        checklist.sortInDdl(checklist.getTaskToDo());
        checklist.sortInDdl(checklist.getTaskFinished());
        Assertions.assertEquals("CSC236 Term Test 1\n" +
                "\n" +
                "CSC236 Final Exam\n" +
                "\n" +
                "CSC207 Final Exam\n" +
                "\n" +
                "CSC207 Project\n" +
                "\n", checklist.toString());
        checklist.toShowDetail();
        checklist.toShowPast();
        Assertions.assertEquals("CSC236 Term Test 3  DDL: 2022-09-16 09:00\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC236 Term Test 2  DDL: 2022-12-20 09:00\n" +
                "Finished!!!  :)\n" +
                "\n" +
                "CSC236 Term Test 1  DDL: 2022-11-16 09:00\n" +
                "\n" +
                "CSC236 Final Exam  DDL: 2022-12-14 09:00\n" +
                "\n" +
                "CSC207 Final Exam  DDL: 2022-12-16 08:00\n" +
                "\n" +
                "CSC207 Project  DDL: 2022-12-16 09:00\n" +
                "\n", checklist.toString());
    }

    @Test
    public void test_sortInWeight(){
        List<Assessment> assessmentList = new ArrayList();
        assessment5.markAsFinished();
        assessment6.markAsFinished();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        assessmentList.add(assessment5);
        assessmentList.add(assessment6);
        checklist.addAssessments(assessmentList);
        assessment1.setWeight(35);
        assessment2.setWeight(20);
        assessment3.setWeight(50);
        assessment4.setWeight(2);
        assessment5.setWeight(5);
        assessment6.setWeight(5);
        checklist.sortInWeight(checklist.getAllTasks());
        checklist.sortInWeight(checklist.getTaskToDo());
        checklist.sortInWeight(checklist.getTaskFinished());
        checklist.toShowPast();
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "\n" +
                "CSC236 Term Test 3\n" +
                "\n" +
                "CSC236 Final Exam\n" +
                "\n" +
                "CSC207 Final Exam\n" +
                "\n" +
                "CSC207 Project\n" +
                "\n" +
                "CSC236 Term Test 1\n" +
                "\n", checklist.toString());
    }

    @Test
    public void test_sortInContribution(){
        List<Assessment> assessmentList = new ArrayList();
        assessment5.markAsFinished();
        assessment6.markAsFinished();
        assessmentList.add(assessment1);
        assessmentList.add(assessment2);
        assessmentList.add(assessment3);
        assessmentList.add(assessment4);
        assessmentList.add(assessment5);
        assessmentList.add(assessment6);
        checklist.addAssessments(assessmentList);
        assessment1.setWeight(35);
        assessment2.setWeight(20);
        assessment2.setMark(50);
        assessment3.setWeight(50);
        assessment4.setWeight(2);
        assessment5.setWeight(5);
        assessment5.setMark(70);
        assessment6.setWeight(5);
        assessment6.setMark(90);
        checklist.sortInContribution(checklist.getAllTasks());
        checklist.sortInContribution(checklist.getTaskToDo());
        checklist.sortInContribution(checklist.getTaskFinished());
        checklist.toShowPast();
        checklist.toShowDetail();
        Assertions.assertEquals("CSC236 Term Test 3  Worth: 5.0 percent\n" +
                "Finished!!!  :)\n" +
                "Mark: 90.0  Contribution:4.5\n" +
                "\n" +
                "CSC236 Term Test 2  Worth: 5.0 percent\n" +
                "Finished!!!  :)\n" +
                "Mark: 70.0  Contribution:3.5\n" +
                "\n" +
                "CSC207 Project  Worth: 20.0 percent\n" +
                "Mark: 50.0  Contribution:10.0\n" +
                "\n" +
                "CSC207 Final Exam  Worth: 35.0 percent\n" +
                "\n" +
                "CSC236 Final Exam  Worth: 50.0 percent\n" +
                "\n" +
                "CSC236 Term Test 1  Worth: 2.0 percent\n" +
                "\n", checklist.toString());
    }
}
