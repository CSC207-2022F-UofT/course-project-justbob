package gradeTrend;


import entities.assessment.Assessment;
import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class gradeTrendCourse implements gradeTrendInterface {
    final private Course course;
    private List<String> assessment_names;
    private List<Double> grades;
    private boolean isHypothetical = false;

    public gradeTrendCourse(Course course) {
        this.course = course;
    }

    public void calculateGPATrend() {
        List<Assessment> assessments =  this.course.getOutline().getAssessments();
        List<String> assessment_names = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (Assessment assessment: assessments) {
            double[] part_marks;
            if(this.isHypothetical) {
                part_marks = assessment.getAllMarks();
            } else {
                part_marks = assessment.getCommittedMarks();
            }
            double grade = 0;
            for(double part_mark : part_marks) {
                grade += part_mark;
            }
            assessment_names.add(assessment.getTitle());
            grades.add(grade / part_marks.length);  // Average
        }
        this.assessment_names = assessment_names;
        this.grades = grades;
    }

    public List<String> getXData() {
        return this.assessment_names;
    }

    public List<Double> getYData() {
        return this.grades;
    }

    public void setHypothetical(boolean value) {
        this.isHypothetical = value;
    }

    @Override
    public String toString() {
        String name = this.course.getCourseCode() + " Grades";
        if (this.isHypothetical) {
            name += " - Hypothetical";
        }
        return name;
    }
}
