package entities.course;

public interface CourseFactoryInterface {

    Course create(String courseCode, String courseName, String semester, boolean archived, float credit);
}
