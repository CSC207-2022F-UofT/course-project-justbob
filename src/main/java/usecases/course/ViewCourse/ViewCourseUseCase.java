package usecases.course.ViewCourse;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.course.viewCourse.ViewCourseInputBoundary;
import ports.usecases.course.viewCourse.ViewCourseRequest;
import ports.usecases.course.viewCourse.ViewCourseResponse;

public class ViewCourseUseCase implements ViewCourseInputBoundary {

    private final EntityGateway entityGateway;

    public ViewCourseUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;}

    public ViewCourseResponse execute(ViewCourseRequest request) {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);
        System.out.println(request.courseCode);
        Course course = account.getSemester().getCourseByCode(request.courseCode);
        if (course == null) {
            throw new PathNotFoundError();
        }
        return createResponse(course);
    }

    private ViewCourseResponse createResponse(Course course) {
        ViewCourseResponse response = new ViewCourseResponse();
        response.courseCode = course.getCourseCode();
        response.courseTitle = course.getCourseName();
        response.credit = Float.toString(course.getCredit());
        response.assessmentTitles = new String[course.getOutline().getAssessmentsTitles().size()];
        response.assessmentTitles = course.getOutline().getAssessmentsTitles().toArray(response.assessmentTitles);
        response.assessmentNumberOfInstances = new Integer[course.getOutline().getAssessmentsNumberOfInstances().size()];
        response.assessmentNumberOfInstances = course.getOutline().getAssessmentsNumberOfInstances().toArray(response.assessmentNumberOfInstances);
        response.assessmentWeights = new Double[course.getOutline().getAssessmentsWeights().size()];
        response.assessmentWeights = course.getOutline().getAssessmentsWeights().toArray(response.assessmentWeights);
        return response;
    }


}
