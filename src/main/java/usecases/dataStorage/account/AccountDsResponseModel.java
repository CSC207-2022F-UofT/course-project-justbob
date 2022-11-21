package usecases.dataStorage.account;

import usecases.dataStorage.course.CourseDsResponseModel;

import java.util.List;

public class AccountDsResponseModel {
    private String username;
    private String password;
    private List<CourseDsResponseModel> semesterData;
    private List<CourseDsResponseModel> archiveData;

    public AccountDsResponseModel(String username, String password, List<CourseDsResponseModel> semesterData,
                                  List<CourseDsResponseModel> archiveData) {
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

    public List<CourseDsResponseModel> getSemesterData() {
        return semesterData;
    }

    public List<CourseDsResponseModel> getArchiveData() {
        return archiveData;
    }
}
