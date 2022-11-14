package courseManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import weightScheme.SimpleWeight;
import weightScheme.Weight;
import weightScheme.WeightScheme;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

public class CourseManagerTest {
    private Course csc207 = new Course("CSC207", "Software Design", "Fall 2022", false, 1.0f);

    private CourseEvent csc207Lecture = new CourseEvent("Lecture", DayOfWeek.MONDAY, LocalTime.of(10, 0),
            LocalTime.of(11, 0), "BA1100");

    private Assessment csc207Quizzes = new Assessment("Quizzes",
            new SimpleWeight(new Weight(3, 0.1)));

    @Test
    public void addCourseEvent() {
        csc207.addCourseEvent(csc207Lecture);
        Assertions.assertEquals(csc207.getCourseEvents().get(0), csc207Lecture);
    }

    @Test
    public void addCourseEventWithSameName() {
        csc207.addCourseEvent(csc207Lecture);
        Assertions.assertThrows(IllegalArgumentException.class, () -> csc207.addCourseEvent(csc207Lecture));
    }

    @Test
    public void matchCourseWithOutline() {
        Outline csc207Outline = new Outline();
        csc207.setOutline(csc207Outline);
        Assertions.assertEquals(csc207.getOutline(), csc207Outline);
    }

    @Test
    public void addAssessmentToOutline() {
        Outline csc207Outline = new Outline();
        csc207.setOutline(csc207Outline);
        csc207Outline.addAssessment(csc207Quizzes);
        Assertions.assertEquals(csc207Outline.getAssessmentData(0), csc207Quizzes);
    }

    @Test
    public void computeRunningGrade() {
        Outline csc207Outline = new Outline();
        csc207.setOutline(csc207Outline);
        csc207Outline.addAssessment(csc207Quizzes);
        csc207Outline.getAssessmentData(0).getInstanceList().editInstance(0, 0.90);
        csc207Outline.getAssessmentData(0).getInstanceList().editInstance(1, 0.70);
        csc207Outline.getAssessmentData(0).getInstanceList().getInstanceData(0).commit();
        csc207Outline.getAssessmentData(0).getInstanceList().getInstanceData(1).commit();
        Assertions.assertEquals(csc207Outline.getRunningGrade(), 0.8,0.001);

    }
}
