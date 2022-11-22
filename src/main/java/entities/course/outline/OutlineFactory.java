package entities.course.outline;

public class OutlineFactory implements OutlineFactoryInterface{
    public Outline create() {
        return new Outline();
    }
}
