package usecases.account;

import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseInputBoundary;
import ports.usecases.account.addSemesterCourse.AddSemesterCourseRequest;

public class AddSemesterCourseUseCase implements AddSemesterCourseInputBoundary {

    private EntityGateway entityGateway;
    private Course.CourseFactory courseFactory;



    @Override
    public void execute(AddSemesterCourseRequest request) {

    }
}
