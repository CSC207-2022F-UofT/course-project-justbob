package inMemoryDB.entities;

import entities.assessment.Assessment;
import entities.course.Outline;

import java.util.ArrayList;

public class OutlineImpl extends Outline {

    private final ArrayList<Assessment> assessments = new ArrayList<>();

    @Override
    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    @Override
    public ArrayList<String> getAssessmentsTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (Assessment assessment : assessments) {
            titles.add(assessment.getTitle());
        }
        return titles;
    }

    @Override
    public int getIndexByTitle(String assessmentTitle){
        int index = 0;
        for (Assessment assessment : assessments) {
            if (assessment.getTitle().equals(assessmentTitle)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Assessment getAssessmentByTitle(String assessmentTitle){
        for (Assessment assessment : assessments) {
            if (assessment.getTitle().equals(assessmentTitle)) {
                return assessment;
            }
        }
        return null;
    }

    // TODO: should assessments be added if their weight sums over 100%?
    @Override
    public void addAssessment(Assessment assessment) {
        if (!assessments.contains(assessment)) {
            assessments.add(assessment);
        }
    }

    @Override
    public void removeAssessment(Assessment assessment) {
        assessments.remove(assessment);
    }

    @Override
    public Assessment getAssessment(int index) throws IndexOutOfBoundsException {
        try {
            return assessments.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
