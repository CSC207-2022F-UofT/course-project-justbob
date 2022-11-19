package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ChecklistTest {
    private Checklist checklist = new Checklist();
    private Assignment assignment1 = new Assignment("CSC207", "Final Exam");
    private Assignment assignment2 = new Assignment("CSC207", "Project");
    private Assignment assignment3 = new Assignment("CSC236", "Final Exam");
    private Assignment assignment4 = new Assignment("CSC236", "Term Test 1");
    private Assignment assignment5 = new Assignment("CSC236", "Term Test 2");
    private Assignment assignment6 = new Assignment("CSC236", "Term Test 3");

    @Test
    public void test_addAssignment(){
        checklist.addAssignment(assignment1);
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getAllTasks().toString());
        Assertions.assertEquals("[]", checklist.getTaskFinished().toString());
        assignment2.markAsFinished();
        checklist.addAssignment(assignment2);
        Assertions.assertEquals("[CSC207 Project]", checklist.getTaskFinished().toString());
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project]", checklist.getAllTasks().toString());
        assignment2.toShowDetail();
        Assertions.assertEquals("[CSC207 Project\n" +
                "Finished!!!  :)]", checklist.getTaskFinished().toString());
    }

    @Test
    public void test_addAssignments(){
        List<Assignment> assignmentList = new ArrayList();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);
        assignmentList.add(assignment3);
        assignmentList.add(assignment4);
        checklist.addAssignments(assignmentList);
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project, CSC236 Final Exam, CSC236 Term Test 1]",
                checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project, CSC236 Final Exam, CSC236 Term Test 1]",
                checklist.getAllTasks().toString());
    }

    @Test
    public void test_refresher(){
        checklist.addAssignment(assignment1);
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getAllTasks().toString());
        checklist.refresher();
        Assertions.assertEquals("[]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[]", checklist.getAllTasks().toString());
    }

    @Test
    public void test_toString(){
        List<Assignment> assignmentList = new ArrayList();
        assignment5.markAsFinished();
        assignment6.markAsFinished();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);
        assignmentList.add(assignment3);
        assignmentList.add(assignment4);
        assignmentList.add(assignment5);
        assignmentList.add(assignment6);
        checklist.addAssignments(assignmentList);
        checklist.toShowDetail();
        checklist.toShowPast();
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "Finished!!!  :)\n" +
                "CSC236 Term Test 3\n" +
                "Finished!!!  :)\n" +
                "CSC207 Final Exam\n" +
                "CSC207 Project\n" +
                "CSC236 Final Exam\n" +
                "CSC236 Term Test 1\n", checklist.toString());
        assignment1.setMark(86);
        assignment1.setWeight(45);
        assignment1.markAsFinished();
        assignment1.toShowDetail();
        assignment1.setDdl(LocalDate.of(2022, 12, 16));
        assignment1.setDdlTime(LocalTime.of(9, 0));
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "Finished!!!  :)\n" +
                "CSC236 Term Test 3\n" +
                "Finished!!!  :)\n" +
                "CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent\n" +
                "Finished!!!  :)  Mark is: 86.0\n" +
                "CSC207 Project\n" +
                "CSC236 Final Exam\n" +
                "CSC236 Term Test 1\n", checklist.toString());
        assignment2.setWeight(45);
        assignment2.setDdl(LocalDate.of(2022, 11, 16));
        assignment2.setDdlTime(LocalTime.of(9, 0));
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "Finished!!!  :)\n" +
                "CSC236 Term Test 3\n" +
                "Finished!!!  :)\n" +
                "CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent\n" +
                "Finished!!!  :)  Mark is: 86.0\n" +
                "CSC207 Project  DDL: 2022-11-16 09:00  Worth: 45.0 percent\n" +
                "CSC236 Final Exam\n" +
                "CSC236 Term Test 1\n", checklist.toString());
    }

    @Test
    public void test_sortInDdl(){
        List<Assignment> assignmentList = new ArrayList();
        assignment5.markAsFinished();
        assignment6.markAsFinished();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);
        assignmentList.add(assignment3);
        assignmentList.add(assignment4);
        assignmentList.add(assignment5);
        assignmentList.add(assignment6);
        checklist.addAssignments(assignmentList);
        assignment1.setDdl(LocalDate.of(2022, 12, 16));
        assignment1.setDdlTime(LocalTime.of(8, 0));
        assignment2.setDdl(LocalDate.of(2022, 12, 16));
        assignment2.setDdlTime(LocalTime.of(9, 0));
        assignment3.setDdl(LocalDate.of(2022, 12, 14));
        assignment3.setDdlTime(LocalTime.of(9, 0));
        assignment4.setDdl(LocalDate.of(2022, 11, 16));
        assignment4.setDdlTime(LocalTime.of(9, 0));
        assignment5.setDdl(LocalDate.of(2022, 12, 20));
        assignment5.setDdlTime(LocalTime.of(9, 0));
        assignment6.setDdl(LocalDate.of(2022, 9, 16));
        assignment6.setDdlTime(LocalTime.of(9, 0));
        checklist.sortInDdl(checklist.getAllTasks());
        checklist.sortInDdl(checklist.getTaskToDo());
        checklist.sortInDdl(checklist.getTaskFinished());
        Assertions.assertEquals("CSC236 Term Test 1\n" +
                "CSC236 Final Exam\n" +
                "CSC207 Final Exam\n" +
                "CSC207 Project\n", checklist.toString());
        checklist.toShowDetail();
        checklist.toShowPast();
        Assertions.assertEquals("CSC236 Term Test 3  DDL: 2022-09-16 09:00\n" +
                "Finished!!!  :)\n" +
                "CSC236 Term Test 2  DDL: 2022-12-20 09:00\n" +
                "Finished!!!  :)\n" +
                "CSC236 Term Test 1  DDL: 2022-11-16 09:00\n" +
                "CSC236 Final Exam  DDL: 2022-12-14 09:00\n" +
                "CSC207 Final Exam  DDL: 2022-12-16 08:00\n" +
                "CSC207 Project  DDL: 2022-12-16 09:00\n", checklist.toString());
    }

    @Test
    public void test_sortInWeight(){
        List<Assignment> assignmentList = new ArrayList();
        assignment5.markAsFinished();
        assignment6.markAsFinished();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);
        assignmentList.add(assignment3);
        assignmentList.add(assignment4);
        assignmentList.add(assignment5);
        assignmentList.add(assignment6);
        checklist.addAssignments(assignmentList);
        assignment1.setWeight(35);
        assignment2.setWeight(20);
        assignment3.setWeight(50);
        assignment4.setWeight(2);
        assignment5.setWeight(5);
        assignment6.setWeight(5);
        checklist.sortInWeight(checklist.getAllTasks());
        checklist.sortInWeight(checklist.getTaskToDo());
        checklist.sortInWeight(checklist.getTaskFinished());
        checklist.toShowPast();
        Assertions.assertEquals("CSC236 Term Test 2\n" +
                "CSC236 Term Test 3\n" +
                "CSC236 Final Exam\n" +
                "CSC207 Final Exam\n" +
                "CSC207 Project\n" +
                "CSC236 Term Test 1\n", checklist.toString());
    }

    @Test
    public void test_sortInContribution(){
        List<Assignment> assignmentList = new ArrayList();
        assignment5.markAsFinished();
        assignment6.markAsFinished();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);
        assignmentList.add(assignment3);
        assignmentList.add(assignment4);
        assignmentList.add(assignment5);
        assignmentList.add(assignment6);
        checklist.addAssignments(assignmentList);
        assignment1.setWeight(35);
        assignment2.setWeight(20);
        assignment2.setMark(50);
        assignment3.setWeight(50);
        assignment4.setWeight(2);
        assignment5.setWeight(5);
        assignment5.setMark(70);
        assignment6.setWeight(5);
        assignment6.setMark(90);
        checklist.sortInContribution(checklist.getAllTasks());
        checklist.sortInContribution(checklist.getTaskToDo());
        checklist.sortInContribution(checklist.getTaskFinished());
        checklist.toShowPast();
        checklist.toShowDetail();
        Assertions.assertEquals("CSC236 Term Test 3  Worth: 5.0 percent\n" +
                "Finished!!!  :)  Mark: 90.0  Contribution:4.5\n" +
                "CSC236 Term Test 2  Worth: 5.0 percent\n" +
                "Finished!!!  :)  Mark: 70.0  Contribution:3.5\n" +
                "CSC207 Project  Worth: 20.0 percent  Mark: 50.0  Contribution:10.0\n" +
                "CSC207 Final Exam  Worth: 35.0 percent\n" +
                "CSC236 Final Exam  Worth: 50.0 percent\n" +
                "CSC236 Term Test 1  Worth: 2.0 percent\n", checklist.toString());
    }
}
