import java.util.ArrayList;
public class Assessment {
    private String title;
    private ArrayList<InstanceList> instanceList;
    private WeightScheme weightScheme;


    public Assessment(String title, WeightScheme weightScheme, ArrayList<InstanceList> instanceList) {
        this.title = title;
        this.weightScheme = weightScheme;
        this.instanceList = instanceList;
    }

    public float getTotalWeight() {
        float totalWeight = 0.0f;
        /*iterate through each instance in the instance list and add its weight to the total weight*/
        return totalWeight;
    }

    public float getCommittedWeight() {
        float committedWeight = 0.0f;
        /*iterate through the instance list and add committed instances' weight*/
        return committedWeight;
    }

    public float getHypotheticalWeight() {
        float hypotheticalWeight = 0.0f;
        /*iterate through the instance list and add all submitted weights together*/
        return hypotheticalWeight;
    }

    public ArrayList<InstanceList> getInstanceList() {
        return instanceList;
    }
}
