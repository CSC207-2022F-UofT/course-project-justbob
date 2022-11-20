package usecases.assessmentOperations;

import entities.assessment.Assessment;

public class SetAssessmentTitle {
    public void setTitle(Assessment assessment, String title) {
         assessment.title = title;
    }
}
