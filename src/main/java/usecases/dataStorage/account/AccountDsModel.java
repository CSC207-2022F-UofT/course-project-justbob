package usecases.dataStorage.account;

import usecases.dataStorage.course.CourseDsModel;

import java.util.List;

public class AccountDsModel {
    private String username;
    private String password;
    private List<CourseDsModel> semesterData;
    private List<CourseDsModel> archiveData;

    public AccountDsModel(String username, String password, List<CourseDsModel> semesterData,
                          List<CourseDsModel> archiveData) {
        this.username = username;
        this.password = password;
        this.semesterData = semesterData;
        this.archiveData = archiveData;
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

    public List<CourseDsModel> getSemesterData() {
        return semesterData;
    }

    public void setSemesterData(List<CourseDsModel> semesterData) {
        this.semesterData = semesterData;
    }

    public List<CourseDsModel> getArchiveData() {
        return archiveData;
    }

    public void setArchiveData(List<CourseDsModel> archiveData) {
        this.archiveData = archiveData;
    }
}
