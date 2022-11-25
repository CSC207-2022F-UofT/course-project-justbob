package gradeTrend;


import entities.account.Account;
import entities.course.Course;
import entities.account.Semester;

import java.util.ArrayList;
import java.util.List;

public class gradeTrendOverall implements gradeTrendInterface {
    final private List<Course> courses;
    private List<String> course_names;
    private List<Double> grades;
    private boolean isHypothetical = false;

    public gradeTrendOverall(List<Course> courses) {
        this.courses = courses;
    }

    public gradeTrendOverall(Semester semester) {
        this.courses = semester.getRunningCourses();
    }

    public gradeTrendOverall(Account account) {
        this.courses = account.getSemester().getRunningCourses();
    }

    public void calculateGPATrend() {
        List<String> course_names = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (Course course : this.courses) {
            double grade;
            if (this.isHypothetical) {
                grade = course.getOutline().computeHypotheticalGrade();
            }
            else {
                grade = course.getOutline().computeRunningGrade();
            }
            course_names.add(course.getCourseCode());
            grades.add(grade);
        }
        this.course_names = course_names;
        this.grades = grades;
    }

    public List<String> getXData() {
        return this.course_names;
    }

    public List<Double> getYData() {
        return this.grades;
    }

    public boolean addCourse(Course course)
    {
        if(!this.courses.contains(course)) {
            this.courses.add(course);
            return true;
        }
        return false;
    }

    public boolean removeCourse(Course course)
    {
        if (this.courses.contains(course)) {
            this.courses.remove(course);
            return true;
        }
        return false;
    }

    public void setHypothetical(boolean value) {
        this.isHypothetical = value;
    }

    @Override
    public String toString() {
        String name = "Overall Grades";
        if (this.isHypothetical) {
            name += " - Hypothetical";
        }
        return name;
    }
}
