package AssessmentChecklist;

import java.util.List;

public interface ChecklistInterface {
    void toShowDetail();

    void toNotShowDetail();

    void toShowPast();

    void  toNotShowPast();

    void addAssessmentCl(AssessmentCl assessmentCl);

    void addAssessmentCls(List<AssessmentCl> assessmentClList);

    List<AssessmentCl> getTaskToDo();

    List<AssessmentCl> getTaskFinished();

    List<AssessmentCl> getAllTasks();

    void refresher();

    AssessmentCl findAssessmentCl(String courseName, String name);

    void sortInDdl(List<AssessmentCl> assessmentClList);

    void sortInWeight(List<AssessmentCl> assessmentClList);

    void sortInContribution(List<AssessmentCl> assessmentClList);
}
