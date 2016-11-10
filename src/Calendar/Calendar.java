package Calendar;

/**
 * Created by employee on 11/10/16.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.*;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


/**
 * Created by employee on 11/3/16. abc
 */

public abstract class Calendar {

    // private YearMonth month;
    private DayOfWeek weekStart;
    private LocalDate today = LocalDate.now();

    private Set<DayOfWeek> weekend = new HashSet<>();
    private Locale locale;


    public abstract String printYearHeader();
    public abstract String printMonthHeader();
    public abstract String printWeekendHeader(DayOfWeek dayOfWeek);
    public abstract String printCommonHeader(DayOfWeek dayOfWeek);
    public abstract String printGaps();
    public abstract String nextLine();
    public abstract String printCommonDay(LocalDate date);
    public abstract String printWeekend(LocalDate date);
    public abstract String printCurrentDay(LocalDate date);
    public abstract void print();



    public String printDaysOfMonth(){

        String result = "";

        LocalDate date = getToday().withDayOfMonth(1);

        LocalDate lastDayOfMonth = getToday().withDayOfMonth(getToday().lengthOfMonth());

        for (int i=1; i<=lastDayOfMonth.getDayOfMonth(); i++){

            result += printDay(date);

            date = date.plusDays(1);
        }

        return result;
    }

    public String printDay(LocalDate date){
        String result = "";

        if (isCurrentDay(date)){
            result += printCurrentDay(date);
        }
        else if (isWeekend(date.getDayOfWeek())){
            result += printWeekend(date);
        }

        else {
            result += printCommonDay(date);
        }
        if(isLastDayOfWeek(date)){
            result +=  nextLine();
        }

        return result;}

    public String printGapsBeforeFirstDayOfMonth(){

        String result = "";

        int param = generateNumberOfEmptySpacesBeforeFirstDayOfMonth();

        for(int i=1; i<=param; i++){

            result += printGaps();

        }

        return result;
    }

    public int generateNumberOfEmptySpacesBeforeFirstDayOfMonth(){

        int result = 0;


        DayOfWeek firstDayOfWeek = getWeekStart();

        DayOfWeek dayOfWeek = getToday()
                .withDayOfMonth(1)
                .getDayOfWeek();

        do{
            if(dayOfWeek.equals(firstDayOfWeek)){
                break;
            }

            result+=1;

            firstDayOfWeek = firstDayOfWeek.plus(1);

        }while (!dayOfWeek.equals(firstDayOfWeek));

        return result;

    }

    public String printDaysNames() {

        String res = "";

        DayOfWeek dayOfWeek = getWeekStart();
        Set<DayOfWeek> weekend = getWeekend();

        for(int i=1; i<=DayOfWeek.values().length; i++){

            if(isWeekend(dayOfWeek)){
                res+=printWeekendHeader(dayOfWeek);
            }
            else {
                res+=printCommonHeader(dayOfWeek);
            }
            dayOfWeek = dayOfWeek.plus(1);

        }

        return res+nextLine();
    }

    private boolean isLastDayOfWeek(LocalDate date){

        DayOfWeek lastDayOfWeek = getWeekStart().plus(6);

        if(date.getDayOfWeek().equals(lastDayOfWeek)){
            return true;
        }
        else  return false;
    }

    private boolean isWeekend(DayOfWeek dayOfWeek){
        if(getWeekend().contains(dayOfWeek)){
            return true;
        }
        return false;
    }
    private boolean isCurrentDay(LocalDate date){
        if(date.equals(LocalDate.now())){
            return true;
        }

        return false;}



    public String printYearHeaderAndMonth(){

        String result = "";

        result += printMonthHeader();
        result += printGaps();
        result += printYearHeader();
        result += nextLine();


        return result;
    }


    public void setWeekend(DayOfWeek... weekend) {
        this.weekend.clear();
        for (DayOfWeek dayOfWeek : weekend) {
            this.weekend.add(dayOfWeek);
        }

    }

    public void setWeekStart(DayOfWeek dayOfWeek) {
        this.weekStart = dayOfWeek;

    }


    public void setLocale(Locale locale) {

        this.locale = locale;

    }


    public void setToday(LocalDate today){
        this.today = today;
    }


    public LocalDate getToday() {

        return today;
    }




    public DayOfWeek getWeekStart() {
        return weekStart;
    }

    public Set<DayOfWeek> getWeekend() {
        return weekend;
    }

    public Locale getLocale() {
        return locale;
    }
}
