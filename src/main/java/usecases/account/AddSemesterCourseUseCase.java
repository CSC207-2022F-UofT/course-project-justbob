package usecases.account;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseInputBoundary;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseRequest;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseResponse;
import ports.usecases.account.loginAccount.LoginAccountResponse;
import ports.usecases.course.editCourseData.EditCourseDataInputBoundary;
import usecases.gpaTrend.GetAccountTrendUseCase;

import java.util.Arrays;
import java.util.List;

public class AddSemesterCourseUseCase implements AddSemesterCourseInputBoundary {

    private EntityGateway entityGateway;
    private Course.CourseFactory courseFactory;

    public AddSemesterCourseUseCase(Course.CourseFactory courseFactory, EntityGateway entityGateway){
        this.entityGateway = entityGateway;
        this.courseFactory = courseFactory;
    }

    @Override
    public AddSemesterCourseResponse execute(AddSemesterCourseRequest request) throws
            AddSemesterCourseInputBoundary.AddSemesterCourseError, PathNotFoundError {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);

        if (account.getArchive().getCourseByCode(request.courseCode) != null ||
                account.getSemester().getCourseByCode(request.courseCode) != null) {
            throw new AddSemesterCourseError("Course Code must be unique");
        }


        if (request.courseName.length() > 50) {
            throw new AddSemesterCourseError("Course name must be less than 30 characters");
        }

        if (request.courseName.equals("")) {
            throw new AddSemesterCourseError("Course name cannot be empty");
        }


        if (request.credit != 0.5 || request.credit != 1.0) {
            throw new AddSemesterCourseError("Credit must be either 0.5 or 1.0");
        }

        Course course = courseFactory.createCourse();
        course.setCourseCode(request.courseCode);
        course.setCourseName(request.courseName);
        course.setCredit(request.credit);
        account.getSemester().addCourse(course);
        entityGateway.saveAccount(account);
        return createResponse(account);
    }

    private AddSemesterCourseResponse createResponse(Account account) {
        AddSemesterCourseResponse response = new AddSemesterCourseResponse();
        response.courseList = List.of((String[]) account.getSemester().getRunningCourses().stream().map(Course::getCourseCode).toArray());
        return response;
    }
}
