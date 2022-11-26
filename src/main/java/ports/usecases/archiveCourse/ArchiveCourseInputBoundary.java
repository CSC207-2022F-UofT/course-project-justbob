package ports.usecases.archiveCourse;

import ports.usecases.PathNotFoundError;

public interface ArchiveCourseInputBoundary {
    void execute(String username, String courseCode) throws PathNotFoundError, CourseNotCompletedError;

    class CourseNotCompletedError extends Error {}
}
