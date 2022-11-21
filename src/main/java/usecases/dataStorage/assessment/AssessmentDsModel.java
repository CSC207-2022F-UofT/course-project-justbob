package usecases.dataStorage.assessment;

import usecases.dataStorage.instance.InstanceDsModel;
import usecases.dataStorage.weightScheme.WeightSchemeDsModel;

import java.util.List;

public class AssessmentDsModel {
    private String title;
    private List<InstanceDsModel> instanceData;
    private WeightSchemeDsModel weightSchemeModel;

    public AssessmentDsModel(String title, List<InstanceDsModel> instanceData,
                             WeightSchemeDsModel weightSchemeModel) {
        this.title = title;
        this.instanceData = instanceData;
        this.weightSchemeModel = weightSchemeModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<InstanceDsModel> getInstanceData() {
        return instanceData;
    }

    public void setInstanceData(List<InstanceDsModel> instanceData) {
        this.instanceData = instanceData;
    }

    public WeightSchemeDsModel getWeightSchemeModel() {
        return weightSchemeModel;
    }

    public void setWeightSchemeModel(WeightSchemeDsModel weightSchemeModel) {
        this.weightSchemeModel = weightSchemeModel;
    }
}
