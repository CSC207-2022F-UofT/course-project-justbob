package AccountClasses;

import java.util.ArrayList;

public class Archive {
    List<Course> archived = new ArrayList<Course>();
    CGPA pastGpa;

    public Archive(){}

    @Override
    public String toString() {
        StringBuilder pastCourses = new StringBuilder();
        for(Course course : archived){
            pastCourses.append(course.toString());
        }
        return pastCourses.toString();
    }

    public CGPA getPastGpa(){
        return pastGpa;
    }
    public void addArchivedCourse(Course course){
        archived.add(Course);
    }
    public void removeArchivedCourse(Course course){
        archived.remove(Course);
    }
}

