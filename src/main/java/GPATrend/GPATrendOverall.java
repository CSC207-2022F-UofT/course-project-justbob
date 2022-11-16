package GPATrend;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class GPATrendOverall implements GPATrendInterface{
    final private List<Course> courses;
    private List<String> course_names;
    private List<Double> grades;

    public GPATrendOverall(List<Course> courses)
    {
        this.courses = courses;
    }
    /* public GPATrendOverall(Account account) {
        this.courses = account.getRunningCourses();
    }*/

    public void calculateGPATrend()
    {
        List<String> course_names = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (Course course : this.courses) {
            double grade = course.getOutline().getRunningGrade();
            course_names.add(course.getCourseName());
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
        if(this.courses.contains(course)) {
            this.courses.remove(course);
            return true;
        }
        return false;
    }
}
