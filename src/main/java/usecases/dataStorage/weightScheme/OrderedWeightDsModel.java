package usecases.dataStorage.weightScheme;

public class OrderedWeightDsModel extends WeightSchemeDsModel{
    private WeightDsModel[] orderedWeightModels;

    public OrderedWeightDsModel(WeightDsModel[] orderedWeightModels) {
        this.orderedWeightModels = orderedWeightModels;
    }

    public WeightDsModel[] getOrderedWeightModels() {
        return orderedWeightModels;
    }
}
