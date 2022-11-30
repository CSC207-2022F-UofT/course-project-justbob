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
