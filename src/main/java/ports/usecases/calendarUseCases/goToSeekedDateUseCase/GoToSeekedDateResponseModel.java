package ports.usecases.calendarUseCases.goToSeekedDateUseCase;

import java.time.LocalDate;

public class GoToSeekedDateResponseModel {
    private LocalDate viewingDate;

    public GoToSeekedDateResponseModel(LocalDate requestedDate) {
        this.viewingDate = requestedDate;
    }

    void setViewingDate(LocalDate requestedDate) {
        this.viewingDate = requestedDate;
    }

    LocalDate getViewingDate() {
        return viewingDate;
    }
}
