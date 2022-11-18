package gradeTrend;

import courseManager.Assessment;
import courseManager.Course;
import courseManager.InstanceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weightScheme.SimpleWeight;
import weightScheme.Weight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GradeTrendOverallTest {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    @Test
    public void gradeTrendOverallCommitted() {
        Course csc207 = new Course("CSC207", "Software Design", "Fall 2022", false, 1.0f);

        Assessment csc207Quizzes = new Assessment("Quizzes", new SimpleWeight(new Weight(3, 0.1)));
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        instanceList.editInstanceMark(0, 0.80);
        instanceList.editInstanceMark(1, 0.90);
        instanceList.editInstanceMark(2, 1.00);

        instanceList.getInstanceData(1).commit();
        instanceList.getInstanceData(2).commit();

        csc207.getOutline().addAssessment(csc207Quizzes);

        List<Course> courses = new ArrayList<>();
        courses.add(csc207);

        gradeTrendOverall csc207GPATrend = new gradeTrendOverall(courses);
        csc207GPATrend.calculateGPATrend();
        List<String> xData = csc207GPATrend.getXData();
        List<Double> yData = csc207GPATrend.getYData();

        List<String> expectedXData = new ArrayList<>();
        expectedXData.add("Software Design");


        Assertions.assertArrayEquals(expectedXData.toArray(), xData.toArray());
        Assertions.assertEquals(0.95, round(yData.get(0), 2));
    }

    @Test
    public void gradeTrendCourseHypothetical() {
        Course csc207 = new Course("CSC207", "Software Design", "Fall 2022", false, 1.0f);

        Assessment csc207Quizzes = new Assessment("Quizzes", new SimpleWeight(new Weight(3, 0.1)));
        InstanceList instanceList = csc207Quizzes.getInstanceList();

        instanceList.editInstanceMark(0, 0.80);
        instanceList.editInstanceMark(1, 0.90);
        instanceList.editInstanceMark(2, 1.00);

        instanceList.getInstanceData(0).commit();

        csc207.getOutline().addAssessment(csc207Quizzes);

        List<Course> courses = new ArrayList<>();
        courses.add(csc207);

        gradeTrendOverall csc207GPATrend = new gradeTrendOverall(courses);
        csc207GPATrend.calculateGPATrend();
        List<String> xData = csc207GPATrend.getXData();
        List<Double> yData = csc207GPATrend.getYData();

        List<String> expectedXData = new ArrayList<>();
        expectedXData.add("Software Design");


        Assertions.assertArrayEquals(expectedXData.toArray(), xData.toArray());
        Assertions.assertEquals(0.9, round(yData.get(0), 1));
    }

}
