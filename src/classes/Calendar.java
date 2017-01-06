package classes;

import interfaces.CalendarInterface;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by Vit on 05.01.2017.
 */
public class Calendar implements CalendarInterface {
    private LocalDate date;
    private StringBuffer calendar = new StringBuffer();
    private DayOfWeek firstDayOfMonth;
    private LocalDate today = LocalDate.now();
    private int daysInMonth;


    public Calendar(int year, int month) {
        date = LocalDate.of(year, month, 1);
    }

    public void calendarGenerator(){
        int dayNumber = 0;
        LocalDate pointer = date;

        calendar.append("Пн"+"\t"+"Вт"+"\t"+"Ср"+"\t"+"Чт"+"\t"+"Пт"+"\t"+weekendColour("Сб\tНд")+"\n");
        daysInMonth = date.lengthOfMonth();
        firstDayOfMonth = date.getDayOfWeek();

        if (!firstDayOfMonth.equals("MONDAY")){
            for (int k = 1; k<firstDayOfMonth.getValue(); k++){
            calendar.append("\t");
            }
        }

        while (dayNumber < daysInMonth){

            if (pointer.isEqual(today)) {
                 calendar.append(todayColour(""+pointer.getDayOfMonth()));


                if (pointer.getDayOfWeek().name().equals("SUNDAY")){
                    calendar.append("\n");
                }
            }

            else{

                if (pointer.getDayOfWeek().name().equals("SUNDAY") || pointer.getDayOfWeek().name().equals("SATURDAY")){
                    calendar.append(weekendColour(""+pointer.getDayOfMonth()));

                    if (pointer.getDayOfWeek().name().equals("SUNDAY")){
                        calendar.append("\n");
                    }
                }

                else {
                    calendar.append(pointer.getDayOfMonth() + "\t");
                }
            }
            dayNumber++;
            pointer = pointer.plusDays(1);
        }
        System.out.println("Поточна дата: " + today);
        System.out.println(date.getMonth() + " " + date.getYear());
        System.out.println(calendar);
    }

    private static String weekendColour(String string){
        return (char)27 + "[31m" + string + (char)27 + "[0m" + "\t";
    }

    private static String todayColour(String string) {
        return (char)27 + "[34m" + string + (char)27 + "[0m" + "\t";

    }




}
