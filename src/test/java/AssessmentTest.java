package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class AssessmentTest {
    private Assessment CsFinal = new Assessment("CSC207", "Final Exam");

    @Test
    public void test_getCourseName(){
        Assertions.assertEquals("CSC207", CsFinal.getCourseName());
    }

    @Test
    public void test_getName(){
        Assertions.assertEquals("Final Exam", CsFinal.getName());
    }

    @Test
    public void test_setGetWeight(){
        CsFinal.setWeight(45);
        Assertions.assertEquals(45, CsFinal.getWeight());
    }

    @Test
    public void test_setGetDdl(){
        LocalDate newDate = LocalDate.of(2022, 12, 16);
        LocalTime newDateTime = LocalTime.of(9, 0);
        CsFinal.setDdl(newDate);
        CsFinal.setDdlTime(newDateTime);
        Assertions.assertEquals(newDate, CsFinal.getDdlDate());
        Assertions.assertEquals(newDateTime, CsFinal.getDdlTime());
    }

    @Test
    public void test_markReturnFinished(){
        Assertions.assertEquals(false, CsFinal.getFinished());
        CsFinal.markAsFinished();
        Assertions.assertEquals(true, CsFinal.getFinished());
    }

    @Test
    public void test_setGetRemoveMark(){
        Assertions.assertEquals(false, CsFinal.isHaveMark());
        CsFinal.setMark(86);
        Assertions.assertEquals(true, CsFinal.isHaveMark());
        Assertions.assertEquals(86, CsFinal.getMark());
        CsFinal.removeMark();
        Assertions.assertEquals(false, CsFinal.isHaveMark());
        Assertions.assertEquals(0, CsFinal.getMark());
    }

    @Test
    public void test_isShowDetail(){
        Assertions.assertEquals(false, CsFinal.isShowDetail());
        CsFinal.toShowDetail();
        Assertions.assertEquals(true, CsFinal.isShowDetail());
        CsFinal.toNotShowDetail();
        Assertions.assertEquals(false, CsFinal.isShowDetail());
    }

    @Test
    public void test_isFinished(){
        Assertions.assertEquals(false, CsFinal.getFinished());
        CsFinal.markAsFinished();
        Assertions.assertEquals(true, CsFinal.getFinished());
        CsFinal.markAsNotFinished();
        Assertions.assertEquals(false, CsFinal.getFinished());
    }

    @Test
    public void test_getContribution(){
        Assertions.assertEquals(0, CsFinal.getContribution());
        CsFinal.setMark(86);
        CsFinal.setWeight(45);
        Assertions.assertEquals(86*45*0.01, CsFinal.getContribution());
    }

    @Test
    public void test_toString(){
        CsFinal.setMark(86);
        CsFinal.setWeight(45);
        CsFinal.markAsFinished();
        CsFinal.toShowDetail();
        CsFinal.setDdl(LocalDate.of(2022, 12, 16));
        CsFinal.setDdlTime(LocalTime.of(9, 0));
        Assertions.assertEquals("CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent\n" +
                "Finished!!!  :)\n" +
                "Mark: 86.0  Contribution:38.7", CsFinal.toString());
        CsFinal.removeMark();
        Assertions.assertEquals("CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent" +
                "\nFinished!!!  :)", CsFinal.toString());
        CsFinal.markAsNotFinished();
        Assertions.assertEquals("CSC207 Final Exam  DDL: 2022-12-16 09:00  Worth: 45.0 percent"
                , CsFinal.toString());
        CsFinal.toNotShowDetail();
        Assertions.assertEquals("CSC207 Final Exam", CsFinal.toString());
    }
}
