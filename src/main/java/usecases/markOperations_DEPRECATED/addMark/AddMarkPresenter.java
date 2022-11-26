package usecases.markOperations_DEPRECATED.addMark;

public interface AddMarkPresenter {
    AddMarkResponseModel prepareSuccessView(AddMarkResponseModel responseModel);
    AddMarkResponseModel prepareFailureView(String errorMessage);
}
