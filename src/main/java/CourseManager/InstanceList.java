package CourseManager;

import java.time.LocalDate;
import java.util.ArrayList;

public class InstanceList {
    private ArrayList<AssessmentInstance> listOfAssessmentInstances;

    private int totalNumberOfInstances;
    private int numberOfCommittedInstances;
    private int numberOfSubmittedInstances;

    /**
     * Create a new InstanceList object with an empty list of AssessmentInstances
     */

    public InstanceList() {
        this.listOfAssessmentInstances = new ArrayList<>();
        this.totalNumberOfInstances = 0;
        this.numberOfCommittedInstances = 0;
        this.numberOfSubmittedInstances = 0;
    }

    public int getTotalNumberOfInstances() {
        return totalNumberOfInstances;
    }

    public int getNumberOfCommittedInstances() {
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isCommitted()) {
                numberOfCommittedInstances++;
            }
        }
        return numberOfCommittedInstances;
    }

    public int getNumberOfSubmittedInstances() {
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isSubmitted()) {
                numberOfSubmittedInstances++;
            }
        }
        return numberOfSubmittedInstances;
    }

    public void addInstance(String name, LocalDate date) {
        AssessmentInstance instance = new AssessmentInstance(name, date);
        listOfAssessmentInstances.add(instance);
        totalNumberOfInstances++;
    }

    public void removeInstance(int index) {
        if (listOfAssessmentInstances.get(index).isCommitted()) {
            numberOfCommittedInstances--;
        }
        if (listOfAssessmentInstances.get(index).isSubmitted()) {
            numberOfSubmittedInstances--;
        }
        listOfAssessmentInstances.remove(index);
        totalNumberOfInstances--;
    }

    public AssessmentInstance getInstanceData(int index) {
        return listOfAssessmentInstances.get(index);
    }

    /*overloaded methods to edit particular data points*/
    /*if there is a more elegant solution to this, feel free to change it! I really don't like this lol*/
    public void editInstance(int index, String name) {
        listOfAssessmentInstances.get(index).setName(name);
    }

    public void editInstance(int index, LocalDate date) {
        listOfAssessmentInstances.get(index).setDate(date);
    }

    public void editInstance(int index, double mark) {
        listOfAssessmentInstances.get(index).setMark(mark);
    }

    public void editInstance(int index, String name, LocalDate date) {
        listOfAssessmentInstances.get(index).setName(name);
        listOfAssessmentInstances.get(index).setDate(date);
    }

    public void editInstance(int index, LocalDate date, double mark) {
        listOfAssessmentInstances.get(index).setDate(date);
        listOfAssessmentInstances.get(index).setMark(mark);
    }

    public void editInstance(int index, String name, double mark) {
        listOfAssessmentInstances.get(index).setName(name);
        listOfAssessmentInstances.get(index).setMark(mark);
    }

    public void editInstance(int index, String name, LocalDate date, double mark) {
        listOfAssessmentInstances.get(index).setName(name);
        listOfAssessmentInstances.get(index).setDate(date);
        listOfAssessmentInstances.get(index).setMark(mark);
    }


}
