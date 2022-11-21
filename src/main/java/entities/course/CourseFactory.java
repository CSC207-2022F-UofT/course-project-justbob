package entities.course;

public class CourseFactory implements CourseFactoryInterface{

    @Override
    public Course create(String courseCode, String courseName, String semester, boolean archived, float credit) {
        return new Course(courseCode, courseName, semester, archived, credit);
    }
}
