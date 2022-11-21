package database;

import usecases.dataStorage.account.AccountDsGateway;
import usecases.dataStorage.account.AccountDsRequestModel;
import usecases.dataStorage.account.AccountDsModel;
import usecases.dataStorage.course.CourseDsGateway;
import usecases.dataStorage.course.CourseDsModel;
import usecases.dataStorage.course.CourseDsRequestModel;

import java.util.ArrayList;

public class MemoryDataBase implements AccountDsGateway, CourseDsGateway {
    ArrayList<AccountDsModel> Accounts;

    /**
     * @param requestModel
     * @return whether the specified account exists in the database.
     */
    @Override
    public boolean existsAccount(AccountDsRequestModel requestModel) {
        return 0 < Accounts.stream()
                .filter(accountModel -> accountModel.getUsername() == requestModel.getUsername())
                .count();
    }

    /**
     * @param requestModel
     * @return the account data in this database.
     * @throws NoSuchFieldException if the specified account does not exist.
     */
    @Override
    public AccountDsModel loadAccount(AccountDsRequestModel requestModel) throws NoSuchFieldException {
        if (!existsAccount(requestModel)) {
            throw new NoSuchFieldException("The specified account does not exist.");
        }
        return (AccountDsModel) Accounts.stream()
                .filter(accountModel -> accountModel.getUsername() == requestModel.getUsername())
                .toArray()[0];
    }

    /**
     * @param requestModel
     * @return whether this course is part of a semester in this database.
     */
    @Override
    public boolean existsSemesterCourse(CourseDsRequestModel requestModel) {
        try {
            return 0 < loadAccount(requestModel).getSemesterData().stream()
                    .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                    .count();
        } catch (NoSuchFieldException exception) {
            return false;
        }
    }

    /**
     * @param requestModel
     * @return whether this course is part of an archive in this database.
     */
    @Override
    public boolean existsArchivedCourse(CourseDsRequestModel requestModel) {
        try {
            return 0 < loadAccount(requestModel).getArchiveData().stream()
                    .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                    .count();
        } catch (NoSuchFieldException exception) {
            return false;
        }
    }

    /**
     * @param requestModel
     * @return the course data in this database
     * @throws NoSuchFieldException if this course is not a part of a user's semester.
     */
    @Override
    public CourseDsModel loadSemesterCourse(CourseDsRequestModel requestModel) throws NoSuchFieldException {
        if (!existsSemesterCourse(requestModel)) {
            throw new NoSuchFieldException("The specified course does not exist.");
        }
        return (CourseDsModel) loadAccount(requestModel).getSemesterData().stream()
                .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                .toArray()[0];
    }

    /**
     * @param requestModel
     * @return the course data in this database
     * @throws NoSuchFieldException if this course is not a part of a user's archive.
     */
    @Override
    public CourseDsModel loadArchivedCourse(CourseDsRequestModel requestModel) throws NoSuchFieldException {
        if (!existsArchivedCourse(requestModel)) {
            throw new NoSuchFieldException("The specified course does not exist.");
        }
        return (CourseDsModel) loadAccount(requestModel).getArchiveData().stream()
                .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                .toArray()[0];
    }
}
