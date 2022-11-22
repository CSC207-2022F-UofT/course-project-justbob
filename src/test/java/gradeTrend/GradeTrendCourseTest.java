package gradeTrend;

import entities.assessment.Assessment;
import entities.course.Course;
import entities.assessment.instanceList.InstanceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.SimpleWeight;
import weightScheme.Weight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GradeTrendCourseTest {
    Course csc207 = new Course("CSC207", "Software Design", 1.0f);

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    @Test
    public void gradeTrendCourseCommitted() {
        Assessment csc207Quizzes = new Assessment("Quizzes", new SimpleWeight(new Weight(3, 0.1)));
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        instanceList.editInstanceMark(0, 0.80);
        instanceList.editInstanceMark(1, 0.90);
        instanceList.editInstanceMark(2, 1.00);

        instanceList.getInstanceData(1).commit();
        instanceList.getInstanceData(2).commit();

        csc207.getOutline().addAssessment(csc207Quizzes);

        gradeTrendCourse csc207GPATrend = new gradeTrendCourse(csc207);
        csc207GPATrend.calculateGPATrend();
        List<String> xData = csc207GPATrend.getXData();
        List<Double> yData = csc207GPATrend.getYData();

        List<String> expectedXData = new ArrayList<>();
        expectedXData.add("Quizzes");


        Assertions.assertArrayEquals(expectedXData.toArray(), xData.toArray());
        Assertions.assertEquals(0.95, round(yData.get(0), 2));
    }

    @Test
    public void gradeTrendCourseHypothetical() {
        Assessment csc207Quizzes = new Assessment("Quizzes", new SimpleWeight(new Weight(3, 0.1)));
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        instanceList.editInstanceMark(0, 0.80);
        instanceList.editInstanceMark(1, 0.90);
        instanceList.editInstanceMark(2, 1.00);

        instanceList.getInstanceData(0).commit();

        csc207.getOutline().addAssessment(csc207Quizzes);

        gradeTrendCourse csc207GPATrend = new gradeTrendCourse(csc207);
        csc207GPATrend.setHypothetical(true);
        csc207GPATrend.calculateGPATrend();
        List<String> xData = csc207GPATrend.getXData();
        List<Double> yData = csc207GPATrend.getYData();

        List<String> expectedXData = new ArrayList<>();
        expectedXData.add("Quizzes");


        Assertions.assertArrayEquals(expectedXData.toArray(), xData.toArray());
        Assertions.assertEquals(0.9, round(yData.get(0), 1));
    }

}
