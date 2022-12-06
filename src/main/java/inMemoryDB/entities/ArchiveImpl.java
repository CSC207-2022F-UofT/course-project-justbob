package inMemoryDB.entities;

import entities.account.Archive;
import entities.course.Course;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ArchiveImpl extends Archive {
    private final HashMap<Course, Archive.ArchivedCourseData> courseToData = new HashMap<>();

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
        Archive.ArchivedCourseData data = new Archive.ArchivedCourseData();
        data.setSemester(semester);
        data.setDateArchived(LocalDate.now());
        courseToData.put(course, data);
    }

    @Override
    public void removeCourse(Course course) {
        courseToData.remove(course);
    }

    @Override
    public Course getCourseByCode(String courseCode) {
        for(Course course : getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }

        return null;
    }
}
