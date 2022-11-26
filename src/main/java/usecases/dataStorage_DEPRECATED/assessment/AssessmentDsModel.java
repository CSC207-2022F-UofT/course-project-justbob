package usecases.dataStorage_DEPRECATED.assessment;

import usecases.dataStorage_DEPRECATED.instance.InstanceDsModel;
import usecases.dataStorage_DEPRECATED.weightScheme.WeightSchemeDsModel;

import java.io.Serializable;
import java.util.List;

public class AssessmentDsModel implements Serializable {
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
