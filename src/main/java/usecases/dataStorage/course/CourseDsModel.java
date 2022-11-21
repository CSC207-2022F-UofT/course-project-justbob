package usecases.dataStorage.course;

import usecases.dataStorage.assessment.AssessmentDsModel;

import java.io.Serializable;
import java.util.List;

public class CourseDsModel implements Serializable {
    private String courseCode;
    private String courseName;
    private String semester;
    private boolean archived;
    private float credit;
    private List<AssessmentDsModel> assessmentData;
    private List<CourseEventDsModel> courseEventData;

    public CourseDsModel(String courseCode, String courseName, String semester, boolean archived, float credit,
                         List<AssessmentDsModel> assessmentData, List<CourseEventDsModel> courseEventData) {
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

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public List<AssessmentDsModel> getAssessmentData() {
        return assessmentData;
    }

    public void setAssessmentData(List<AssessmentDsModel> assessmentData) {
        this.assessmentData = assessmentData;
    }

    public List<CourseEventDsModel> getCourseEventData() {
        return courseEventData;
    }

    public void setCourseEventData(List<CourseEventDsModel> courseEventData) {
        this.courseEventData = courseEventData;
    }
}
