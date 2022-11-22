package entities.course;

public class CourseFactory {
    public Course create(String courseCode, String courseName, float credit) {
        return new Course(courseCode, courseName, credit);
    }
}
