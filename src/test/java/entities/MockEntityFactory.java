package entities;

import entities.account.Account;
import entities.account.Archive;
import entities.account.Semester;
import entities.course.Course;
import ports.database.EntityFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
public class MockEntityFactory implements EntityFactory {
    private class ArchiveMock extends Archive {
        private HashMap<Course, ArchivedCourseData> courseToData = new HashMap<>();

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
    }

    private class SemesterMock extends Semester {
        private String title;
        private ArrayList<Course> runningCourses;

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public ArrayList<Course> getRunningCourses() {
            return runningCourses;
        }

        @Override
        public void setRunningCourses(ArrayList<Course> runningCourses) {
            this.runningCourses = runningCourses;
        }

        @Override
        public void addCourse(Course course) {
            if (!getRunningCourses().contains(course)) {
                getRunningCourses().add(course);
            }
        }

        @Override
        public void removeCourse(Course course) {
            getRunningCourses().remove(course);
        }
    }

    private class AccountMock extends Account {
        private String username;
        private String password;
        private Semester semester;
        private Archive archive;

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public Semester getSemester() {
            return semester;
        }

        @Override
        public void setSemester(Semester semester) {
            this.semester = semester;
        }

        @Override
        public Archive getArchive() {
            return archive;
        }

        @Override
        public void setArchive(Archive archive) {
            this.archive = archive;
        }
    }
}
*/