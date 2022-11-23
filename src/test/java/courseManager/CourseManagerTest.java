package courseManager;

import entities.assessment.Assessment;
import entities.assessment.assessmentInstance.AssessmentInstance;
import entities.course.Course;
import entities.course.courseEvent.CourseEvent;
import entities.assessment.instanceList.InstanceList;
import inMemoryDB.entities.CourseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.OrderedWeight;
import weightScheme.SimpleWeight;
import weightScheme.Weight;


import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseManagerTest {
    private class CourseFactoryImpl implements Course.CourseFactory {
        @Override
        public Course createCourse() {
            return null;
        }
    }


    private Course csc207 = new CourseImpl("CSC207", "Software Design", 1.0f);

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
    public void addAssessmentToOutline() {
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertEquals(csc207Quizzes,csc207.getOutline().getAssessment(0));
    }

    @Test
    public void SimpleWeightComputeRunningGrade() {
        csc207.getOutline().addAssessment(csc207Quizzes);
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        instanceList.editInstanceMark(0, 0.90);
        instanceList.getInstanceData(0).commit();

        instanceList.editInstanceMark(1, 0.70);
        instanceList.getInstanceData(1).commit();

        Assertions.assertEquals(0.8, csc207.getOutline().computeRunningGrade(),0.01);

        instanceList.editInstanceMark(2, 0.30);
        instanceList.getInstanceData(2).commit();

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
        AssessmentInstance instance = csc207Quizzes.getInstanceList().getInstanceData(0);
        Assertions.assertNull(instance.getMark());
        Assertions.assertNull(instance.getDueDate());
        Assertions.assertNull(instance.getDueTime());
    }

    @Test
    public void noMarks(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        Assertions.assertEquals(0.0, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    @Test
    public void simpleWeightMixedNullMarks(){
        csc207.getOutline().addAssessment(csc207Quizzes);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.90);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);

        Assertions.assertEquals(0.8, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    @Test
    public void simpleWeightMixedNullMarksMultipleAssessmentsHypo(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.90);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);
        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);

        Assertions.assertEquals(0.86, csc207.getOutline().computeHypotheticalGrade(),0.001);
    }

    @Test
    public void simpleWeightMixedNullMarksMultipleAssessmentsRunning(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.60);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);
        csc207Quizzes.getInstanceList().getInstanceData(0).commit();

        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);
        csc207Midterm.getInstanceList().getInstanceData(0).commit();

        Assertions.assertEquals(0.825,csc207.getOutline().computeRunningGrade(),0.001);
    }

    @Test
    public void orderedWeightComputeRunningGrade(){
        csc207.getOutline().addAssessment(csc207Homework);
        InstanceList instanceList = csc207Homework.getInstanceList();

        instanceList.editInstanceMark(0, 0.70);
        instanceList.getInstanceData(0).commit();

        instanceList.editInstanceMark(1, 0.90);
        instanceList.getInstanceData(1).commit();

        instanceList.editInstanceMark(2, 0.60);
        instanceList.getInstanceData(2).commit();

        instanceList.editInstanceMark(3, 0.30);
        instanceList.getInstanceData(3).commit();

        Assertions.assertEquals(0.775, csc207.getOutline().computeRunningGrade(),0.01);
    }

    @Test
    public void mixedWeightMixedNullMarksMultipleAssessmentsHypo(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.60);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);

        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);

        csc207Homework.getInstanceList().editInstanceMark(0, 0.80);
        csc207Homework.getInstanceList().editInstanceMark(1, 0.90);
        csc207Homework.getInstanceList().editInstanceMark(2, 0.95);

        Assertions.assertEquals(0.844, csc207.getOutline().computeHypotheticalGrade(),0.01);
    }

    @Test
    public void mixedWeightMixedNullMarksMultipleAssessmentsRunning(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.60);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);
        csc207Quizzes.getInstanceList().getInstanceData(0).commit();
        csc207Quizzes.getInstanceList().getInstanceData(1).commit();

        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);
        csc207Midterm.getInstanceList().getInstanceData(0).commit();

        csc207Homework.getInstanceList().editInstanceMark(0, 0.80);
        csc207Homework.getInstanceList().editInstanceMark(1, 0.90);
        csc207Homework.getInstanceList().editInstanceMark(2, 0.95);
        csc207Homework.getInstanceList().getInstanceData(0).commit();
        csc207Homework.getInstanceList().getInstanceData(2).commit();

        Assertions.assertEquals(0.8375, csc207.getOutline().computeRunningGrade(),0.01);
    }



    @Test
    public void getPercentageCompletedSimpleWeightOnly(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.60);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);
        csc207Quizzes.getInstanceList().getInstanceData(0).commit();
        csc207Quizzes.getInstanceList().getInstanceData(1).submit();

        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);
        csc207Midterm.getInstanceList().getInstanceData(0).commit();

        Assertions.assertEquals(0.5,csc207.getOutline().getPercentageCompleted(),0.001);

        csc207Quizzes.getInstanceList().getInstanceData(0).uncommit();
        csc207Quizzes.getInstanceList().getInstanceData(0).unsubmit();

        Assertions.assertEquals(0.4,csc207.getOutline().getPercentageCompleted(),0.001);
    }

    @Test
    public void getPercentageCompletedOrderedWeightOnly(){
        csc207.getOutline().addAssessment(csc207Homework);
        InstanceList instanceList = csc207Homework.getInstanceList();

        instanceList.editInstanceMark(0, 0.70);
        instanceList.getInstanceData(0).commit();

        instanceList.editInstanceMark(1, 0.90);
        instanceList.getInstanceData(1).commit();

        instanceList.editInstanceMark(2, 0.60);
        instanceList.getInstanceData(2).submit();

        instanceList.editInstanceMark(3, 0.30);
        instanceList.getInstanceData(3).commit();

        Assertions.assertEquals(0.4,csc207.getOutline().getPercentageCompleted(),0.001);
    }

    @Test
    public void getPercentageCompletedMixedWeight(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.60);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);
        csc207Quizzes.getInstanceList().getInstanceData(0).commit();
        csc207Quizzes.getInstanceList().getInstanceData(1).submit();

        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);
        csc207Midterm.getInstanceList().getInstanceData(0).commit();

        csc207Homework.getInstanceList().editInstanceMark(0, 0.70);
        csc207Homework.getInstanceList().editInstanceMark(1, 0.90);
        csc207Homework.getInstanceList().getInstanceData(0).submit();
        csc207Homework.getInstanceList().getInstanceData(1).commit();

        Assertions.assertEquals(0.8,csc207.getOutline().getPercentageCompleted(),0.001);
    }

    @Test
    public void getNumberOfAssessmentsCompleted(){
        csc207.getOutline().addAssessment(csc207Quizzes);
        csc207.getOutline().addAssessment(csc207Midterm);
        csc207.getOutline().addAssessment(csc207Homework);

        csc207Quizzes.getInstanceList().editInstanceMark(0, 0.60);
        csc207Quizzes.getInstanceList().editInstanceMark(1, 0.70);
        csc207Quizzes.getInstanceList().getInstanceData(0).commit();
        csc207Quizzes.getInstanceList().getInstanceData(1).submit();

        csc207Midterm.getInstanceList().editInstanceMark(0, 0.90);
        csc207Midterm.getInstanceList().getInstanceData(0).commit();

        csc207Homework.getInstanceList().editInstanceMark(0, 0.70);
        csc207Homework.getInstanceList().editInstanceMark(1, 0.90);
        csc207Homework.getInstanceList().getInstanceData(0).submit();
        csc207Homework.getInstanceList().getInstanceData(1).commit();

        Assertions.assertEquals(5,csc207.getOutline().getNumberOfAssessmentInstancesCompleted());
    }

}
