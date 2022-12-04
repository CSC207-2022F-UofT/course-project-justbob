package usecases.account;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.setCourseMetaData.SetCourseMetaDataInputBoundary;
import ports.usecases.account.setCourseMetaData.SetCourseMetaDataRequest;
import ports.usecases.account.setCourseMetaData.SetCourseMetaDataResponse;

public class SetCourseMetaDataUseCase {

    private EntityGateway entityGateway;

    public SetCourseMetaDataUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public SetCourseMetaDataResponse execute(SetCourseMetaDataRequest request)
    throws ports.usecases.PathNotFoundError, SetCourseMetaDataInputBoundary.SetCourseMetaDataError {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

        if (course == null) {
            throw new PathNotFoundError();
        }

        if (request.newCourseCode.length() != 6) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Course code must be 6 characters long");
            }

        if (request.newCourseCode.equals(course.getCourseCode())) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Course code must be different from previous course code");
            }
        if (account.getArchive().getCourseByCode(request.newCourseCode) != null ||
                    account.getSemester().getCourseByCode(request.newCourseCode) != null) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Course code must be unique");
            }


        if (request.newCourseName.length() > 50) {
             throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Course name must be less than 30 characters");
        }

        if (request.newCourseName.equals(course.getCourseName())) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Course name must be different from previous course name");
            }

        if (request.newCourseName.equals("")) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Course name cannot be empty");
            }


        if (request.newCredit != 0.5 || request.newCredit != 1.0) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Credit must be either 0.5 or 1.0");
        }

        if (request.newCredit == course.getCredit()) {
            throw new SetCourseMetaDataInputBoundary.SetCourseMetaDataError("Credit must be different from previous credit");
        }

        course.setCourseCode(request.newCourseCode);
        course.setCourseName(request.newCourseName);
        course.setCredit(request.newCredit);

        entityGateway.saveAccount(account);

        return createResponse(course);
    }

    private SetCourseMetaDataResponse createResponse(Course course) {
        SetCourseMetaDataResponse response = new SetCourseMetaDataResponse();
        response.newCourseCode = course.getCourseCode();
        response.newCourseName = course.getCourseName();
        response.newCredit = course.getCredit();
        return response;
    }

}
