package AssessmentChecklist;

public class AssessmentFactory implements AssessmentFactoryInterface{
    @Override
    public Assessment create(String courseName, String name) {
        return new Assessment(courseName, name);
    }
}
