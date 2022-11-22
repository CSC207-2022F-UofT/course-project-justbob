package entities.course;

public class CourseFactory {
    public Course create(String courseCode, String courseName, String semester, boolean archived, float credit) {
        return new Course(courseCode, courseName, archived, credit);
    }
}
