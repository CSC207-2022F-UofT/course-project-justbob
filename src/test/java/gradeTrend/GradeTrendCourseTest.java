package gradeTrend;

import courseManager.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.SimpleWeight;
import weightScheme.Weight;

public class GradeTrendCourseTest {
    @Test
    public void gradeTrendCourseCommitted() {
        Course csc207 = new Course("CSC207", "Software Design", "Fall 2022", false, 1.0f);

        Assessment csc207Quizzes = new Assessment("Quizzes", new SimpleWeight(new Weight(3, 0.1)));
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        AssessmentInstance csc207Quiz1 = new AssessmentInstance("Quiz 1");
        AssessmentInstance csc207Quiz2 = new AssessmentInstance("Quiz 2");
        AssessmentInstance csc207Quiz3 = new AssessmentInstance("Quiz 3");

        csc207Quiz1.setMark(80.0);
        csc207Quiz2.setMark(90.0);
        csc207Quiz3.setMark(100.0);

        instanceList.addInstance(csc207Quiz1);
        instanceList.addInstance(csc207Quiz2);
        instanceList.addInstance(csc207Quiz3);

        // csc207Quiz1.commit();
        csc207Quiz2.commit();
        csc207Quiz3.commit();

        Outline csc207Outline = new Outline();
        csc207Outline.addAssessment(csc207Quizzes);

        csc207.setOutline(csc207Outline);

        gradeTrendCourse csc207GPATrend = new gradeTrendCourse(csc207);
        csc207GPATrend.calculateGPATrend();
        Object[] xData = csc207GPATrend.getXData().toArray();
        Object[] yData = csc207GPATrend.getYData().toArray();

        Assertions.assertEquals(1, xData.length);
        Assertions.assertEquals("Quizzes", xData[0]);
        Assertions.assertEquals(1, yData.length);
        Assertions.assertEquals(95.0, yData[0]);
    }

    @Test
    public void gradeTrendCourseHypothetical() {
        Course csc207 = new Course("CSC207", "Software Design", "Fall 2022", false, 1.0f);

        Assessment csc207Quizzes = new Assessment("Quizzes", new SimpleWeight(new Weight(3, 0.1)));
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        AssessmentInstance csc207Quiz1 = new AssessmentInstance("Quiz 1");
        AssessmentInstance csc207Quiz2 = new AssessmentInstance("Quiz 2");
        AssessmentInstance csc207Quiz3 = new AssessmentInstance("Quiz 3");

        csc207Quiz1.setMark(80.0);
        csc207Quiz2.setMark(90.0);
        csc207Quiz3.setMark(100.0);

        csc207Quiz1.commit();
        csc207Quiz2.commit();
        csc207Quiz3.commit();

        instanceList.addInstance(csc207Quiz1);
        instanceList.addInstance(csc207Quiz2);
        instanceList.addInstance(csc207Quiz3);

        Outline csc207Outline = new Outline();
        csc207Outline.addAssessment(csc207Quizzes);

        csc207.setOutline(csc207Outline);

        gradeTrendCourse csc207GPATrend = new gradeTrendCourse(csc207);
        csc207GPATrend.setHypothetical(true);
        csc207GPATrend.calculateGPATrend();
        Object[] xData = csc207GPATrend.getXData().toArray();
        Object[] yData = csc207GPATrend.getYData().toArray();

        Assertions.assertEquals(1, xData.length);
        Assertions.assertEquals("Quizzes", xData[0]);
        Assertions.assertEquals(1, yData.length);
        Assertions.assertEquals(90.0, yData[0]);
    }

}
