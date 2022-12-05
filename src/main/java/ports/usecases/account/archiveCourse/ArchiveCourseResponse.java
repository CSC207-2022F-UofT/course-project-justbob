package ports.usecases.account.archiveCourse;

import java.util.List;

public class ArchiveCourseResponse {
    public List<String> courseList;

    public ArchiveCourseResponse(){}

    public ArchiveCourseResponse(List<String> courses){
        this.courseList = courses;
    }
}
