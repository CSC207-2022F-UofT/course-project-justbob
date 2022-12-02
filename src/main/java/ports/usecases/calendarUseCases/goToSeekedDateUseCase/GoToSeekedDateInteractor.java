package ports.usecases.calendarUseCases.goToSeekedDateUseCase;

public class GoToSeekedDateInteractor implements GoToSeekedDateInputBoundary {
    @Override
    public GoToSeekedDateResponseModel execute(GoToSeekedDateRequestModel requestModel) {
        GoToSeekedDateResponseModel responseModel = new GoToSeekedDateResponseModel(requestModel.getSeekedDate());
        return responseModel;
    }
}
