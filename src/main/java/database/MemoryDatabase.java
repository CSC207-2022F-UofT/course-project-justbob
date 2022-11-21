package database;

import usecases.dataStorage.account.AccountDsGateway;
import usecases.dataStorage.account.AccountDsRequestModel;
import usecases.dataStorage.account.AccountDsModel;
import usecases.dataStorage.assessment.AssessmentDsGateway;
import usecases.dataStorage.assessment.AssessmentDsModel;
import usecases.dataStorage.assessment.AssessmentDsRequestModel;
import usecases.dataStorage.course.CourseDsGateway;
import usecases.dataStorage.course.CourseDsModel;
import usecases.dataStorage.course.CourseDsRequestModel;
import usecases.dataStorage.instance.InstanceDsGateway;
import usecases.dataStorage.instance.InstanceDsModel;
import usecases.dataStorage.instance.InstanceDsRequestModel;

import java.io.Serializable;
import java.util.ArrayList;

public class MemoryDatabase implements AccountDsGateway, CourseDsGateway, AssessmentDsGateway, InstanceDsGateway,
        Serializable {
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
     * @throws IllegalArgumentException if the specified account does not exist.
     */
    @Override
    public AccountDsModel loadAccount(AccountDsRequestModel requestModel) throws IllegalArgumentException {
        if (!existsAccount(requestModel)) {
            throw new IllegalArgumentException("The specified account does not exist.");
        }
        return (AccountDsModel) Accounts.stream()
                .filter(accountModel -> accountModel.getUsername() == requestModel.getUsername())
                .toArray()[0];
    }

    /**
     * Add a new account to the database.
     * @param accountDsModel
     * @throws IllegalArgumentException if the account is already in the database.
     */
    public void addAccount(AccountDsModel accountDsModel) throws IllegalArgumentException {
        if (existsAccount(new AccountDsRequestModel(accountDsModel.getUsername()))) {
            throw new IllegalArgumentException("Account already exists.");
        }
        Accounts.add(accountDsModel);
    }

    /**
     * @param requestModel
     * @return whether this course is part of an account in this database.
     */
    @Override
    public boolean existsCourse(CourseDsRequestModel requestModel) {
        try {
            return 0 < loadAccount(requestModel).getCourseData().stream()
                    .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                    .count();
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    /**
     * @param requestModel
     * @return the course data in this database
     * @throws IllegalArgumentException if this course is not a part of a user's semester.
     */
    @Override
    public CourseDsModel loadCourse(CourseDsRequestModel requestModel) throws IllegalArgumentException {
        if (!existsCourse(requestModel)) {
            throw new IllegalArgumentException("The specified course does not exist.");
        }
        return (CourseDsModel) loadAccount(requestModel).getCourseData().stream()
                .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                .toArray()[0];
    }

    /**
     * add a new course to the database.
     * @param accountDsRequestModel the account to add the course to
     * @param courseDsModel the course's data
     * @throws IllegalArgumentException if the account does not exist or the course is already there.
     */
    public void addCourse(AccountDsRequestModel accountDsRequestModel, CourseDsModel courseDsModel)
            throws IllegalArgumentException {
        if (existsCourse(new CourseDsRequestModel(
                accountDsRequestModel.getUsername(),
                courseDsModel.getCourseCode()))) {
            throw new IllegalArgumentException("Course already exists");
        }
        loadAccount(accountDsRequestModel).getCourseData().add(courseDsModel);
    }

    /**
     * @param requestModel
     * @return whether the assessment exists in this database.
     */
    @Override
    public boolean existsAssessment(AssessmentDsRequestModel requestModel) {
        try {
            return 0 < loadCourse(requestModel).getAssessmentData().stream()
                    .filter(assessmentDsModel -> assessmentDsModel.getTitle() == requestModel.getAssessmentTitle())
                    .count();
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    /**
     * @param requestModel
     * @return the assessment data in this database
     * @throws IllegalArgumentException if the assessment does not exist in this database.
     */
    @Override
    public AssessmentDsModel loadAssessment(AssessmentDsRequestModel requestModel) throws IllegalArgumentException {
        if (!existsAssessment(requestModel)) {
            throw new IllegalArgumentException("The specified assessment does not exist.");
        }
        return (AssessmentDsModel) loadCourse(requestModel).getAssessmentData().stream()
                .filter(assessmentDsModel -> assessmentDsModel.getTitle() == requestModel.getAssessmentTitle())
                .toArray()[0];
    }

    /**
     * @param requestModel
     * @return whether the specified instance exists in this database
     */
    @Override
    public boolean existsInstance(InstanceDsRequestModel requestModel) {
        try {
            return requestModel.getInstanceIndex() < loadAssessment(requestModel).getInstanceData().size();
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    /**
     * @param requestModel
     * @return the instance data in this database
     * @throws IllegalArgumentException if the specified instance does not exist.
     */
    @Override
    public InstanceDsModel loadInstance(InstanceDsRequestModel requestModel) throws IllegalArgumentException {
        if (!existsInstance(requestModel)) {
            throw new IllegalArgumentException("The specified instance does not exist.");
        }
        return (InstanceDsModel) loadAssessment(requestModel).getInstanceData().get(requestModel.getInstanceIndex());
    }

    /**
     * save an instance's mark in the database
     * @param requestModel
     * @param mark the new mark to set
     * @throws IllegalArgumentException if the specified instance does not exist
     */
    @Override
    public void saveInstanceMark(InstanceDsRequestModel requestModel, double mark) throws IllegalArgumentException {
        loadInstance(requestModel).setMark(mark);
    }
}
