package accountClasses;

import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private static List<Course> archived;  // List of archived courses, which were completed in the past

    /**
     * Initiate the archive with an empty archived course list
     */
    public Archive() {
        this.archived = new ArrayList<Course>();
    }

    public static List<Course> getArchived() {
        return archived;
    }

    public void addArchivedCourse(Course course) { //this part still needs modification
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

