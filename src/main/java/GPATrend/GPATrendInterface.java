package GPATrend;

import java.util.HashMap;
import java.util.List;

public interface GPATrendInterface {
    void calculateGPATrend();
    List<String> getXData();
    List<Double> getYData();

    void setHypothetical(boolean value);
}
