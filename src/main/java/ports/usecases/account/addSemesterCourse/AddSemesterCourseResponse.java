package ports.usecases.account.addSemesterCourse;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class AddSemesterCourseResponse {

    public List<String> courseList;

    public AddSemesterCourseResponse(){}

    public AddSemesterCourseResponse(List<String> courses){
        this.courseList = courses;
    }
}
