package gradeTrend;

import courseManager.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.SimpleWeight;
import weightScheme.Weight;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class GradeTrendOverallTest {
    @Test
    public void gradeTrendOverallCommitted() {
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

        List<Course> courses = new ArrayList<>();
        courses.add(csc207);

        gradeTrendOverall csc207GPATrend = new gradeTrendOverall(courses);
        csc207GPATrend.calculateGPATrend();
        List<String> xData = csc207GPATrend.getXData();
        List<Double> yData = csc207GPATrend.getYData();

        List<String> expectedXData = new ArrayList<>();
        expectedXData.add("Software Design");


        Assertions.assertArrayEquals(expectedXData.toArray(), xData.toArray());
        Assertions.assertEquals(95, round(yData.get(0)));
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

        List<Course> courses = new ArrayList<>();
        courses.add(csc207);

        gradeTrendOverall csc207GPATrend = new gradeTrendOverall(courses);
        csc207GPATrend.calculateGPATrend();
        List<String> xData = csc207GPATrend.getXData();
        List<Double> yData = csc207GPATrend.getYData();

        List<String> expectedXData = new ArrayList<>();
        expectedXData.add("Software Design");


        Assertions.assertArrayEquals(expectedXData.toArray(), xData.toArray());
        Assertions.assertEquals(90, round(yData.get(0)));
    }

}
