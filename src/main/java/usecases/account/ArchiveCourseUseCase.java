package usecases.account;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.archiveCourse.ArchiveCourseInputBoundary;

//TODO: implement testing
public class ArchiveCourseUseCase implements ArchiveCourseInputBoundary {
    private final EntityGateway entityGateway;

    public ArchiveCourseUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public void execute(String username, String courseCode) throws PathNotFoundError, CourseNotCompletedError {
        if (!entityGateway.existsAccount(username)) {
            throw new PathNotFoundError("Username: " + username);
        }
        Account account = entityGateway.loadAccount(username);
        Course course = account.getSemester().getCourseByCode(courseCode);
        if (course == null) {
            throw new PathNotFoundError("Course: " + courseCode);
        }
        if (course.getOutline().getPercentageCompleted() < 1.0) {
            throw new CourseNotCompletedError();
        }
        account.getSemester().removeCourse(course);
        account.getArchive().addCourse(course, account.getSemester().getTitle());
    }
}
