package AssessmentChecklist;

import AssessmentChecklist.AssessmentCl;
import AssessmentChecklist.Checklist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ChecklistTest {
    private Checklist checklist = new Checklist();
    private AssessmentCl assessmentCl1 = new AssessmentCl("CSC207", "Final Exam");
    private AssessmentCl assessmentCl2 = new AssessmentCl("CSC207", "Project");
    private AssessmentCl assessmentCl3 = new AssessmentCl("CSC236", "Final Exam");
    private AssessmentCl assessmentCl4 = new AssessmentCl("CSC236", "Term Test 1");
    private AssessmentCl assessmentCl5 = new AssessmentCl("CSC236", "Term Test 2");
    private AssessmentCl assessmentCl6 = new AssessmentCl("CSC236", "Term Test 3");

    @Test
    public void test_addAssessmentCl(){
        checklist.addAssessmentCl(assessmentCl1);
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getAllTasks().toString());
        Assertions.assertEquals("[]", checklist.getTaskFinished().toString());
        assessmentCl2.markAsFinished();
        checklist.addAssessmentCl(assessmentCl2);
        Assertions.assertEquals("[CSC207 Project]", checklist.getTaskFinished().toString());
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project]", checklist.getAllTasks().toString());
        assessmentCl2.toShowDetail();
        Assertions.assertEquals("[CSC207 Project\n" +
                "Finished!!!  :)]", checklist.getTaskFinished().toString());
    }

    @Test
    public void test_addAssessmentCls(){
        List<AssessmentCl> assessmentClList = new ArrayList();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        checklist.addAssessmentCls(assessmentClList);
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project, CSC236 Final Exam, CSC236 Term Test 1]",
                checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam, CSC207 Project, CSC236 Final Exam, CSC236 Term Test 1]",
                checklist.getAllTasks().toString());
    }

    @Test
    public void test_refresher(){
        checklist.addAssessmentCl(assessmentCl1);
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[CSC207 Final Exam]", checklist.getAllTasks().toString());
        checklist.refresher();
        Assertions.assertEquals("[]", checklist.getTaskToDo().toString());
        Assertions.assertEquals("[]", checklist.getAllTasks().toString());
    }

    @Test
    public void test_toString(){
        List<AssessmentCl> assessmentClList = new ArrayList();
        assessmentCl5.markAsFinished();
        assessmentCl6.markAsFinished();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        assessmentClList.add(assessmentCl5);
        assessmentClList.add(assessmentCl6);
        checklist.addAssessmentCls(assessmentClList);
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
        assessmentCl1.setMark(86);
        assessmentCl1.setWeight(45);
        assessmentCl1.markAsFinished();
        assessmentCl1.toShowDetail();
        assessmentCl1.setDdl(LocalDate.of(2022, 12, 16));
        assessmentCl1.setDdlTime(LocalTime.of(9, 0));
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
        assessmentCl2.setWeight(45);
        assessmentCl2.setDdl(LocalDate.of(2022, 11, 16));
        assessmentCl2.setDdlTime(LocalTime.of(9, 0));
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
    public void test_findAssessmentCl(){
        List<AssessmentCl> assessmentClList = new ArrayList();
        assessmentCl5.markAsFinished();
        assessmentCl6.markAsFinished();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        assessmentClList.add(assessmentCl5);
        assessmentClList.add(assessmentCl6);
        checklist.addAssessmentCls(assessmentClList);
        Assertions.assertEquals("CSC207 Final Exam",
                checklist.findAssessmentCl("CSC207", "Final Exam").toString());
    }

    @Test
    public void test_sortInDdl(){
        List<AssessmentCl> assessmentClList = new ArrayList();
        assessmentCl5.markAsFinished();
        assessmentCl6.markAsFinished();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        assessmentClList.add(assessmentCl5);
        assessmentClList.add(assessmentCl6);
        checklist.addAssessmentCls(assessmentClList);
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
        List<AssessmentCl> assessmentClList = new ArrayList();
        assessmentCl5.markAsFinished();
        assessmentCl6.markAsFinished();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        assessmentClList.add(assessmentCl5);
        assessmentClList.add(assessmentCl6);
        checklist.addAssessmentCls(assessmentClList);
        assessmentCl1.setWeight(35);
        assessmentCl2.setWeight(20);
        assessmentCl3.setWeight(50);
        assessmentCl4.setWeight(2);
        assessmentCl5.setWeight(5);
        assessmentCl6.setWeight(5);
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
        List<AssessmentCl> assessmentClList = new ArrayList();
        assessmentCl5.markAsFinished();
        assessmentCl6.markAsFinished();
        assessmentClList.add(assessmentCl1);
        assessmentClList.add(assessmentCl2);
        assessmentClList.add(assessmentCl3);
        assessmentClList.add(assessmentCl4);
        assessmentClList.add(assessmentCl5);
        assessmentClList.add(assessmentCl6);
        checklist.addAssessmentCls(assessmentClList);
        assessmentCl1.setWeight(35);
        assessmentCl2.setWeight(20);
        assessmentCl2.setMark(50);
        assessmentCl3.setWeight(50);
        assessmentCl4.setWeight(2);
        assessmentCl5.setWeight(5);
        assessmentCl5.setMark(70);
        assessmentCl6.setWeight(5);
        assessmentCl6.setMark(90);
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
