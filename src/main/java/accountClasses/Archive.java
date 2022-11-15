package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<Course> archived;  // List of archived courses, which were completed in the past
    private CGPA pastGpa;   // The combined GPA of all archived courses

    /**
     * Initiate the archive with an empty archived course list
     */
    public Archive(){
        this.archived = new ArrayList<Course>();
    }

    public void updateGpa(){
        //Calculate the current CGPA in the archive and store the value in pastGpa
        this.pastGpa = //call cgpa calculator
    }
    public CGPA getPastGpa(){
        // Show the calculated pastGpa
        return pastGpa;
    }

    public List<Course> getArchived(){
        return archived;
    }

    public void addArchivedCourse(Course course){
        //Add given course to archived
        archived.add(course);
        course.archiveCourse();
    }

    @Override
    public String toString() {
        //An optional method that tells shows the user all the archived courses.
        StringBuilder pastCourses = new StringBuilder();
        for(Course course : archived){
            pastCourses.append(course.toString());
        }
        return pastCourses.toString();
    }
}

