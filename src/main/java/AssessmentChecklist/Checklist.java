package AssessmentChecklist;

import java.util.ArrayList;
import java.util.List;

public class Checklist implements ChecklistInterface{
    private List<Assessment> allTasks = new ArrayList<>();
    private List<Assessment> taskToDo = new ArrayList<Assessment>();
    private List<Assessment> taskFinished = new ArrayList<Assessment>();
    private boolean showPast = false;
    private boolean showDetail = false;

    /**
     * Creating a Checklist object holding all finished assessments and
     * unfinished assessments
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
    public void addAssessment(Assessment assessment){
        if (assessment.getFinished()){
            this.taskFinished.add(assessment);
        }
        else {
            this.taskToDo.add(assessment);
        }
        this.allTasks.add(assessment);
    }

    @Override
    public void addAssessments(List<Assessment> assessmentList){
        for (Assessment i: assessmentList){
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
    public List<Assessment> getTaskToDo(){
        return this.taskToDo;
    }

    @Override
    public List<Assessment> getTaskFinished() {
        return taskFinished;
    }

    @Override
    public List<Assessment> getAllTasks() {
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
        for (Assessment i: this.taskToDo){
            if (this.showDetail) {
                i.toShowDetail();
            }
            else {
                i.toNotShowDetail();
            }
            taskT += i.toString() + "\n" + "\n";
        }
        String taskF = "";
        for (Assessment j: this.taskFinished){
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
    public Assessment findAssessment(String courseName, String name){
        for (Assessment i: this.allTasks){
            if (i.getCourseName() == courseName && i.getName() == name){
                return i;
            }
        }
        return null;
    }

    /**
     * Sort the assessment in the list according to three different values,
     * the date, the weight, and the contribution.
     * @param assessmentList a list of assessment, could be taskToDO,
     *                       taskFinished, or allTask
     */

    @Override
    public void sortInDdl(List<Assessment> assessmentList){
        for (int i = 0; i < assessmentList.size(); i++){
            for (int j = i + 1; j < assessmentList.size(); j++){
                if (assessmentList.get(j).getDdlDate().isBefore(assessmentList.get(i).getDdlDate())
                        || (assessmentList.get(j).getDdlDate().isEqual(assessmentList.get(i).getDdlDate()) &&
                        assessmentList.get(j).getDdlTime().isBefore(assessmentList.get(i).getDdlTime()))){
                    Assessment temp;
                    temp = assessmentList.get(j);
                    assessmentList.set(j, assessmentList.get(i));
                    assessmentList.set(i, temp);
                }
            }
        }
    }

    @Override
    public void sortInWeight(List<Assessment> assessmentList){
        for (int i = 0; i < assessmentList.size(); i++) {
            for (int j = i + 1; j < assessmentList.size(); j++) {
                if (assessmentList.get(j).getWeight() > assessmentList.get(i).getWeight()){
                    Assessment temp;
                    temp = assessmentList.get(j);
                    assessmentList.set(j, assessmentList.get(i));
                    assessmentList.set(i, temp);
                }
            }
        }
    }

    @Override
    public void sortInContribution(List<Assessment> assessmentList){
        for (int i = 0; i < assessmentList.size(); i++) {
            for (int j = i + 1; j < assessmentList.size(); j++) {
                if (assessmentList.get(j).getContribution() > assessmentList.get(i).getContribution()){
                    Assessment temp;
                    temp = assessmentList.get(j);
                    assessmentList.set(j, assessmentList.get(i));
                    assessmentList.set(i, temp);
                }
            }
        }
    }

}
