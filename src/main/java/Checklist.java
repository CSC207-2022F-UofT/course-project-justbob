package main;

import java.util.ArrayList;
import java.util.List;

public class Checklist {
    private List<Assignment> allTasks = new ArrayList<>();
    private List<Assignment> taskToDo = new ArrayList<Assignment>();
    private List<Assignment> taskFinished = new ArrayList<Assignment>();
    private boolean showPast = false;
    private boolean showDetail = false;

    /**
     * Creating a Checklist object holding all finished assignments and
     * unfinished assignments
     */
    public Checklist(){}

    public void toShowDetail(){
        this.showDetail = true;
    }

    public void addAssignment(Assignment assignment){
        if (assignment.getFinished()){
            this.taskFinished.add(assignment);
        }
        else {
            this.taskToDo.add(assignment);
        }
        this.allTasks.add(assignment);
    }

    public void addAssignments(List<Assignment> assignmentList){
        for (Assignment i: assignmentList){
            if (i.getFinished()){
                this.taskFinished.add(i);
            }
            else {
                this.taskToDo.add(i);
            }
            this.allTasks.add(i);
        }
    }

    public List<Assignment> getTaskToDo(){
        return this.taskToDo;
    }

    public List<Assignment> getTaskFinished() {
        return taskFinished;
    }

    public List<Assignment> getAllTasks() {
        return allTasks;
    }

    public void refresher(){
        this.taskToDo = new ArrayList<>();
        this.taskFinished = new ArrayList<>();
    }


    public String toString(){
        String taskT = "";
        for (Assignment i: this.taskToDo){
            if (this.showDetail) {
                i.toShowDetail();
            }
            taskT += i.toString() + "\n";
        }
        String taskF = "";
        for (Assignment j: this.taskFinished){
            if (this.showDetail) {
                j.toShowDetail();
            }
            taskF += j.toString() + "\n";
        }
        if (this.showPast){
            return taskF + taskT;
        }
        else {
            return taskT;
        }
    }

    /**
     * Sort the assignment in the list according to three different values,
     * the date, the weight, and the contribution.
     * @param assignmentList a list of assignment, could be taskToDO,
     *                       taskFinished, or allTask
     */

    public void sortInDdl(List<Assignment> assignmentList){
        for (int i = 0; i < assignmentList.size(); i++){
            for (int j = i + 1; j < assignmentList.size(); j++){
                if (assignmentList.get(j).getDdl().before(assignmentList.get(j).getDdl())){
                    Assignment temp;
                    temp = assignmentList.get(j);
                    assignmentList.set(j, assignmentList.get(i));
                    assignmentList.set(i, temp);
                }
            }
        }
    }

    public void sortInWeight(List<Assignment> assignmentList){
        for (int i = 0; i < assignmentList.size(); i++) {
            for (int j = i + 1; j < assignmentList.size(); j++) {
                if (assignmentList.get(j).getWeight() < assignmentList.get(i).getWeight()){
                    Assignment temp;
                    temp = assignmentList.get(j);
                    assignmentList.set(j, assignmentList.get(i));
                    assignmentList.set(i, temp);
                }
            }
        }
    }

    public void sortInContribution(List<Assignment> assignmentList){
        for (int i = 0; i < assignmentList.size(); i++) {
            for (int j = i + 1; j < assignmentList.size(); j++) {
                if (assignmentList.get(j).getContribution() < assignmentList.get(i).getContribution()){
                    Assignment temp;
                    temp = assignmentList.get(j);
                    assignmentList.set(j, assignmentList.get(i));
                    assignmentList.set(i, temp);
                }
            }
        }
    }

}
