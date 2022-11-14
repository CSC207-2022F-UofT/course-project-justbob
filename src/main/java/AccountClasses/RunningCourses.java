package AccountClasses;

import java.util.ArrayList;

public class RunningCourses {
    List<Course> runningCourses = new ArrayList<Course>();
    Calendar calendar;
    Checklist checklist;
    CGPA semesterGPA;

    public RunningCourses(){
    }

    public void addRunningCourse(Course course){
        runningCourses.add(course);
    }
    public void removeRunningCourse(Course course){
        runningCourses.remove(course);
    }
    public List<Double> getGradesList(){

    }
    public CGPA getOverallGpa(){
        return /**call CGPA calculator**/
    }
}

