package usecases.gpaTrend;

import entities.account.Account;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.gpaTrend.TrendModel;
import ports.usecases.gpaTrend.getAccountTrend.GetAccountTrendInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class GetAccountTrendUseCase implements GetAccountTrendInputBoundary {
    private EntityGateway entityGateway;

    public GetAccountTrendUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public TrendModel execute(String username) {
        // TODO: Abstractify the path verification process
        if (!entityGateway.existsAccount(username)) {
            // TODO: specify (first implement PathNotFoundError's TODO.
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(username);
        return calculateTrend(account);
    }

    private TrendModel calculateTrend(Account account) {
        List<String> course_names = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (Course course : account.getSemester().getRunningCourses()) {
            double grade = course.getOutline().computeRunningGrade();
            course_names.add(course.getCourseCode());
            grades.add(grade);
        }
        return new TrendModel(course_names, grades);
    }
}
