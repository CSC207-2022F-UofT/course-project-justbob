package usecases.markOperations.addMark;

public interface AddMarkPresenter {
    AddMarkResponseModel prepareSuccessView(AddMarkResponseModel responseModel);
    AddMarkResponseModel prepareFailureView(String errorMessage);
}
