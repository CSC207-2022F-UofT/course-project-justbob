package ports.usecases.calendar.getWeekData;

import java.time.LocalDate;

public class calendarModelWeekUseCaseInteractor implements calendarModelWeekInputBoundary {
    final calendarModelWeekOutputBoundary weekOutput;

    public calendarModelWeekUseCaseInteractor(calendarModelWeekOutputBoundary weekOutput){
        this.weekOutput = weekOutput;
    }

    /**
     * Takes calendarModelWeekRequest and converts data into array of days in associated week
     * @param calendarWeekRequest represents data (year-month-date in terms of numbers)
     * @return array of the week days (from sunday to saturday) associated with the date
     */
    @Override
    public calendarModelWeekResponse execute(calendarModelWeekRequest calendarWeekRequest) {
        LocalDate[] weekDays = new LocalDate[7];
        int week = calendarWeekRequest.getDate().getDayOfWeek().getValue();
        LocalDate temp = calendarWeekRequest.getDate();

        while(temp.getDayOfWeek().getValue() != 7){
            temp = temp.minusDays(1);

        }
        for (int i = 0; i < 7; i++){
            weekDays[i] = temp;
            temp = temp.plusDays(1);
        }
        calendarModelWeekResponse weekData = new calendarModelWeekResponse(weekDays);
        return weekOutput.prepareSuccessView(weekData);
    }
}
