package day01;

import java.time.LocalDate;

public class Trip {
    private Double length;
    private LocalDate date;

    public Trip(Double length, LocalDate date) {
        this.length = length;
        this.date = date;
    }
    public boolean matchYear(int year){
        return(year==date.getYear());
    }
    public boolean matchMonth(int month){
        return(month==date.getMonthValue());
    }
    public boolean matchYearAndMonth(int year, int month) {
        return(matchYear(year) && matchMonth(month));
    }

    public Double getLength() {
        return length;
    }
}
