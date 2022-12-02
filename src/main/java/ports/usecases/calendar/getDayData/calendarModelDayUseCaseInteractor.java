package ports.usecases.calendar.getDayData;

import java.time.LocalDate;

public class calendarModelDayUseCaseInteractor implements calendarModelDayInputBoundrary{
    final calendarModelDayOutputBoundary dayOutput;

    public calendarModelDayUseCaseInteractor(calendarModelDayOutputBoundary dayOutput){
        this.dayOutput = dayOutput;
    }

    @Override
    public calendarModelDayResponse execute(calendarModelDayRequest calendarDayRequest) {
        LocalDate day = calendarDayRequest.getDate();

        calendarModelDayResponse dayData = new calendarModelDayResponse(day);
        return dayOutput.prepareSuccessView(dayData);
    }

}
