package entities.outline;

public class OutlineFactory implements OutlineFactoryInterface{

    @Override
    public Outline create() {
        return new Outline();
    }
}
