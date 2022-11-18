package gradeTrend;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;

import java.util.ArrayList;
import java.util.List;

public class gradeTrendView {
    public static void showGraph(String name, List<String> xData, List<Double> yData) {
        CategoryChart chart = new CategoryChart(1000, 500);
        chart.addSeries(name, xData, yData);

        // XChartPanel<CategoryChart> chartPanel = new XChartPanel<>(chart);
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

        gradeTrendView.showGraph("Example Graph", xData, yData);
    }

    public void showGraph(gradeTrendInterface t) {
        String name = t.toString();
        List<String> xData = t.getXData();
        List<Double> yData = t.getYData();

        CategoryChart chart = new CategoryChart(1000, 500);
        chart.addSeries(name, xData, yData);

        SwingWrapper<CategoryChart> sw = new SwingWrapper<>(chart);
        sw.displayChart();
    }
}
