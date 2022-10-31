package weightScheme;

import java.util.List;

public class SimpleWeight implements weightScheme {
    private Weight weight;

    public SimpleWeight(int numberOfInstances, int weightOfEachInstance) {
        this.weight = new Weight(numberOfInstances, weightOfEachInstance);
    }

    @Override
    public float computeWeight(List<Float> marks) {
        return 0;
    }

    @Override
    public float getTotalWeight() {
        return weight.getTotalWeight();
    }

    @Override
    public int getNumberOfInstances() {
        return weight.getNumberOfInstances();
    }
}
