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
    public void RemoveCourse(Course course) {
        courseToData.remove(course);
    }

    @Override
    public Course getCourseByCode(String courseCode) {
        Course[] candidates = (Course[]) courseToData.keySet().stream().filter(course ->
                Objects.equals(course.getCourseCode(), courseCode)).toArray();
        if(candidates.length > 0){
            return candidates[0];
        }

        return null;
    }
}
