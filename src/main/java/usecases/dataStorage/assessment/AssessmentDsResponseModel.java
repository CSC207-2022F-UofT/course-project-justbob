package usecases.dataStorage.assessment;

import usecases.dataStorage.instance.InstanceDsResponseModel;
import usecases.dataStorage.weightScheme.WeightSchemeDsModel;

import java.util.List;

public class AssessmentDsResponseModel {
    private String title;
    private List<InstanceDsResponseModel> instanceData;
    private WeightSchemeDsModel weightSchemeModel;

    public AssessmentDsResponseModel(String title, List<InstanceDsResponseModel> instanceData,
                                     WeightSchemeDsModel weightSchemeModel) {
        this.title = title;
        this.instanceData = instanceData;
        this.weightSchemeModel = weightSchemeModel;
    }

    public String getTitle() {
        return title;
    }

    public List<InstanceDsResponseModel>  getInstanceData() {
        return instanceData;
    }

    public WeightSchemeDsModel getWeightSchemeModel() {
        return weightSchemeModel;
    }
}
