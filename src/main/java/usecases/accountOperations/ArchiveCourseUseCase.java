package usecases.accountOperations;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.archiveCourse.ArchiveCourseInputBoundary;

public class ArchiveCourseUseCase implements ArchiveCourseInputBoundary {
    private EntityGateway entityGateway;

    public ArchiveCourseUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public void execute(String username, String courseCode) throws PathNotFoundError, CourseNotCompletedError {
        // TODO: Abstractify the path verification process
        if (!entityGateway.existsAccount(username)) {
            // TODO: specify (first implement PathNotFoundError's TODO.
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(username);
        Course course = account.getSemester().getCourseByCode(courseCode);
        if (course == null) {
            // TODO: specify
            throw new PathNotFoundError();
        }

        if (course.getOutline().getPercentageCompleted() < 1.0) {
            throw new CourseNotCompletedError();
        }
        account.getSemester().removeCourse(course);
        account.getArchive().addCourse(course, account.getSemester().getTitle());
    }
}
