package ports.usecases.checklist;

import entities.task.Task;
import entities.task.TaskList;

import java.util.List;

public class ChecklistModel {
        public List<Task> taskToDo;
        public List<Task> taskCommitted;
        public List<Task> taskSubmitted;
        public List<Task> taskAll;

        public ChecklistModel(TaskList taskList){
            for (Task task: taskList.getTaskList()) {
                if (task.getCommitted()) {
                    taskCommitted.add(task);
                }
                if (task.getSubmitted()) {
                    taskSubmitted.add(task);
                }
                if (!task.getSubmitted() && !task.getCommitted()) {
                    taskToDo.add(task);
                }
                taskAll.add(task);
            }
        }
}
