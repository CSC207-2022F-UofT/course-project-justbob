package entities.archive;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Archive implements ArchiveInterface {
    private List<Course> archived;  // List of archived courses, which were completed in the past

    /**
     * Initiate the archive with an empty archived course list
     */
    public Archive() {
        this.archived = new ArrayList<Course>();
    }

    public List<Course> getCourses() {
        return this.archived;
    }

    @Override
    public void addCourse(Course course) {
        archived.add(course);
        course.archiveCourse();
    }
    @Override
    public void RemoveCourse(Course course) {
        if (course.isArchived()) {
            course.unarchiveCourse();
            archived.remove(course);
        }
    }
}

