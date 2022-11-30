package usecases.checklist;

import entities.account.Account;
import entities.task.TaskList;
import inMemoryDB.entities.TaskListImpl;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.checklist.ChecklistInputBoundary;
import ports.usecases.checklist.ChecklistModel;

public class ChecklistUseCase implements ChecklistInputBoundary {
    private final EntityGateway entityGateway;

    public ChecklistUseCase(EntityGateway entityGateway){
        this.entityGateway = entityGateway;
    }

    @Override
    public ChecklistModel execute(String username) throws PathNotFoundError {
        if (!entityGateway.existsAccount(username)) {
            throw new PathNotFoundError("username: " + username);
        }
        Account account = entityGateway.loadAccount(username);
        TaskList taskList = new TaskListImpl(account);
        return new ChecklistModel(taskList);
    }
    
}

