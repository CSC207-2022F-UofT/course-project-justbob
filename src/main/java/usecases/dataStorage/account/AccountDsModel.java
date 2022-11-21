package usecases.dataStorage.account;

import usecases.dataStorage.course.CourseDsModel;

import java.util.List;

public class AccountDsModel {
    private String username;
    private String password;
    private List<CourseDsModel> courseData;

    public AccountDsModel(String username, String password, List<CourseDsModel> courseData) {
        this.username = username;
        this.password = password;
        this.courseData = courseData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CourseDsModel> getCourseData() {
        return courseData;
    }

    public void setCourseData(List<CourseDsModel> courseData) {
        this.courseData = courseData;
    }
}
