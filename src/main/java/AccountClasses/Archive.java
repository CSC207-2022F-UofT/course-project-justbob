package AccountClasses;

import java.util.ArrayList;

public class Archive {
    List<Course> archived = new ArrayList<Course>();
    CGPA pastGpa;

    public Archive(){}

    public Archive(List<Course> pastCourses){
        this.archived = pastCourses;
        /** this.pastGpa = call of CGPA calculator with archived inputs **/
    }

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
}

