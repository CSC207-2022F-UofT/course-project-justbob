package usecases.dataStorage;

public class SimpleWeightDsModel extends WeightSchemeDsModel {
    private WeightDsModel weightModel;

    public SimpleWeightDsModel(WeightDsModel weightModel) {
        this.weightModel = weightModel;
    }

    public WeightDsModel getWeightModel() {
        return weightModel;
    }
}
