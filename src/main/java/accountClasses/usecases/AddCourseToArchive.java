package accountClasses.usecases;

import courseManager.Course;

import static accountClasses.entities.Archive.archived;

public class AddCourseToArchive {

    public void addArchivedCourse(Course course) {
        archived.add(course);
        course.archived = true;
    }
}
