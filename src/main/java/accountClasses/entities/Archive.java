package accountClasses.entities;

import accountClasses.entities.ArchiveInterface;
import courseManager.Course;

import java.util.ArrayList;
import java.util.List;

public class Archive implements ArchiveInterface {
    public static List<Course> archived;  // List of archived courses, which were completed in the past

    /**
     * Initiate the archive with an empty archived course list
     */
    public Archive() {
        archived = new ArrayList<Course>();
    }

    @Override
    public List<Course> getCourses() {
        return archived;
    }
}

