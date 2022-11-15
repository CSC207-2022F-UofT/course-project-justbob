package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class RunningCourses {
    List<Course> semester;
    Calendar calendar;
    Checklist checklist;
    CGPA semesterGPA;

    public RunningCourses(){
        this.semester = new ArrayList<Course>();
        this.calendar
        this.checklist
    }

    public void addRunningCourse(Course course){
        //Add new course to the current semster
        semester.add(course);
    }
    public void removeRunningCourse(Course course){
        semester.remove(course);
    }

    public CGPA getOverallGpa(){
        //Show the OverallGpa for the current semester
        return semesterGPA;
    }

    public void updateOverallGpa(){
        //Calculate the current Gpa for the semester
        //call gpa calculator
    }
}

