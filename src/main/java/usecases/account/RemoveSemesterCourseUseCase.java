package usecases.account;

import entities.account.Account;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.RemoveSemesterCourse.RemoveSemesterCourseInputBoundary;
import ports.usecases.account.RemoveSemesterCourse.RemoveSemesterCourseRequest;

public class RemoveSemesterCourseUseCase implements RemoveSemesterCourseInputBoundary {

    private EntityGateway entityGateway;

    public RemoveSemesterCourseUseCase(EntityGateway entityGateway){
        this.entityGateway = entityGateway;
    }

    @Override
    public void execute(RemoveSemesterCourseRequest request) throws CourseDoesNotExistsError {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);
        if((account.getSemester().getCourseByCode(request.courseCode) == null)){
            throw new RemoveSemesterCourseInputBoundary.CourseDoesNotExistsError();
        }
        account.getSemester().removeCourse(account.getSemester().getCourseByCode(request.courseCode));
        entityGateway.saveAccount(account);
    }
}
