package gradeTrend;

import java.util.List;

public interface gradeTrendInterface {
    void calculateGPATrend();

    List<String> getXData();

    List<Double> getYData();

    void setHypothetical(boolean value);
}
