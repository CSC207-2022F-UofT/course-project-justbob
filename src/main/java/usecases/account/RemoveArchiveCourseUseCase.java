package usecases.account;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.archiveCourse.ArchiveCourseInputBoundary;
import ports.usecases.account.removeAccount.RemoveCourseInputBoundary;

public class RemoveArchiveCourseUseCase implements RemoveCourseInputBoundary {

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
        account.getArchive().addCourse(course, account.getSemester().getTitle());
    }
}
