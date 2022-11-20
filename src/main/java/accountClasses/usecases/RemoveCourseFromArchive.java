package accountClasses.usecases;

import courseManager.Course;

import static accountClasses.entities.Archive.archived;

public class RemoveCourseFromArchive {

    public void RemoveCourse(Course course) {
        if (course.isArchived()) {
            course.unarchiveCourse();
            archived.remove(course);
        }
    }
}