package usecases;

import courseManager.Course;

import static entities.archive.Archive.archived;

public class AddCourseToArchive {

    public void addArchivedCourse(Course course) {
        archived.add(course);
        course.archived = true;
    }
}
