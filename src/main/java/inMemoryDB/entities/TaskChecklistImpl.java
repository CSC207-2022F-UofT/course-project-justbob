package inMemoryDB.entities;

import entities.task.Task;
import entities.task.TaskChecklist;
import entities.task.TaskList;

import java.util.List;

public class TaskChecklistImpl extends TaskChecklist {
    private List<Task> taskToDo;
    private List<Task> taskCommitted;
    private List<Task> taskSubmitted;
    private Boolean showDetail = false;
    private Boolean showToDo = false;
    private Boolean showCommitted = false;
    private Boolean showSubmitted = false;

    public TaskChecklistImpl(TaskList taskList){
        for (Task task: taskList.getTaskList()) {
            if (task.getCommitted()) {
                this.taskCommitted.add(task);
            }
            if (task.getSubmitted()) {
                this.taskSubmitted.add(task);
            }
            if (!task.getSubmitted() && !task.getCommitted()) {
                this.taskToDo.add(task);
            }
        }
    }

    @Override
    public void sortInDDL(){
        List<Task> newTaskListT = taskToDo;
        for (int i = 0; i < newTaskListT.size(); i++){
            for (int j = i + 1; j < newTaskListT.size(); j++){
                if (newTaskListT.get(j).getDueTime().isBefore(newTaskListT.get(i).getDueTime())){
                    Task temp;
                    temp = newTaskListT.get(j);
                    newTaskListT.set(j, newTaskListT.get(i));
                    newTaskListT.set(i, temp);
                }
            }
        }
        taskToDo = newTaskListT;
        List<Task> newTaskListS = taskSubmitted;
        for (int i = 0; i < newTaskListS.size(); i++){
            for (int j = i + 1; j < newTaskListS.size(); j++){
                if (newTaskListS.get(j).getDueTime().isBefore(newTaskListS.get(i).getDueTime())){
                    Task temp;
                    temp = newTaskListS.get(j);
                    newTaskListS.set(j, newTaskListS.get(i));
                    newTaskListS.set(i, temp);
                }
            }
        }
        taskSubmitted = newTaskListS;
        List<Task> newTaskListC = taskToDo;
        for (int i = 0; i < newTaskListC.size(); i++){
            for (int j = i + 1; j < newTaskListC.size(); j++){
                if (newTaskListC.get(j).getDueTime().isBefore(newTaskListC.get(i).getDueTime())){
                    Task temp;
                    temp = newTaskListC.get(j);
                    newTaskListC.set(j, newTaskListC.get(i));
                    newTaskListC.set(i, temp);
                }
            }
        }
        taskCommitted = newTaskListC;
    }

    @Override
    public void sortInMark(){
        List<Task> newTaskListT = taskToDo;
        for (int i = 0; i < newTaskListT.size(); i++){
            for (int j = i + 1; j < newTaskListT.size(); j++){
                if (newTaskListT.get(j).getMark() < newTaskListT.get(i).getMark()){
                    Task temp;
                    temp = newTaskListT.get(j);
                    newTaskListT.set(j, newTaskListT.get(i));
                    newTaskListT.set(i, temp);
                }
            }
        }
        taskToDo = newTaskListT;
        List<Task> newTaskListS = taskSubmitted;
        for (int i = 0; i < newTaskListS.size(); i++){
            for (int j = i + 1; j < newTaskListS.size(); j++){
                if (newTaskListS.get(j).getMark() < newTaskListS.get(i).getMark()){
                    Task temp;
                    temp = newTaskListS.get(j);
                    newTaskListS.set(j, newTaskListS.get(i));
                    newTaskListS.set(i, temp);
                }
            }
        }
        taskSubmitted = newTaskListS;
        List<Task> newTaskListC = taskToDo;
        for (int i = 0; i < newTaskListC.size(); i++){
            for (int j = i + 1; j < newTaskListC.size(); j++){
                if (newTaskListC.get(j).getMark() < newTaskListC.get(i).getMark()){
                    Task temp;
                    temp = newTaskListC.get(j);
                    newTaskListC.set(j, newTaskListC.get(i));
                    newTaskListC.set(i, temp);
                }
            }
        }
        taskCommitted = newTaskListC;
    }

    @Override
    public void toShowDetail(){
        this.showDetail = true;
        for (Task i: taskToDo){
            i.toShowDetail();
        }
        for (Task j: taskSubmitted){
            j.toShowDetail();
        }
        for (Task k: taskCommitted){
            k.toShowDetail();
        }
    }

    @Override
    public void toNotShowDetail(){
        this.showDetail = true;
        for (Task i: taskToDo){
            i.toNotShowDetail();
        }
        for (Task j: taskSubmitted){
            j.toNotShowDetail();
        }
        for (Task k: taskCommitted){
            k.toNotShowDetail();
        }
    }

    @Override
    public void toShowToDo(){
        this.showToDo = true;
    }

    @Override
    public void toNotShowToDo(){
        this.showToDo = false;
    }

    @Override
    public void toShowCommitted(){
        this.showCommitted = true;
    }

    @Override
    public void toNotShowCommitted(){
        this.showCommitted = true;
    }

    @Override
    public void toShowSubmitted(){
        this.showSubmitted = true;
    }

    @Override
    public void toNotShowSubmitted(){
        this.showSubmitted = true;
    }


    public String toString(){
        String taskT = null;
        for (Task i: this.taskToDo){
            taskT += i.toString() + "\n";
        }
        String taskC = null;
        for (Task i: this.taskToDo){
            taskC += i.toString() + "\n";
        }
        String taskS = null;
        for (Task i: this.taskToDo){
            taskS += i.toString() + "\n";
        }
        String result = null;
        if (showCommitted){
            result += taskC;
        }
        if (showSubmitted){
            result += taskS;
        }
        if (showToDo){
            result += taskT;
        }
        return result;
    }
}