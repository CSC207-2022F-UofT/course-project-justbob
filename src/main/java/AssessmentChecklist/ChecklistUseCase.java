package usecases.checklist;

import entities.task.Task;

import java.util.List;

public class ChecklistUseCase {
    private List<Task> taskToDo;
    private List<Task> taskCommitted;
    private List<Task> taskSubmitted;
    private List<Task> taskAll;

    public ChecklistUseCase(Task task){
        if (task.getCommitted()){
            taskCommitted.add(task);
        }
        if (task.getSubmitted()){
            taskSubmitted.add(task);
        }
        if (!task.getSubmitted() && !task.getCommitted()){
            taskToDo.add(task);
        }
        taskAll.add(task);
    }

    public ChecklistUseCase(List<Task> taskList){
        for (Task task: taskList){
            if (task.getCommitted()){
                taskCommitted.add(task);
            }
            if (task.getSubmitted()){
                taskSubmitted.add(task);
            }
            if (!task.getSubmitted() && !task.getCommitted()){
                taskToDo.add(task);
            }
            taskAll.add(task);
        }
    }

    public String getTaskToDo(){
        return taskToDo.toString();
    }

    public String getTaskCommitted(){
        return taskCommitted.toString();
    }

    public String getTaskSubmitted(){
        return taskSubmitted.toString();
    }
}
