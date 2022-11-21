package courseManager;

import entities.assessment.Assessment;
import entities.course.Course;
import entities.courseEvent.CourseEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.OrderedWeight;
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

    private Weight[] homeworkWeights = {
            new Weight(1, 0.0),
            new Weight(2, 0.1),
            new Weight(1, 0.2)
    };

    private Assessment csc207Homework = new Assessment("Homework",
            new OrderedWeight(homeworkWeights));
    @Test
    public void addCourseEvent() {
        csc207.addCourseEvent(csc207Lecture);
        Assertions.assertEquals(csc207Lecture, csc207.getCourseEvents().get(0));
    }

    @Test
    public void addCourseEventWithSameName() {
        csc207.addCourseEvent(csc207Lecture);
        Assertions.assertThrows(IllegalArgumentException.class, () -> csc207.addCourseEvent(csc207Lecture));
    }

    @Test
    public void addAssessmentToOutline() {
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertEquals(csc207Quizzes,csc207.getOutline().getAssessment(0));
    }

    @Test
    public void SimpleWeightComputeRunningGrade() {
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

    @Test
    public void setInvalidMark(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 1.1));
    }

    @Test
    public void emptyAssessmentInstanceVariables(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertNull(csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).getMark());
        Assertions.assertNull(csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).getDueDate());
        Assertions.assertNull(csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).getDueTime());
    }

    @Test
    public void noMarks(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertEquals(0.0, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    @Test
    public void simpleWeightMixedNullMarks(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        Assertions.assertEquals(0.8, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    @Test
    public void simpleWeightMixedNullMarksMultipleAssessmentsHypo(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        Assertions.assertEquals(0.86,csc207.getOutline().computeHypotheticalGrade(),0.001);
    }

    @Test
    public void simpleWeightMixedNullMarksMultipleAssessmentsRunning(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        Assertions.assertEquals(0.825,csc207.getOutline().computeRunningGrade(),0.001);
    }

    @Test
    public void orderedWeightComputeRunningGrade(){
        csc207.getOutline().addAssessment(csc207Homework);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.70);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(2, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(3, 0.30);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(2).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(3).commit();
        Assertions.assertEquals(0.775, csc207.getOutline().computeRunningGrade(),0.01);
    }

    @Test
    public void mixedWeightMixedNullMarksMultipleAssessmentsHypo(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(0, 0.80);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(1, 0.90);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(2, 0.95);
        Assertions.assertEquals(0.844, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    @Test
    public void mixedWeightMixedNullMarksMultipleAssessmentsRunning(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(0, 0.80);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(1, 0.90);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(2, 0.95);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).commit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(2).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(2).getInstanceList().getInstanceData(2).commit();
        Assertions.assertEquals(0.8375, csc207.getOutline().computeRunningGrade(),0.01);
    }



    @Test
    public void getPercentageCompletedSimpleWeightOnly(){
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

    @Test
    public void getPercentageCompletedOrderedWeightOnly(){
        csc207.getOutline().addAssessment(csc207Homework);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.70);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(2, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(3, 0.30);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(2).submit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(3).commit();
        Assertions.assertEquals(0.4,csc207.getOutline().getPercentageCompleted(),0.001);
    }

    @Test
    public void getPercentageCompletedMixedWeight(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(0, 0.70);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(1, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).submit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(2).getInstanceList().getInstanceData(0).submit();
        csc207.getOutline().getAssessment(2).getInstanceList().getInstanceData(1).commit();
        Assertions.assertEquals(0.8,csc207.getOutline().getPercentageCompleted(),0.001);
    }

    @Test
    public void getNumberOfAssessmentsCompleted(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(0, 0.60);
        csc207.getOutline().getAssessment(0).getInstanceList().editInstanceMark(1, 0.70);
        csc207.getOutline().getAssessment(1).getInstanceList().editInstanceMark(0, 0.90);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(0, 0.70);
        csc207.getOutline().getAssessment(2).getInstanceList().editInstanceMark(1, 0.90);
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(0).getInstanceList().getInstanceData(1).submit();
        csc207.getOutline().getAssessment(1).getInstanceList().getInstanceData(0).commit();
        csc207.getOutline().getAssessment(2).getInstanceList().getInstanceData(0).submit();
        csc207.getOutline().getAssessment(2).getInstanceList().getInstanceData(1).commit();
        Assertions.assertEquals(5,csc207.getOutline().getNumberOfAssessmentInstancesCompleted());
    }

}
