package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class RunningCourses {
    List<Course> semester;
    Calendar calendar;
    Checklist checklist;
    CGPA semesterGPA;

    /**
     * Creates a new RunningCourses object, where courses of the current semester can be added, as well as a semester
     * calendar, a checklist, and a semester GPA.
     */
    public RunningCourses() {
        this.semester = new ArrayList<Course>();
        this.calendar = new Calendar();
        this.checklist = new Checklist();
    }

    public void addRunningCourse(Course course) {
        //Add new course to the current semester
        if (semester.contains(course)) {
            System.out.println("Course already in semester");
            //report to controller
        } else {
            semester.add(course);
            //report to controller
        }
    }

    public void removeRunningCourse(Course course) {
        if(semester.contains(course)){
            semester.remove(course);
            //report to controller
        }else{
            System.out.println(course.getCourseCode() + course.getCourseName() + "not found in current semester");
            //report to controller
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

