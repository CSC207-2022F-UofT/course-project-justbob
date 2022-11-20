package usecases.courseOperations;

import entities.course.Course;

import static entities.archive.Archive.archived;

public class RemoveCourseFromArchive {

    public void RemoveCourse(Course course) {
        if (course.isArchived()) {
            course.archived = false;
            archived.remove(course);
        }
    }
}