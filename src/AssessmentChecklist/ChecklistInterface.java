package AssessmentChecklist;

import java.util.List;

public interface ChecklistInterface {
    void toShowDetail();

    void toNotShowDetail();

    void toShowPast();

    void  toNotShowPast();

    void addAssessment(Assessment assessment);

    void addAssessments(List<Assessment> assessmentList);

    List<Assessment> getTaskToDo();

    List<Assessment> getTaskFinished();

    List<Assessment> getAllTasks();

    void refresher();

    Assessment findAssessment(String courseName, String name);

    void sortInDdl(List<Assessment> assessmentList);

    void sortInWeight(List<Assessment> assessmentList);

    void sortInContribution(List<Assessment> assessmentList);
}
