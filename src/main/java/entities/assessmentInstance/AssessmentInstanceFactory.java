package entities.assessmentInstance;

public class AssessmentInstanceFactory implements AssessmentInstanceFactoryInterface{

    @Override
    public AssessmentInstance create(String assessmentInstanceName) {
        return new AssessmentInstance(assessmentInstanceName);
    }
}
