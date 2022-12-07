package ports.usecases.calendar.goToSeekedDateUseCase;

import screens.GoToSeekedDateOutputBoundary;

public class GoToSeekedDateInteractor implements GoToSeekedDateInputBoundary {
    GoToSeekedDateOutputBoundary goToSeekedDateOutputBoundary;

    public GoToSeekedDateInteractor(GoToSeekedDateOutputBoundary goToSeekedDateOutputBoundary) {
        this.goToSeekedDateOutputBoundary = goToSeekedDateOutputBoundary;
    }

    @Override
    public GoToSeekedDateResponseModel execute(GoToSeekedDateRequestModel requestModel) {
        return goToSeekedDateOutputBoundary.prepareSuccessView(requestModel);
    }
}
