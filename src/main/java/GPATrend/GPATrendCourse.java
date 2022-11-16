package GPATrend;

import courseManager.Assessment;
import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class GPATrendCourse implements GPATrendInterface{
    final private Course course;
    private List<String> assessment_names;
    private List<Double> grades;

    public GPATrendCourse(Course course)
    {
        this.course = course;
    }

    public void calculateGPATrend() {
        List<Assessment> assessments =  this.course.getOutline().getAssessments();
        List<String> assessment_names = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (Assessment assessment: assessments) {
            double[] part_marks = assessment.getInstanceList().getAllMarks();
            double grade = 0;
            for(double part_mark : part_marks) {
                grade += part_mark;
            }
            assessment_names.add(assessment.getTitle());
            grades.add(grade);
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
}