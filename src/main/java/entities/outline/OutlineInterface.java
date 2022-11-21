package entities.outline;

import entities.assessment.Assessment;

import java.util.ArrayList;

public interface OutlineInterface {

    void addAssessment(Assessment assessment);

    void removeAssessment(Assessment assessment);

    Assessment getAssessment(int index);

    ArrayList<Assessment> getAssessments();

    double getPercentageCompleted();

    int getNumberOfAssessmentInstancesCompleted();

    double getTotalCommmittedWeight();

    double getTotalHypotheticalWeight();

    double computeRunningGrade();

    double computeHypotheticalGrade();

}
