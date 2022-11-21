package gradeTrend;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;

import javax.swing.*;
import java.util.List;

public class gradeTrendView {
    private JPanel currentPanel;
    private final JFrame frame;

    public gradeTrendView(JFrame frame) {
        this.frame = frame;
    }

    public void updateFrame(gradeTrendInterface t) {
        String name = t.toString();
        List<String> xData = t.getXData();
        List<Double> yData = t.getYData();

        CategoryChart chart = new CategoryChart(1000, 500);
        chart.addSeries(name, xData, yData);

        JPanel chartPanel = new XChartPanel<>(chart);

        if (this.currentPanel != null) {
            this.frame.remove(this.currentPanel);
        }
        this.frame.add(chartPanel);
        this.currentPanel = chartPanel;
    }

    public static void showGraph(gradeTrendInterface t) {
        String name = t.toString();
        List<String> xData = t.getXData();
        List<Double> yData = t.getYData();

        CategoryChart chart = new CategoryChart(1000, 500);
        chart.addSeries(name, xData, yData);

        SwingWrapper<CategoryChart> sw = new SwingWrapper<>(chart);
        sw.displayChart();
    }
}
