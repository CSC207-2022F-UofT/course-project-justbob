package GPATrend;

import javax.swing.*;
import org.knowm.xchart.*;

import java.util.ArrayList;
import java.util.List;

public class GPATrendView {
    public static void showGraph(String name, List<String> xData, List<Double> yData) {
        CategoryChart chart = new CategoryChart(1000, 500);
        chart.addSeries(name, xData, yData);

        SwingWrapper<CategoryChart> sw = new SwingWrapper<>(chart);
        sw.displayChart();
    }

    public static void showGraph(GPATrendInterface t) {
        String name = t.toString();
        t.calculateGPATrend();
        List<String> xData = t.getXData();
        List<Double> yData = t.getYData();

        CategoryChart chart = new CategoryChart(1000, 500);
        chart.addSeries(name, xData, yData);

        SwingWrapper<CategoryChart> sw = new SwingWrapper<>(chart);
        sw.displayChart();
    }

    public static void main(String[] args) {
        List<String> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        xData.add("Course 1");
        xData.add("Course 2");
        xData.add("Course 3");
        yData.add(1.0);
        yData.add(1.5);
        yData.add(2.75);

        GPATrendView.showGraph("Example Graph", xData, yData);
    }
}
