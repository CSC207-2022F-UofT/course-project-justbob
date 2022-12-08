package usecases.account.ViewArchive;

import entities.account.Account;
import entities.course.Course;
import entities.gpa.GPACalculation;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.account.ViewArchive.ViewArchiveInputBoundary;
import ports.usecases.account.ViewArchive.ViewArchiveRequest;
import ports.usecases.account.ViewArchive.ViewArchiveResponse;
import ports.usecases.account.viewSemester.ViewSemesterInputBoundary;
import ports.usecases.account.viewSemester.ViewSemesterResponse;
import usecases.account.ViewSemester.ViewSemesterUseCase;

import java.util.ArrayList;
import java.util.List;

public class ViewArchiveUseCase implements ViewArchiveInputBoundary {

    private final EntityGateway entityGateway;

    public ViewArchiveUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public ViewArchiveResponse execute (ViewArchiveRequest request) {
        if (!entityGateway.existsAccount(request.username)) {
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(request.username);
        return createResponse(account);
    }

    private ViewArchiveResponse createResponse(Account account) {
        ViewArchiveResponse response = new ViewArchiveResponse();
        response.username = account.getUsername();
        List<String> myList = new ArrayList<>();
        for(Course course : account.getArchive().getCourses()){
            myList.add(course.getCourseCode());
        }
        response.courseCodes = myList.toArray(new String[0]);
        List<String> myTitles = new ArrayList<>();
        for(Course course : account.getArchive().getCourses()){
            myTitles.add(course.getCourseName());
        }
        response.courseTitles = myTitles.toArray(new String[0]);
        int index = 0;
        for (Course course : account.getArchive().getCourses()) {
            response.courseGrades[index] = Math.round(course.getOutline().computeRunningGrade() * 100.0) / 100.0;
            index += 1;
        }

        List<Double> myCredits = new ArrayList<>();
        for (Course course : account.getArchive().getCourses()) {
            float credit = course.getCredit();
            myCredits.add((double) credit);
        }
        response.courseCredits = myCredits.toArray(new Double[0]);
        response.cGPA = Double.toString(GPACalculation.overallGPA(response.courseGrades, response.courseCredits));
        return response;
    }



}
