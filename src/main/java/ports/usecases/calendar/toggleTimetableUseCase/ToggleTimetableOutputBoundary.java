package ports.usecases.calendar.toggleTimetableUseCase;

public interface ToggleTimetableOutputBoundary {
    ToggleTimetableResponseModel prepareSuccessView(ToggleTimetableRequestModel toggleAssessmentsRequestModel);
}
