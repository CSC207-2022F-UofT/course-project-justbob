package entities.semester;

import entities.course.Course;

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

    public static void addCourse(Course course) {
        //Add new course to the current semester
        if (semester.contains(course)) {
            System.out.println("Course already in semester");
            //report to controller
        } else {
            semester.add(course);
        }
    }

    public static void removeCourse(Course course) {
        semester.remove(course);
    }
}

