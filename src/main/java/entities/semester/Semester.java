package entities.semester;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Semester{
    public List<Course> semester;
    //Calendar calendar;
    //Checklist checklist;

    /**
     * Creates a new RunningCourses object, where courses of the current semester can be added, as well as a semester
     * calendar and a checklist
     */
    public Semester() {
        this.semester = new ArrayList<Course>();
       // this.calendar = new Calendar();
       // this.checklist = new Checklist();
    }

    public List<Course> getSemester() {
        return this.semester;
    }

    /*@Override
    * public Calendar getCalendar() {
    *   return calendar
    * }*/

    /*@Override
     * public Checklist getChecklist() {
     *   return checklist
     * }*/

    public void addCourse(Course course) {
        //Add new course to the current semester
        if (this.semester.contains(course)) {
            throw new IllegalArgumentException("Course already in semester");
            //report to controller
        } else {
            this.semester.add(course);
        }
    }

    public void removeCourse(Course course) {
        semester.remove(course);
    }
}

