package usecases.account.ViewSemester;

import entities.account.Account;
import entities.course.Course;
import entities.gpa.GPACalculation;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.viewSemester.ViewSemesterInputBoundary;
import ports.usecases.account.viewSemester.ViewSemesterRequest;
import ports.usecases.account.viewSemester.ViewSemesterResponse;
import usecases.gpaTrend.GetAccountTrendUseCase;

import java.util.ArrayList;
import java.util.List;

public class ViewSemesterUseCase implements ViewSemesterInputBoundary {

    private final EntityGateway entityGateway;

    public ViewSemesterUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public ViewSemesterResponse execute (ViewSemesterRequest request) {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);

        return createResponse(account);
    }

    private ViewSemesterResponse createResponse(Account account){
        ViewSemesterResponse response = new ViewSemesterResponse();
        response.username = account.getUsername();
        response.semesterTitle = account.getSemester().getTitle();
        List<String> myList = new ArrayList<>();
        for(Course course : account.getSemester().getRunningCourses()){
            myList.add(course.getCourseCode());
        }
        response.courseCodes = myList.toArray(new String[0]);
        List<String> myTitles = new ArrayList<>();
        for(Course course : account.getSemester().getRunningCourses()){
            myTitles.add(course.getCourseName());
        }
        response.courseTitles = myTitles.toArray(new String[0]);
        response.courseGrades = new Double[response.courseCodes.length];
        int index = 0;
        for (Course course : account.getSemester().getRunningCourses()) {
            response.courseGrades[index] = course.getOutline().computeRunningGrade();
            index += 1;
        }
        List<Double> myCredits = new ArrayList<>();
        response.courseCredits = myCredits.toArray(new Double[0]);
        for(Course course : account.getSemester().getRunningCourses()){
            float credit = course.getCredit();
            myCredits.add((double) credit);
        }
        response.runningGPA = Double.toString(GPACalculation.overallGPA(response.courseGrades, response.courseCredits));
        response.trendModel = new GetAccountTrendUseCase(entityGateway).execute(account.getUsername());
        return response;
    }
}