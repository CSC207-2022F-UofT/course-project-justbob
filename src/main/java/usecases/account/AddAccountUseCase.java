package usecases.account;

import entities.account.Account;
import entities.account.Archive;
import entities.account.Semester;
import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.addAccount.AddAccountInputBoundary;
import ports.usecases.account.addAccount.AddAccountRequest;

// TODO: implement testing
public class AddAccountUseCase implements AddAccountInputBoundary {

    private EntityFactory entityFactory;
    private EntityGateway entityGateway;

    public AddAccountUseCase(EntityFactory entityFactory, EntityGateway entityGateway) {
        this.entityFactory = entityFactory;
        this.entityGateway = entityGateway;
    }

    public void execute(AddAccountRequest request) {
        if (entityGateway.existsAccount(request.username)) {
            throw new UsernameAlreadyInUseError(request.username);
        }
        Account account = entityFactory.createAccount();
        setFields(account, request);
        entityGateway.saveAccount(account);
    }

    private void setFields(Account account, AddAccountRequest request) {
        account.setUsername(request.username);
        account.setPassword(request.password);
        account.setSemester(entityFactory.createSemester());
        account.setArchive(entityFactory.createArchive());
    }
}
