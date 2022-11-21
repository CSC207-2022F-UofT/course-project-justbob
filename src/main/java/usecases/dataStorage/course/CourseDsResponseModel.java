package usecases.dataStorage.course;

import usecases.dataStorage.assessment.AssessmentDsResponseModel;

import java.util.List;

public class CourseDsResponseModel {
    private String courseCode;
    private String courseName;
    private String semester;
    private boolean archived;
    private float credit;
    private List<AssessmentDsResponseModel> assessmentData;
    private List<CourseEventDsModel> courseEventData;

    public CourseDsResponseModel(String courseCode, String courseName, String semester, boolean archived, float credit,
                                 List<AssessmentDsResponseModel> assessmentData, List<CourseEventDsModel> courseEventData) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.archived = archived;
        this.credit = credit;
        this.assessmentData = assessmentData;
        this.courseEventData = courseEventData;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getSemester() {
        return semester;
    }

    public boolean isArchived() {
        return archived;
    }

    public float getCredit() {
        return credit;
    }

    public List<AssessmentDsResponseModel> getAssessmentData() {
        return assessmentData;
    }

    public List<CourseEventDsModel> getCourseEventData() {
        return courseEventData;
    }
}
