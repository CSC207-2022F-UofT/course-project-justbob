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

import java.util.ArrayList;

public class MemoryDataBase implements AccountDsGateway, CourseDsGateway, AssessmentDsGateway, InstanceDsGateway {
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
     * @return whether this course is part of an account in this database.
     */
    @Override
    public boolean existsCourse(CourseDsRequestModel requestModel) {
        try {
            return 0 < loadAccount(requestModel).getCourseData().stream()
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
    public CourseDsModel loadCourse(CourseDsRequestModel requestModel) throws NoSuchFieldException {
        if (!existsCourse(requestModel)) {
            throw new NoSuchFieldException("The specified course does not exist.");
        }
        return (CourseDsModel) loadAccount(requestModel).getCourseData().stream()
                .filter(courseDsModel -> courseDsModel.getCourseCode() == requestModel.getCourseCode())
                .toArray()[0];
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
        } catch (NoSuchFieldException exception) {
            return false;
        }
    }

    @Override
    public AssessmentDsModel loadAssessment(AssessmentDsRequestModel requestModel) throws NoSuchFieldException {
        if (!existsAssessment(requestModel)) {
            throw new NoSuchFieldException("The specified assessment does not exist.");
        }
        return (AssessmentDsModel) loadCourse(requestModel).getAssessmentData().stream()
                .filter(assessmentDsModel -> assessmentDsModel.getTitle() == requestModel.getAssessmentTitle())
                .toArray()[0];
    }

    @Override
    public boolean existsInstance(InstanceDsRequestModel requestModel) {
        try {
            return requestModel.getInstanceIndex() < loadAssessment(requestModel).getInstanceData().size();
        } catch (NoSuchFieldException exception) {
            return false;
        }
    }

    @Override
    public InstanceDsModel loadInstance(InstanceDsRequestModel requestModel) throws NoSuchFieldException {
        if (!existsInstance(requestModel)) {
            throw new NoSuchFieldException("The specified instance does not exist.");
        }
        return (InstanceDsModel) loadAssessment(requestModel).getInstanceData().get(requestModel.getInstanceIndex());
    }

    @Override
    public void saveInstanceMark(InstanceDsRequestModel requestModel, double mark) throws NoSuchFieldException {
        loadInstance(requestModel).setMark(mark);
    }
}
