package usecases.account;

import entities.account.Account;
import entities.course.Course;
import entities.course.CourseEvent;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.addCourseEvent.AddCourseEventRequest;
import ports.usecases.account.addCourseEvent.AddCourseEventResponse;

public class AddCourseEventUseCase {

    private EntityGateway entityGateway;

    public AddCourseEventUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public AddCourseEventResponse execute(AddCourseEventRequest request) {

        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }

        Account account = entityGateway.loadAccount(request.username);
        Course course = account.getSemester().getCourseByCode(request.courseCode);

        if (course == null) {
            throw new PathNotFoundError();
        }
        CourseEvent courseEvent = new CourseEvent(request.eventTitle, request.day, request.startTime, request.endTime, request.location);
        course.addCourseEvent(courseEvent);

        entityGateway.saveAccount(account);

        return createResponse(courseEvent);
    }

    private AddCourseEventResponse createResponse(CourseEvent courseEvent) {
        AddCourseEventResponse response = new AddCourseEventResponse();
        response.eventTitle = courseEvent.getTitle();
        response.day = courseEvent.getDay();
        response.startTime = courseEvent.getStartTime();
        response.endTime = courseEvent.getEndTime();
        response.location = courseEvent.getLocation();
        return response;
    }
}
