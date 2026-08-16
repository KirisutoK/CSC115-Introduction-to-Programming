// Creation Date: August 16, 2026. at 9:12 AM
// Last Modified: August 16, 2026. at 11:27 AM

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        // [DATE]
        LocalDate Birthday = LocalDate.of(2006, 12, 5);
        LocalDate Today = LocalDate.now();

        printAge(Birthday, Today);
        printNextBirthday(Birthday, Today);

        // [TIME]
        LocalTime Now = LocalTime.now();

        calculateHoursPassed(Now, 10);
        calculateHoursWorked(LocalTime.now(), LocalTime.now().plusHours(6).plusMinutes(30));
    }

    // =========================== METHODS =========================== \\
    public static void printAge(LocalDate start, LocalDate end) {
        Period p = Period.between(start, end);

        System.out.println("[ AGE ]");
        System.out.println("Years: "+p.getYears());
        System.out.println("Months: "+p.getMonths());
        System.out.println("Days: "+p.getDays());
    }
    public static void printNextBirthday(LocalDate birthday, LocalDate today) {

        // [CONFIGURING THE NEXT BIRTHDAY VARIABLE]
        LocalDate nextBirthday = birthday.withYear(today.getYear()); // NOTE: GRABS THE BIRTHDAY'S DATA AND CHANGE THE YEAR TO (TODAY'S Year)
        if (!nextBirthday.isAfter(today)) {
            nextBirthday = nextBirthday.plusYears(1); // LESSON LEARNED: we had to do this because Date and Time APIs are `Immutable`
        }

        // [PERIOD (TO CALCULATE BETWEEN `START DATE` AND `END DATE`]
        Period p = Period.between(today, nextBirthday);

        System.out.println("[ NEXT BIRTHDAY ]");
        System.out.println("Years: "+p.getYears());
        System.out.println("Months: "+p.getMonths());
        System.out.println("Days: "+p.getDays());

        

        // TODO:  COMPARE BETWEEN MONTHS AND DAY, IF THE MONTHS AND DAY OF TODAY IS BEFORE THE BIRTHDAY'S MONTH AND DAY, THEN PRINT OUT DIFFERENCE.

    }
    public static void calculateHoursPassed(LocalTime lt ,int HoursAdded) {
        LocalTime ltPlus = lt.plusHours(HoursAdded);

        // CALCULATING THE DURATION
        Duration dr = Duration.between(lt, ltPlus); // LESSON LEARNED: Duration works different to Period, Duration does not have getHours(), getMinutes() so we have to manually calculate those.
        long totalSecondsOfDr = dr.toSeconds();

        long hours   = totalSecondsOfDr / 3600;
        long minutes = (totalSecondsOfDr % 3600) / 60;
        long seconds = totalSecondsOfDr % 60;

        // FORMATTING AND PRINTING THE DURATION
        DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("hh:mm a");

        System.out.println("[ HOURS PASSED ]");
        System.out.println("Start Time: "+lt.format(dtformatter));
        System.out.println("End Time: "+ltPlus.format(dtformatter));
        System.out.println("Time Passed: "+ hours+" hours, "+minutes+" minutes, "+seconds+" seconds.");
    }
    public static void calculateHoursWorked(LocalTime clockIn, LocalTime clockOut) {

        // CALCULATING THE DURATION
        Duration dr = Duration.between(clockIn, clockOut);
        long totalSecondsOfDr = dr.toSeconds();

        long hours   = totalSecondsOfDr / 3600;
        long minutes = (totalSecondsOfDr % 3600) / 60;
        long seconds = totalSecondsOfDr % 60;

        // FORMATING AND PRINTING THE DURATION
        DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("hh:mm a");

        System.out.println("[ TOTAL HOURS WORKED ]");
        System.out.println("Start Time: "+clockIn.format(dtformatter));
        System.out.println("End Time: "+clockOut.format(dtformatter));
        System.out.println("Total Hours: "+hours+" hours, "+minutes+" minutes, "+seconds+" seconds.");
    }
    
}
