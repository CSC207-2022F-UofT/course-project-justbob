package entities.archive;

public class ArchiveFactory implements ArchiveFactoryInterface {
    @Override
    public Archive create() {
        return new Archive();
    }
}
