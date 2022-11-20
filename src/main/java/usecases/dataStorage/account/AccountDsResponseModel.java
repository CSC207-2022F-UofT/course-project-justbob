package usecases.dataStorage.account;

import usecases.dataStorage.course.CourseDsResponseModel;

public class AccountDsResponseModel {
    private String username;
    private String password;
    private CourseDsResponseModel[] semesterData;
    private CourseDsResponseModel[] archiveData;

    public AccountDsResponseModel(String username, String password, CourseDsResponseModel[] semesterData, CourseDsResponseModel[] archiveData) {
        this.username = username;
        this.password = password;
        this.semesterData = semesterData;
        this.archiveData = archiveData;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public CourseDsResponseModel[] getSemesterData() {
        return semesterData;
    }

    public CourseDsResponseModel[] getArchiveData() {
        return archiveData;
    }
}
