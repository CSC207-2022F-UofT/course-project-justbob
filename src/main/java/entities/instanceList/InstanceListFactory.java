package entities.instanceList;

public class InstanceListFactory implements InstanceListFactoryInterface{

    @Override
    public InstanceList create(String pluralTitle, int totalNumberOfInstances) {
        return new InstanceList(pluralTitle, totalNumberOfInstances);
    }
}
