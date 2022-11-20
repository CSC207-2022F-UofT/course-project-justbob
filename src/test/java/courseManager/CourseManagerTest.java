package courseManager;

import entities.course.Course;
import entities.courseEvent.CourseEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.SimpleWeight;
import weightScheme.Weight;


import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseManagerTest {
    private Course csc207 = new Course("CSC207", "Software Design", "Fall 2022", false, 1.0f);

    private CourseEvent csc207Lecture = new CourseEvent("Lecture", DayOfWeek.MONDAY, LocalTime.of(10, 0),
            LocalTime.of(11, 0), "BA1100");

    private Assessment csc207Quizzes = new Assessment("Quizzes",
            new SimpleWeight(new Weight(3, 0.1)));

    private Assessment csc207Midterm = new Assessment("Midterm",
            new SimpleWeight(new Weight(1, 0.3)));

    //@Test
    public void addCourseEvent() {
        csc207.addCourseEvent(csc207Lecture);
        Assertions.assertEquals(csc207Lecture, csc207.getCourseEvents().get(0));
    }

    //@Test
    public void addCourseEventWithSameName() {
        /*replace with these lines:
        AddCourseEvent adder = new AddCourseEvent();
        adder.addCourseEvent(csc207, csc207Lecture); */
        csc207.addCourseEvent(csc207Lecture);
        Assertions.assertThrows(IllegalArgumentException.class, () -> csc207.addCourseEvent(csc207Lecture));
    }

    //@Test
    public void addAssessmentToOutline() {
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertEquals(csc207Quizzes,csc207.getOutline().getAssessment(0));
    }

    //@Test
    public void computeRunningGrade() {
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).commit();
        Assertions.assertEquals(0.8, csc207.getOutline().computeRunningGrade(),0.01);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(2, 0.30);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(2).commit();
        Assertions.assertEquals(0.63, csc207.getOutline().computeRunningGrade(),0.01);

    }

    //@Test
    public void setInvalidMark(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 1.1));
    }

    //@Test
    public void emptyAssessmentInstanceVariables(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertNull(csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).getMark());
        Assertions.assertNull(csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).getDueDate());
        Assertions.assertNull(csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).getDueTime());
    }

    //@Test
    public void noMarks(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertEquals(0.0, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

   // @Test
    public void mixedNullMarks(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        Assertions.assertEquals(0.8, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    //@Test
    public void mixedNullMarksMultipleAssessmentsHypo(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        Assertions.assertEquals(0.86,csc207.getOutline().computeHypotheticalGrade(),0.001);
    }

    //@Test
    public void mixedNullMarksMultipleAssessmentsRunning(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        Assertions.assertEquals(0.825,csc207.getOutline().computeRunningGrade(),0.001);
    }

    //@Test
    public void getPercentageCompleted(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).submit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        Assertions.assertEquals(0.5,csc207.getOutline().getPercentageCompleted(),0.001);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).uncommit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).unsubmit();
        Assertions.assertEquals(0.4,csc207.getOutline().getPercentageCompleted(),0.001);
    }

    //@Test
    public void getNumberOfAssessmentsCompleted(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).submit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        Assertions.assertEquals(3,csc207.getOutline().getNumberOfAssessmentInstancesCompleted(),0.001);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).uncommit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).unsubmit();
        Assertions.assertEquals(2,csc207.getOutline().getNumberOfAssessmentInstancesCompleted(),0.001);
    }

}
