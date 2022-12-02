package screens;

import ports.usecases.calendarUseCases.goToSeekedDateUseCase.GoToSeekedDateInputBoundary;

public class GoToSeekedDateController {
    final GoToSeekedDateInputBoundary userInput;

    public GoToSeekedDateController(GoToSeekedDateInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

//    GoToSeekedDateResponseModel create() {
//        GoToSeekedDateRequestModel requestModel = new
//    }
//    }
}
