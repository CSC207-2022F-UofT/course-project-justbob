package entities.assessment.instanceList;

import entities.assessment.assessmentInstance.AssessmentInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public abstract class InstanceList {
    private ArrayList<AssessmentInstance> listOfAssessmentInstances;
    private int totalNumberOfInstances;


    public InstanceList(int totalNumberOfInstances) {
        this.listOfAssessmentInstances = new ArrayList<>();
        this.totalNumberOfInstances = totalNumberOfInstances;
    }

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

    public void addInstance(String name) {
        if (getCurrentNumberOfInstances() < totalNumberOfInstances) {
            listOfAssessmentInstances.add(new AssessmentInstance(name));
        } else{
            throw new IllegalStateException("this assessment already has all instance defined");
            //System.out.println("You have reached the maximum number of instances for this assessment");
            /*we could maybe define a new Exception class for this*/
        }
    }

    public void addInstance(AssessmentInstance instance) {
        if (getCurrentNumberOfInstances() < totalNumberOfInstances) {
            listOfAssessmentInstances.add(instance);
        } else {
            throw new IllegalStateException("this assessment already has all instances defined");
        }
    }

    public void removeInstance(int index) {
        listOfAssessmentInstances.remove(index);
    }

    public int getTotalNumberOfInstances() {
        return totalNumberOfInstances;
    }

    public int getCurrentNumberOfInstances() {
        return listOfAssessmentInstances.size();
    }

    public int getNumberOfCommittedInstances() {
        int numberOfCommittedInstances = 0;
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isCommitted()) {
                numberOfCommittedInstances++;
            }
        }
        return numberOfCommittedInstances;
    }

    public int getNumberOfSubmittedInstances() {
        int numberOfSubmittedInstances = 0;
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.isSubmitted()) {
                numberOfSubmittedInstances++;
            }
        }
        return numberOfSubmittedInstances;
    }

    public ArrayList<AssessmentInstance> getListOfMarkedInstances(){
        ArrayList<AssessmentInstance> listOfMarkedInstances = new ArrayList<>();
        for (AssessmentInstance instance : listOfAssessmentInstances) {
            if (instance.getMark() != null) {
                listOfMarkedInstances.add(instance);
            }
        }
        return listOfMarkedInstances;
    }

    public double[] getAllMarks() {
        double[] allMarks = new double[this.getListOfMarkedInstances().size()];
        int i = 0;
        for (AssessmentInstance instance : this.getListOfMarkedInstances()) {
                allMarks[i] = instance.getMark();
                i++;
        }
        return allMarks;
    }

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

    public AssessmentInstance getInstanceData(int index) throws IndexOutOfBoundsException {
        try {
            return listOfAssessmentInstances.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /*overloaded methods to edit particular data points*/
    /*if there is a more elegant solution to this, feel free to change it! I really don't like this lol*/
    public void editInstanceName(int index, String name) {
        listOfAssessmentInstances.get(index).setName(name);
    }

    public void editInstanceDate(int index, LocalDate date) {
        listOfAssessmentInstances.get(index).setDueDate(date);
    }

    public void editInstanceTime(int index, LocalTime time) {
        listOfAssessmentInstances.get(index).setDueTime(time);
    }

    public void editInstanceMark(int index, double mark) {
        listOfAssessmentInstances.get(index).setMark(mark);
    }

    private static String toSingular(String pluralTitle){
        if (pluralTitle == "Quizzes"){
            return "Quiz";
        }
        if (pluralTitle.charAt(pluralTitle.length()-1) == 's'){
            return pluralTitle.substring(0, pluralTitle.length()-1);
        }
        return pluralTitle;
    }
}