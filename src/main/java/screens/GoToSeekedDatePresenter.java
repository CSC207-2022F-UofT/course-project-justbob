package screens;

import ports.usecases.calendar.goToSeekedDateUseCase.GoToSeekedDateOutputBoundary;
import ports.usecases.calendar.goToSeekedDateUseCase.GoToSeekedDateRequestModel;
import ports.usecases.calendar.goToSeekedDateUseCase.GoToSeekedDateResponseModel;

public class GoToSeekedDatePresenter implements GoToSeekedDateOutputBoundary {
    @Override
    public GoToSeekedDateResponseModel prepareSuccessView(GoToSeekedDateRequestModel goToSeekedDateRequestModel) {
        return null;
    }
}
