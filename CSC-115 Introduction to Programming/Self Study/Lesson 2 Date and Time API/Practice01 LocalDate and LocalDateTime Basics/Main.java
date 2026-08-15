// Creation Date: August 15, 2026. at 10:59 AM
// Last Modified: August 15, 2026. at 11:36 AM

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        LocalDate Today = LocalDate.now();
        LocalTime Now = LocalTime.now();

        // [FIRST PRINT]
        printDate(Today);
        printTime(Now);
        System.out.println();

        LocalDate TodayPlus = Today.plusDays(10);
        LocalTime NowMinus = Now.minusHours(2);

        // [SECOND PRINT]
        printDate(TodayPlus);
        printTime(NowMinus);
        System.out.println();
        
    }

    // =========================== METHODS =========================== \\
    public static void printDate(LocalDate ld) {
        System.out.println("========= [DATE] =========");
        System.out.println("Year: "+ld.getYear());
        System.out.println("Month: "+ld.getMonthValue()+" ["+ld.getMonth()+"]");
        System.out.println("Day: "+ld.getDayOfMonth()+" ["+ld.getDayOfWeek()+"]");
        System.out.println();
    }
    public static void printTime(LocalTime lt) {
        System.out.println("========= [TIME] =========");
        System.out.println("Hour: "+lt.getHour());
        System.out.println("Minutes: "+lt.getMinute());
        System.out.println("Seconds: "+lt.getSecond());
        System.out.println();
    }
}
