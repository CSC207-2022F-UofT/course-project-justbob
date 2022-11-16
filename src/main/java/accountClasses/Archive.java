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
    public Archive() {
        this.archived = new ArrayList<Course>();
    }

    public void updateGpa() {
        //Calculate the current CGPA in the archive and store the value in pastGpa
        this.pastGpa = //call cgpa calculator
    }

    public CGPA getPastGpa() {
        // Show the calculated pastGpa
        return pastGpa;
    }

    public List<Course> getArchived() {
        return archived;
    }

    public void addArchivedCourse(Course course) {
        //Add given course to archived
        if (course.isArchived()) {
            System.out.println("Course already in archive");
            //report to controller
        } else {
            archived.add(course);
            course.archiveCourse();
            //report to controller
        }
    }
}

