package entities.assessment.instanceList;

public class InstanceListFactory {
    public InstanceList create(String pluralTitle, int totalNumberOfInstances) {
        return new InstanceList(pluralTitle, totalNumberOfInstances);
    }
}
