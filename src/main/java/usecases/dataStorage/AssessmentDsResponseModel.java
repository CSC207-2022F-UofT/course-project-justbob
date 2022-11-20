package usecases.dataStorage;

public class AssessmentDsResponseModel {
    private String title;
    private InstanceDsResponseModel[] instanceData;
    private WeightSchemeDsModel weightSchemeModel;

    public AssessmentDsResponseModel(String title, InstanceDsResponseModel[] instanceData,
                                     WeightSchemeDsModel weightSchemeModel) {
        this.title = title;
        this.instanceData = instanceData;
        this.weightSchemeModel = weightSchemeModel;
    }

    public String getTitle() {
        return title;
    }

    public InstanceDsResponseModel[] getInstanceData() {
        return instanceData;
    }

    public WeightSchemeDsModel getWeightSchemeModel() {
        return weightSchemeModel;
    }
}
