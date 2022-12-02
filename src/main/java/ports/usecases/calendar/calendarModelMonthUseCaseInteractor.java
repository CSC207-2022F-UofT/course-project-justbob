package ports.usecases.calendar;

import java.time.*;

public class calendarModelMonthUseCaseInteractor implements calendarModelMonthInputBoundary {

    final calendarModelMonthOutputBoundary monthOutput;

    public calendarModelMonthUseCaseInteractor(calendarModelMonthOutputBoundary monthOutput){
        this.monthOutput = monthOutput;
    }

    @Override
    public calendarModelResponseMonth execute(calendarModelRequest calendarMonthRequest) {
        LocalDate[] monthDays = new LocalDate[41];
        LocalDate firstDay = LocalDate.of(calendarMonthRequest.getDate().getYear(),
                calendarMonthRequest.getDate().getMonth().getValue(), 1);
        int week = (firstDay.getDayOfWeek().getValue()) % 7;

        LocalDate temporary = firstDay;
        for(int i = week; i < monthDays.length; i++){
            monthDays[i] = temporary;
            temporary = temporary.plusDays(1);
            if (temporary.getMonthValue() != firstDay.getMonthValue()){
                i = 41;
            }
        }
        calendarModelResponseMonth monthData = new calendarModelResponseMonth(monthDays);
        return monthOutput.prepareSuccessView(monthData);
    }
}
