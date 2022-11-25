package entities.account;

import entities.course.Course;

import java.time.LocalDate;
import java.util.List;

public abstract class Archive {
    public class ArchivedCourseData {
        private String semester;
        private LocalDate dateArchived;

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public LocalDate getDateArchived() {
            return dateArchived;
        }

        public void setDateArchived(LocalDate dateArchived) {
            this.dateArchived = dateArchived;
        }
    }

    public abstract List<Course> getCourses();
    public abstract ArchivedCourseData getArchivedCourseData(Course course);

    /**
     * add a course to this archive. This operation will be recorded in terms of the date given by the system clock.
     * @param course the course to archive
     * @param semester the semester the course was a part of
     */
    public abstract void addCourse(Course course, String semester);

    /**
     * add a course to this archive. This operation will be recorded in terms of the date given by the system clock.
     * @param course the course to archive
     */
    public abstract void addCourse(Course course);

    /**
     * remove a course and its archive data from this archive.
     * @param course the course to remove
     */
    public abstract void RemoveCourse(Course course);

    public interface ArchiveFactory {
        Archive createArchive();
    }
}

