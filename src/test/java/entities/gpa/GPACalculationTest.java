package entities.gpa;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GPACalculationTest {

    @Test
    public void percentToGPASingle(){
        var percentGPA = new GPACalculation();
        assertEquals (4.0, GPACalculation.percentToGPA(86.0));
    }
    @Test
    public void percentToGPASingle2(){
        var percentGPA2 = new GPACalculation();
        assertEquals(3.0, GPACalculation.percentToGPA(75));
    }
    @Test
    public void percentListToGPAList(){
        var percentList = new GPACalculation();
        assertEquals(List.of(4.0, 4.0, 3.0, 3.7),GPACalculation.computeGPAList(List.of(90.0, 85.0, 73.0, 84.9)));
    }
    @Test
    public void computeAverage(){
        var coursemark = new GPACalculation();
        assertEquals(83.23, GPACalculation.computeAverage(List.of(90.0, 85.0, 73.0, 84.9)));
    }
    @Test
    public void percentToLetterGrade(){
        var coursemark = new GPACalculation();
        assertEquals("A+", GPACalculation.percentToGrade(95.0));
    }
    @Test
    public void percentListToGradeList(){
        var coursemark = new GPACalculation();
        assertEquals(List.of("A+", "A", "B", "A-"), GPACalculation.computeGrade(List.of(90.0, 85.0, 73.0, 84.9)));
    }
    @Test
    public void computeOverallGPA(){
        var coursemark = new GPACalculation();
        assertEquals(3.57, GPACalculation.overallGPA(List.of(90.0, 75.0, 73.0, 81.0), List.of(1.0, 0.5, 0.5, 1.0)));
    }


}