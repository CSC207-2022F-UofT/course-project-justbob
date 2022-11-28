package entities.task;

import entities.assessment.AssessmentInstance;

public class TaskFactory implements TaskFactoryInterface{

    @Override
    public Task create(String courseName, AssessmentInstance assessmentInstance) {
        return new Task(courseName, assessmentInstance);
    }
}
