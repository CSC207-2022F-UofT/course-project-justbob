package usecases.gpaTrend;

import entities.account.Account;
import entities.assessment.Assessment;
import entities.course.Course;
import ports.database.EntityGateway;
import ports.usecases.PathNotFoundError;
import ports.usecases.gpaTrend.TrendModel;
import ports.usecases.gpaTrend.getCourseTrend.GetCourseTrendInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class GetCourseTrendUseCase implements GetCourseTrendInputBoundary {
    private EntityGateway entityGateway;

    public GetCourseTrendUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    @Override
    public TrendModel execute(String username, String courseCode) {
        // TODO: Abstractify the path verification process
        if (!entityGateway.existsAccount(username)) {
            // TODO: specify (first implement PathNotFoundError's TODO.
            throw new PathNotFoundError();
        }
        Account account = entityGateway.loadAccount(username);
        Course course = account.getSemester().getCourseByCode(courseCode);
        if (course == null) {
            // TODO: specify
            throw new PathNotFoundError();
        }

        // TODO: test edge cases (especially when certain fields are empty (assessment, instance...)
        return calculateTrend(course);
    }

    // TODO: add the ability to use instances rather than assessments.
    private TrendModel calculateTrend(Course course) {
        List<Assessment> assessments =  course.getOutline().getAssessments();
        List<String> assessment_names = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (Assessment assessment: assessments) {
            double[] part_marks = assessment.getCommittedMarks();
            double grade = 0;
            for(double part_mark : part_marks) {
                grade += part_mark;
            }
            assessment_names.add(assessment.getTitle());
            //TODO: division by zero error is possible here.
            grades.add(grade / part_marks.length);  // Average
        }
        return new TrendModel(assessment_names, grades);
    }
}
