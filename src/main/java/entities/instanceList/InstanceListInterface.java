package entities.instanceList;

import entities.assessmentInstance.AssessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface InstanceListInterface {
    public void addInstance(String name);

    void removeInstance(int index);

    int getTotalNumberOfInstances();

    int getCurrentNumberOfInstances();

    int getNumberOfCommittedInstances();

    int getNumberOfSubmittedInstances();

    ArrayList<AssessmentInstance> getListOfMarkedInstances();

    double[] getAllMarks();

    double[] getCommittedMarks();

    AssessmentInstance getInstanceData(int index);

    void editInstanceName(int index, String name);

    void editInstanceDate(int index, LocalDate date);

    void editInstanceTime(int index, LocalTime time);

    void editInstanceMark(int index, double mark);

    String toSingular(String pluralTitle);
}
