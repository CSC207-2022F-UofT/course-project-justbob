package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class RunningCourses {
    static List<Course> semester;
    //Calendar calendar;
    //Checklist checklist;

    /**
     * Creates a new RunningCourses object, where courses of the current semester can be added, as well as a semester
     * calendar, a checklist, and a semester GPA.
     */
    /*public RunningCourses() {
        this.semester = new ArrayList<Course>();
        this.calendar = new Calendar();
        this.checklist = new Checklist();
    } */

    public static void addRunningCourse(Course course) {
        //Add new course to the current semester
        if (semester.contains(course)) {
            System.out.println("Course already in semester");
            //report to controller
        } else {
            semester.add(course);
            //report to controller
        }
    }

    public static void removeRunningCourse(Course course) {
        if(semester.contains(course)){
            semester.remove(course);
        }else{
            System.out.println(course.getCourseCode() + course.getCourseName() + "not found in current semester");
        }
    }
}

