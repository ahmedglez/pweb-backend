package cu.edu.cujae.pwebjsf.data.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateController {

    public static  String getStringLocalDate(String date){
        return LocalDate.parse(date).toString();
    }

    public static LocalDate getActualDate(){ return LocalDate.now(); }

    public static int extensionDate(LocalDate initial_date, LocalDate final_date) {
        return Math.toIntExact(ChronoUnit.DAYS.between(initial_date, final_date));
    }

    public static LocalDate getLocalDateByString(String date) throws ParseException {
        String[] part = date.split(" ");
        String newDate = part[2] + "-"+ part[1] +"-"+ part[5];
        System.out.println(date);
        System.out.println(newDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US);
        return LocalDate.parse(newDate, formatter);
    }

    public static LocalDate futureDate(LocalDate date, int day){return date.plusDays(day);}
}
