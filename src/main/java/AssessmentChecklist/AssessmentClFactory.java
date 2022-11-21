package AssessmentChecklist;

public class AssessmentClFactory implements AssessmentClFactoryInterface{
    @Override
    public AssessmentCl create(String courseName, String name) {
        return new AssessmentCl(courseName, name);
    }
}
