package AssessmentChecklist;

import java.util.ArrayList;
import java.util.List;

public class Checklist implements ChecklistInterface{
    private List<AssessmentCl> allTasks = new ArrayList<>();
    private List<AssessmentCl> taskToDo = new ArrayList<AssessmentCl>();
    private List<AssessmentCl> taskFinished = new ArrayList<AssessmentCl>();
    private boolean showPast = false;
    private boolean showDetail = false;

    /**
     * Creating a Checklist object holding all finished assessmentCls and
     * unfinished assessmentCls
     */
    public Checklist(){}

    @Override
    public void toShowDetail(){
        this.showDetail = true;
    }

    @Override
    public void toNotShowDetail(){
        this.showDetail = false;
    }

    @Override
    public void toShowPast(){
        this.showPast = true;
    }

    @Override
    public void  toNotShowPast(){
        this.showPast = false;
    }

    @Override
    public void addAssessmentCl(AssessmentCl assessmentCl){
        if (assessmentCl.getFinished()){
            this.taskFinished.add(assessmentCl);
        }
        else {
            this.taskToDo.add(assessmentCl);
        }
        this.allTasks.add(assessmentCl);
    }

    @Override
    public void addAssessmentCls(List<AssessmentCl> assessmentClList){
        for (AssessmentCl i: assessmentClList){
            if (i.getFinished()){
                this.taskFinished.add(i);
            }
            else {
                this.taskToDo.add(i);
            }
            this.allTasks.add(i);
        }
    }

    @Override
    public List<AssessmentCl> getTaskToDo(){
        return this.taskToDo;
    }

    @Override
    public List<AssessmentCl> getTaskFinished() {
        return taskFinished;
    }

    @Override
    public List<AssessmentCl> getAllTasks() {
        return allTasks;
    }

    @Override
    public void refresher(){
        this.taskToDo = new ArrayList<>();
        this.taskFinished = new ArrayList<>();
        this.allTasks = new ArrayList<>();
    }


    @Override
    public String toString(){
        String taskT = "";
        for (AssessmentCl i: this.taskToDo){
            if (this.showDetail) {
                i.toShowDetail();
            }
            else {
                i.toNotShowDetail();
            }
            taskT += i.toString() + "\n" + "\n";
        }
        String taskF = "";
        for (AssessmentCl j: this.taskFinished){
            if (this.showDetail) {
                j.toShowDetail();
            }
            else {
                j.toNotShowDetail();
            }
            taskF += j.toString() + "\n" + "\n";
        }
        if (this.showPast){
            return taskF + taskT;
        }
        else {
            return taskT;
        }
    }

    @Override
    public AssessmentCl findAssessmentCl(String courseName, String name){
        for (AssessmentCl i: this.allTasks){
            if (i.getCourseName() == courseName && i.getName() == name){
                return i;
            }
        }
        return null;
    }

    /**
     * Sort the assessmentCl in the list according to three different values,
     * the date, the weight, and the contribution.
     * @param assessmentClList a list of assessmentCl, could be taskToDO,
     *                       taskFinished, or allTask
     */

    @Override
    public void sortInDdl(List<AssessmentCl> assessmentClList){
        for (int i = 0; i < assessmentClList.size(); i++){
            for (int j = i + 1; j < assessmentClList.size(); j++){
                if (assessmentClList.get(j).getDdlDate().isBefore(assessmentClList.get(i).getDdlDate())
                        || (assessmentClList.get(j).getDdlDate().isEqual(assessmentClList.get(i).getDdlDate()) &&
                        assessmentClList.get(j).getDdlTime().isBefore(assessmentClList.get(i).getDdlTime()))){
                    AssessmentCl temp;
                    temp = assessmentClList.get(j);
                    assessmentClList.set(j, assessmentClList.get(i));
                    assessmentClList.set(i, temp);
                }
            }
        }
    }

    @Override
    public void sortInWeight(List<AssessmentCl> assessmentClList){
        for (int i = 0; i < assessmentClList.size(); i++) {
            for (int j = i + 1; j < assessmentClList.size(); j++) {
                if (assessmentClList.get(j).getWeight() > assessmentClList.get(i).getWeight()){
                    AssessmentCl temp;
                    temp = assessmentClList.get(j);
                    assessmentClList.set(j, assessmentClList.get(i));
                    assessmentClList.set(i, temp);
                }
            }
        }
    }

    @Override
    public void sortInContribution(List<AssessmentCl> assessmentClList){
        for (int i = 0; i < assessmentClList.size(); i++) {
            for (int j = i + 1; j < assessmentClList.size(); j++) {
                if (assessmentClList.get(j).getContribution() > assessmentClList.get(i).getContribution()){
                    AssessmentCl temp;
                    temp = assessmentClList.get(j);
                    assessmentClList.set(j, assessmentClList.get(i));
                    assessmentClList.set(i, temp);
                }
            }
        }
    }

}
