package entities.task;

import entities.assessment.AssessmentInstance;

public abstract class Task{
    public abstract boolean getSubmitted();

    public abstract boolean getCommitted();

    public abstract boolean isHaveMark();

    public abstract boolean isShowDetail();

    public abstract void toShowDetail();

    public abstract void toNotShowDetail();


}
