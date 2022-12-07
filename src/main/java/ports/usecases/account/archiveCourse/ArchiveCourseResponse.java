package ports.usecases.account.archiveCourse;

import java.util.List;

public class ArchiveCourseResponse {
    public String[] courseCodes;
    public String[]

    public ArchiveCourseResponse(){}

    public ArchiveCourseResponse(String[] courses){
        this.courseCodes = courses;
    }
}
