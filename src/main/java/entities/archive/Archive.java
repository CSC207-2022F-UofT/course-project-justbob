package entities.archive;

import entities.course.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Archive {
    public class ArchivedCourseData {
        private String semester;
        private LocalDate dateArchived;

        public ArchivedCourseData(String semester, LocalDate dateArchived) {
            this.semester = semester;
            this.dateArchived = dateArchived;
        }

        public String getSemester() {
            return semester;
        }

        public LocalDate getDateArchived() {
            return dateArchived;
        }
    }

    private List<Course> archived;  // List of archived courses, which were completed in the past
    private HashMap<Course, ArchivedCourseData> courseToData;

    /**
     * Initiate the archive with an empty archived course list
     */
    public Archive() {
        courseToData = new HashMap<>();
    }

    public Archive(HashMap<Course, ArchivedCourseData> courseToData) {
        this.courseToData = courseToData;
    }

    public List<Course> getCourses() {
        return List.copyOf(courseToData.keySet());
    }

    public ArchivedCourseData getCourseArchiveData(Course course) {
        return courseToData.get(course);
    }

    /**
     * add a course to this archive. This operation will be recorded in terms of the date given by the system clock.
     * @param course the course to archive
     * @param semester the semester the course was a part of
     */
    public void addCourse(Course course, String semester) {
        courseToData.put(course, new ArchivedCourseData(
                semester,
                LocalDate.now()
        ));
    }

    /**
     * add a course to this archive. This operation will be recorded in terms of the date given by the system clock.
     * @param course the course to archive
     */
    public void addCourse(Course course) {
        addCourse(course, "");
    }

    public void RemoveCourse(Course course) {
        courseToData.remove(course);
    }
}

