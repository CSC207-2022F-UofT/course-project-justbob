package entities.instanceList;

import entities.assessmentInstance.AssessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class InstanceList implements InstanceListInterface{
    private ArrayList<AssessmentInstance> listOfAssessmentInstances;
    private int totalNumberOfInstances;

    /**
     * Create a new InstanceList object with a list of AssessmentInstances
     * @param pluralTitle the plural title of the assessment
     *              e.g. "Quizzes", "Midterm", "Homework Assignments"
     * @param totalNumberOfInstances the total number of instances of the assessment
     */

    public InstanceList(String pluralTitle, int totalNumberOfInstances) {
        this.listOfAssessmentInstances = new ArrayList<>();
        this.totalNumberOfInstances = totalNumberOfInstances;
        for (int i = 0, j = 1; i < totalNumberOfInstances; i++, j++){
            this.addInstance(toSingular(pluralTitle) + " #" + j);
        }
    }
    @Override
    public void addInstance(String name) {
        if (getCurrentNumberOfInstances() < totalNumberOfInstances) {
            listOfAssessmentInstances.add(new AssessmentInstance(name));
        }
        else{
            System.out.println("You have reached the maximum number of instances for this assessment");
            /*we could maybe define a new Exception class for this*/
        }
    }

    @Override
    public void removeInstance(int index) {
        listOfAssessmentInstances.remove(index);
    }

    @Override
    public int getTotalNumberOfInstances() {
        return totalNumberOfInstances;
    }

    @Override
    public int getCurrentNumberOfInstances() {
        return listOfAssessmentInstances.size();
    }

    @Override
    public int getNumberOfCommittedInstances() {
        int numberOfCommittedInstances = 0;
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isCommitted()) {
                numberOfCommittedInstances++;
            }
        }
        return numberOfCommittedInstances;
    }

    @Override
    public int getNumberOfSubmittedInstances() {
        int numberOfSubmittedInstances = 0;
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isSubmitted()) {
                numberOfSubmittedInstances++;
            }
        }
        return numberOfSubmittedInstances;
    }

    @Override
    public ArrayList<AssessmentInstance> getListOfMarkedInstances(){
        ArrayList<AssessmentInstance> listOfMarkedInstances = new ArrayList<>();
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.getMark() != null) {
                listOfMarkedInstances.add(instance);
            }
        }
        return listOfMarkedInstances;
    }

    @Override
    public double[] getAllMarks() {
        double[] allMarks = new double[this.getListOfMarkedInstances().size()];
        int i = 0;
        for (AssessmentInstance instance : this.getListOfMarkedInstances()) {
                allMarks[i] = instance.getMark();
                i++;
        }
        return allMarks;
    }

    @Override
    public double[] getCommittedMarks() {
        double[] committedMarks = new double[getNumberOfCommittedInstances()];
        int i = 0;
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isCommitted()) {
                committedMarks[i] = instance.getMark();
                i++;
            }
        }
        return committedMarks;
    }

    @Override
    public AssessmentInstance getInstanceData(int index) throws IndexOutOfBoundsException {
        try {
            return listOfAssessmentInstances.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /*overloaded methods to edit particular data points*/
    /*if there is a more elegant solution to this, feel free to change it! I really don't like this lol*/
    @Override
    public void editInstanceName(int index, String name) {
        listOfAssessmentInstances.get(index).setName(name);
    }

    @Override
    public void editInstanceDate(int index, LocalDate date) {
        listOfAssessmentInstances.get(index).setDueDate(date);
    }

    @Override
    public void editInstanceTime(int index, LocalTime time) {
        listOfAssessmentInstances.get(index).setDueTime(time);
    }

    @Override
    public void editInstanceMark(int index, double mark) {
        listOfAssessmentInstances.get(index).setMark(mark);
    }

    @Override
    public String toSingular(String pluralTitle){
        if (pluralTitle == "Quizzes"){
            return "Quiz";
        }
        if (pluralTitle.charAt(pluralTitle.length()-1) == 's'){
            return pluralTitle.substring(0, pluralTitle.length()-1);
        }
        return pluralTitle;
    }
}