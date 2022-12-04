package usecases.account;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.removeAchiveCourse.RemoveArchiveCourseInputBoundary;

public class RemoveArchiveCourseUseCase implements RemoveArchiveCourseInputBoundary {

    private EntityGateway entityGateway;

    public RemoveArchiveCourseUseCase(EntityGateway entityGateway){
        this.entityGateway = entityGateway;
    }
    @Override
    public void execute(String username, String courseCode) throws PathNotFoundError {

        if (!entityGateway.existsAccount(username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(username);
        Course course = account.getArchive().getCourseByCode(courseCode);
        if (course == null) {
            throw new PathNotFoundError();
        }
        account.getArchive().removeCourse(course);
        entityGateway.saveAccount(account);
    }
}
