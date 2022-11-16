package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class RunningCourses {
    List<Course> semester;
    Calendar calendar;
    Checklist checklist;
    CGPA semesterGPA;

    public RunningCourses() {
        this.semester = new ArrayList<Course>();
        this.calendar = new Calendar();
        this.checklist = new Checklist();
    }

    public void addRunningCourse(Course course) {
        //Add new course to the current semester
        if (semester.contains(course)) {
            System.out.println("Course already in semester");
        } else {
            semester.add(course);
        }
    }

    public void removeRunningCourse(Course course) {
        if(semester.contains(course)){
            semester.remove(course);
        }else{
            System.out.println(course.getCourseCode() + course.getCourseName() + "not found in current semester");
        }
    }

    public CGPA getOverallGpa() {
        //Show the OverallGpa for the current semester
        return semesterGPA;
    }

    public void updateOverallGpa() {
        //Calculate the current Gpa for the semester
        //call gpa calculator
    }
}

