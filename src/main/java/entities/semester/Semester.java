package entities.semester;

import courseManager.Course;

import java.util.List;

public class Semester implements SemesterInterface {
    public static List<Course> semester;
    //Calendar calendar;
    //Checklist checklist;

    /**
     * Creates a new RunningCourses object, where courses of the current semester can be added, as well as a semester
     * calendar and a checklist
     */
    /*public RunningCourses() {
        this.semester = new ArrayList<Course>();
        this.calendar = new Calendar();
        this.checklist = new Checklist();
    } */

    @Override
    public List<Course> getSemester() {
        return semester;
    }

    /*@Override
    * public Calendar getCalendar() {
    *   return calendar
    * }*/

    /*@Override
     * public Checklist getChecklist() {
     *   return checklist
     * }*/
}

