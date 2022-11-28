package inMemoryDB.entities;

import entities.account.Archive;
import entities.course.Course;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class ArchiveImpl extends Archive implements Serializable {
    private HashMap<Course, Archive.ArchivedCourseData> courseToData = new HashMap<>();

    @Override
    public List<Course> getCourses() {
        return List.copyOf(courseToData.keySet());
    }

    @Override
    public Archive.ArchivedCourseData getArchivedCourseData(Course course) {
        return courseToData.get(course);
    }

    @Override
    public void addCourse(Course course, String semester) {
        Archive.ArchivedCourseData data = new ArchivedCourseDataImpl();
        data.setSemester(semester);
        data.setDateArchived(LocalDate.now());
        courseToData.put(course, data);
    }

    @Override
    public void RemoveCourse(Course course) {
        courseToData.remove(course);
    }

    public class ArchivedCourseDataImpl extends ArchivedCourseData {
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
}
