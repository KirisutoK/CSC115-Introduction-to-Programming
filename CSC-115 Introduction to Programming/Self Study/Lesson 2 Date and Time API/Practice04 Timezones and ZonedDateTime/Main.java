// Creation Date: August 16, 2026. at 12:33 PM
// Last Modified: August 17, 2026. at  7:13 PM

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        ZonedDateTime defaultTimeZone = ZonedDateTime.now(ZoneId.systemDefault()); // LESSON LEARNED: THIS TAKES YOUR CURRENT GEOGRAPHIC LOCATION TIED TO YOUR METADATA

        // [PRINTING AND CHANGING TIMEZONES]
        printDateTime(defaultTimeZone);
        defaultTimeZone = defaultTimeZone.withZoneSameInstant(ZoneId.of("Europe/London"));
        printDateTime(defaultTimeZone);
        defaultTimeZone = defaultTimeZone.withZoneSameInstant(ZoneId.of("UTC+08:00"));
        printDateTime(defaultTimeZone);
        defaultTimeZone = defaultTimeZone.withZoneSameInstant(ZoneId.systemDefault());

        // [COMPARING]
        ZonedDateTime zdt01 = defaultTimeZone.withZoneSameInstant(ZoneId.of("Asia/Manila")); // LESSON LEARNED: I have learned that when you do not use the .withZoneSameInstant(), it will initialize a ZDT that is currently created in a milliseconds difference
        ZonedDateTime zdt02 = defaultTimeZone.withZoneSameInstant(ZoneId.of("Japan")); // LESSON LEARNED: If I had to compare both ZonedDateTimes, it will compare the milliseconds of when it was created, not the actual accurate time of comparison between each instance of ZDT.

        printComparison(zdt01, zdt02);
        printComparison(zdt01, defaultTimeZone);
        printComparison(defaultTimeZone, zdt02);

        // [PRINTING OFFSET]
        printOffSet(defaultTimeZone);
        printOffSet(zdt01);
        printOffSet(zdt02);
    }

    // =========================== METHODS =========================== \\
    public static void printDateTime(ZonedDateTime zdt) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy hh:mma");
        System.out.println("Timezone: "+zdt.getZone());
        System.out.println(zdt.format(dtf));
    }
    public static void printComparison(ZonedDateTime zdt01, ZonedDateTime zdt02) {
        if (zdt01.isBefore(zdt02)) {
            System.out.println(zdt01.getZone()+" is before "+zdt02.getZone());
        } else {
            System.out.println(zdt01.getZone()+" is after "+zdt02.getZone());
        }
    }
    public static void printOffSet(ZonedDateTime zdt) {
        System.out.println("Timezone: "+zdt.getZone());
        System.out.println("OffSet: "+zdt.getOffset());
    }
}


// PROMPT:
// Write a program that:
//
// Creates a ZonedDateTime for the current moment in your local timezone.
// Converts it to at least 3 other timezones of your choice and prints each one in a readable formatted output using DateTimeFormatter.
// Takes two hardcoded ZonedDateTime objects in different timezones and checks which one comes first using .isBefore() or .isAfter().
// Prints the offset (e.g. UTC-5) for each timezone using .getOffset().