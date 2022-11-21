package entities.semester;

public class SemesterFactory implements SemesterFactoryInterface{

    @Override
    public Semester create() {
        return new Semester();
    }
}
