package main;

public class myDate {
    private int year;
    private int month;
    private int day;

    /**
     * Create a date consist of year, month, and day value
     * @param year the year component of the date
     *             e.g. 2022
     * @param month the month component of the date
     *              Precondition: 1 <= month <= 12
     *              e.g. 12
     * @param day the day component of the date
     *            Precondition: 1 <= day <= 31
     *            Note: day like 31 in February is invalid
     *            e.g. 16
     */

    public myDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString(){
        return this.year + "-" + this.month + "-" + this.day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean before(myDate anotherDate) {
        if (this.year < anotherDate.getYear()){
            return true;
        }
        if ((this.year == anotherDate.getYear()) && (this.month < anotherDate.getMonth())){
            return true;
        }
        if (this.year == anotherDate.getYear() && this.month == anotherDate.getMonth() && this.day
                < anotherDate.getDay()){
            return true;
        }
        return false;
    }

    public boolean equal(myDate anotherDate){
        if (this.year == anotherDate.getYear() && this.month == anotherDate.getMonth() && this.day
                == anotherDate.getDay()) {
            return true;
        }
        return false;
    }

    public boolean after(myDate anotherDate){
        if (this.year > anotherDate.getYear()){
            return true;
        }
        if ((this.year == anotherDate.getYear()) && (this.month > anotherDate.getMonth())){
            return true;
        }
        if (this.year == anotherDate.getYear() && this.month == anotherDate.getMonth() && this.day
                > anotherDate.getDay()){
            return true;
        }
        return false;
    }

}
