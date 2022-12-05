package usecases.account.AddSemesterCourse;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseInputBoundary;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseRequest;
import usecases.gpaTrend.GetAccountTrendUseCase;

public class AddSemesterCourseUseCase implements AddSemesterCourseInputBoundary {

    private final EntityGateway entityGateway;
    private final EntityFactory entityFactory;

    public AddSemesterCourseUseCase(EntityGateway entityGateway, EntityFactory entityFactory) {
        this.entityGateway = entityGateway;
        this.entityFactory = entityFactory;
    }

    @Override
    public ApplicationResponse execute(AddSemesterCourseRequest request) {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);
        if (!(account.getSemester().getCourseByCode(request.courseCode) == null)) {
            throw new CourseAlreadyExistsError();
        }
        Course course = entityFactory.createCourse();
        course.setCourseCode(request.courseCode);
        course.setCourseName(request.courseName);
        course.setCredit(request.credit);
        account.getSemester().addCourse(course);
        entityGateway.saveAccount(account);
        return createResponse(account);
    }

    private ApplicationResponse createResponse(Account account) {
        ApplicationResponse response = new ApplicationResponse();
        response.username = account.getUsername();
        response.semesterTitle = account.getSemester().getTitle();
        response.courseCodes = account.getSemester().getRunningCourses().stream()
                .map(Course::getCourseCode)
                .toArray(String[]::new);
        response.courseTitles = account.getSemester().getRunningCourses().stream()
                .map(Course::getCourseName)
                .toArray(String[]::new);
        response.courseGrades = new Double[response.courseCodes.length];
        int index = 0;
        for (Course course : account.getSemester().getRunningCourses()) {
            response.courseGrades[index] = course.getOutline().computeRunningGrade();
            index += 1;
        }
        response.trendModel = new GetAccountTrendUseCase(entityGateway).execute(account.getUsername());
        return response;
    }
}
