package entities.archive;

import entities.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Archive {
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

    public void addCourse(Course course) {
        this.archived.add(course);
        course.archiveCourse();
    }
    public void RemoveCourse(Course course) {
            course.unarchiveCourse();
            this.archived.remove(course);
        }
}

