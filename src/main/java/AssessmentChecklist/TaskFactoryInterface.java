package entities.task;

import entities.assessment.AssessmentInstance;

public interface TaskFactoryInterface {
    Task create(String courseName, AssessmentInstance assessmentInstance);
}
