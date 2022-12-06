package usecases.account;

import entities.account.Account;
import entities.account.Archive;
import entities.account.Semester;
import ports.database.EntityGateway;
import ports.usecases.account.addAccount.AddAccountInputBoundary;
import ports.usecases.account.addAccount.AddAccountRequest;

// TODO: implement testing
public class AddAccountUseCase implements AddAccountInputBoundary {
    private final Account.AccountFactory accountFactory;
    private final Semester.SemesterFactory semesterFactory;
    private final Archive.ArchiveFactory archiveFactory;
    private final EntityGateway entityGateway;

    public AddAccountUseCase(
            Account.AccountFactory accountFactory,
            Semester.SemesterFactory semesterFactory,
            Archive.ArchiveFactory archiveFactory,
            EntityGateway entityGateway
    ) {
        this.accountFactory = accountFactory;
        this.semesterFactory = semesterFactory;
        this.archiveFactory = archiveFactory;
        this.entityGateway = entityGateway;
    }

    public void execute(AddAccountRequest request) {
        if (entityGateway.existsAccount(request.username)) {
            throw new UsernameAlreadyInUseError(request.username);
        }
        Account account = accountFactory.createAccount();
        setFields(account, request);
        entityGateway.saveAccount(account);
    }

    private void setFields(Account account, AddAccountRequest request) {
        account.setUsername(request.username);
        account.setPassword(request.password);
        account.setSemester(semesterFactory.createSemester());
        account.setArchive(archiveFactory.createArchive());
    }
}
