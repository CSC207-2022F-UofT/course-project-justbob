package usecases.checklist;

import entities.account.Account;
import entities.task.TaskList;
import inMemoryDB.entities.TaskListImpl;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.checklist.ChecklistInputBoundary;
import ports.usecases.checklist.ChecklistModel;

public class ChecklistUseCase implements ChecklistInputBoundary {
    private EntityGateway entityGateway;

    public ChecklistUseCase(EntityGateway entityGateway){
        this.entityGateway = entityGateway;
    }

    @Override
    public ChecklistModel execute(String userName) throws PathNotFoundError {
        if (!entityGateway.existsAccount(userName)){
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(userName);
        TaskList taskList = new TaskListImpl(account);
        return new ChecklistModel(taskList);
    }
    
}

