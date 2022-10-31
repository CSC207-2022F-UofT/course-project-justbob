package AccountClasses;

import java.util.ArrayList;

public class Archive {
    List<Course> archived;
    CGPA pastGpa;

    public Archive(){
        this.archived = null;
        this.pastGpa = null;
    }

    public Archive(List<Course> pastCourses){
        this.archived = pastCourses;
        /** this.pastGpa = call of CGPA calculator. **/
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
        /**call CGPA calculator with archived courses inputs**/
    }
}

