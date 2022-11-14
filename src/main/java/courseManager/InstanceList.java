package courseManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class InstanceList {
    private ArrayList<AssessmentInstance> listOfAssessmentInstances;

    private String pluralTitle;
    private String singularTitle;
    private int totalNumberOfInstances;
    private int numberOfCommittedInstances;
    private int numberOfSubmittedInstances;

    /**
     * Create a new InstanceList object with a list of AssessmentInstances
     * @param pluralTitle the plural title of the assessment
     *              e.g. "Quizzes", "Midterm", "Homework Assignments"
     * @param totalNumberOfInstances the total number of instances of the assessment
     */

    public InstanceList(String pluralTitle, int totalNumberOfInstances) {
        this.listOfAssessmentInstances = new ArrayList<>();
        this.singularTitle = toSingular(pluralTitle);
        for (int i = 0, j = 1; i < totalNumberOfInstances; i++, j++){
            this.addInstance(this.singularTitle + " #" + j);
        }
    }

    public String toSingular(String pluralTitle){
        if (pluralTitle == "Quizzes"){
            return "Quiz";
        }
        if (pluralTitle.charAt(pluralTitle.length()-1) == 's'){
            return singularTitle.substring(0, pluralTitle.length()-1);
        }
        return singularTitle;
    }

    public int getTotalNumberOfInstances() {
        return totalNumberOfInstances;
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

    public double[] getAllMarks() {
        double[] allMarks = new double[totalNumberOfInstances];
        for (int i = 0; i < totalNumberOfInstances; i++) {
            allMarks[i] = listOfAssessmentInstances.get(i).getMark();
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

    public void addInstance(String name) {
        AssessmentInstance instance = new AssessmentInstance(name);
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