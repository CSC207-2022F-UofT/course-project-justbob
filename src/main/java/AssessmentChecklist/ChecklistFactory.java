package AssessmentChecklist;

public class ChecklistFactory implements ChecklistFactoryInterface{
    @Override
    public Checklist create(){
        return new Checklist();
    }

}
