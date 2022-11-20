package accountClasses.entities;

public class ArchiveFactory implements ArchiveFactoryInterface{
    @Override
    public Archive create() {
        return new Archive();
    }
}
