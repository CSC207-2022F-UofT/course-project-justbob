package AccountClasses;

import java.util.ArrayList;

public class RunningCourses {
    List<Course> runningCourses = new ArrayList<Course>();
    Calendar calendar;
    Checklist checklist;
    GPATrendOverall semesterGPA;

    public RunningCourses(){}

    public void addRunningCourse(Course course){
        runningCourses.add(course);
    }
    public void removeRunningCourse(Course course){
        runningCourses.remove(course);
    }
}

