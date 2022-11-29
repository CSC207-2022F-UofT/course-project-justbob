package usecases.account;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.removeAccount.RemoveCourseInputBoundary;

public class RemoveArchiveCourseUseCase implements RemoveCourseInputBoundary {

    private EntityGateway entityGateway;

    public RemoveArchiveCourseUseCase(EntityGateway entityGateway){
        this.entityGateway = entityGateway;
    }
    @Override
    public void execute(String username, Course course){
        Account account = entityGateway.loadAccount(username);
        account.getArchive().RemoveCourse(course);
    }
}
