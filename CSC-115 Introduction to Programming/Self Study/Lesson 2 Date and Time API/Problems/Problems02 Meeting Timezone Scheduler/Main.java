// Creation Date: August 19, 2026. at 6:47 PM
// Last Modified: August 19, 2026. at  7:08 PM

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        ZonedDateTime zdt01 = ZonedDateTime.now(ZoneId.of("America/New_York"));

        timezoneScheduler(zdt01);
    }

    // =========================== METHODS =========================== \\
    public static void timezoneScheduler(ZonedDateTime zdt) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");

        System.out.println("=========== TIMEZONE MEETINGS ===========");
        // TIMEZONE 0 (Original)
        System.out.println("Timezone: "+zdt.getZone()+" (Original Timezone)");
        System.out.println("Meeting Time: "+zdt.format(dtf));
        System.out.println("Day of the Week: "+zdt.getDayOfWeek());
        System.out.println("Status: "+((zdt.getHour() < 9 || zdt.getHour() > 17) ? "Outside Business Hours" : "Open Business Hours")); // Note: since Local Time uses 24 hour format, we have to add up 12 + 5 to.
        System.out.println();

        // TIMEZONE 1 (Japan)
        zdt = zdt.withZoneSameInstant(ZoneId.of("Japan"));
        System.out.println("Timezone: "+zdt.getZone());
        System.out.println("Meeting Time: "+zdt.format(dtf));
        System.out.println("Day of the Week: "+zdt.getDayOfWeek());
        System.out.println("Status: "+((zdt.getHour() < 9 || zdt.getHour() > 17) ? "Outside Business Hours" : "Open Business Hours")); // Note: since Local Time uses 24 hour format, we have to add up 12 +
        System.out.println();


        // TIMEZONE 2 (Asia/Manila)
        zdt = zdt.withZoneSameInstant(ZoneId.of("Asia/Manila"));
        System.out.println("Timezone: "+zdt.getZone());
        System.out.println("Meeting Time: "+zdt.format(dtf));
        System.out.println("Day of the Week: "+zdt.getDayOfWeek());
        System.out.println("Status: "+((zdt.getHour() < 9 || zdt.getHour() > 17) ? "Outside Business Hours" : "Open Business Hours")); // Note: since Local Time uses 24 hour format, we have to add up 12 +
        System.out.println();


        // TIMEZONE 3 (Israel)
        zdt = zdt.withZoneSameInstant(ZoneId.of("Israel"));
        System.out.println("Timezone: "+zdt.getZone());
        System.out.println("Meeting Time: "+zdt.format(dtf));
        System.out.println("Day of the Week: "+zdt.getDayOfWeek());
        System.out.println("Status: "+((zdt.getHour() < 9 || zdt.getHour() > 17) ? "Outside Business Hours" : "Open Business Hours")); // Note: since Local Time uses 24 hour format, we have to add up 12 +
        System.out.println();


    }
}
