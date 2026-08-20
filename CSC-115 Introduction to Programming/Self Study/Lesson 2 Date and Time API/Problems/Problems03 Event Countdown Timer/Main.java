// Creation Date: August 19, 2026. at 11:32 PM
// Last Modified: August 20, 2026. at 12:43 AM

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        Event E01 = new Event("Birthday Party", LocalDateTime.of(2026, 12, 5, 20, 0, 0));
        Event E02 = new Event("Christmas Party", LocalDateTime.of(2026, 8, 20, 19, 30, 0));
        Event E03 = new Event("Welcome Party", LocalDateTime.of(2026, 8, 31, 12, 0, 0));
        Event E04 = new Event("Game Party", LocalDateTime.of(2027, 3, 1, 0, 0, 0));
        Event E05 = new Event("STUPID Party", LocalDateTime.of(2026, 1, 20, 19, 30, 0));

        Event[] events = {E01, E02, E03, E04, E05};


        System.out.println("=================== EVENTS ===================");
        printEvent(E01);
        printEvent(E02);
        printEvent(E03);
        printEvent(E04);
        printEvent(E05);

        System.out.println("=================== EVENTS (SORTED) ===================");
        printSortedEvent(events);
    }

    // =========================== METHODS =========================== \\
    public static void printEvent(Event event) {
        // CALCULATE PERIOD
        LocalDateTime today = LocalDateTime.now();
        Duration d = event.getDuration(today);

        // PRINT
        if (!d.isNegative()) {
            System.out.println("Name: "+event.getName()+((d.toHours() < 168) ? " (SOON!) ": ""));
        } else {
            System.out.println("Name: "+event.getName()+" (PASSED)");
        }
        System.out.println("Time Remaining: "+d.toDaysPart()+" Days, "+d.toHoursPart()+" Hours, "+d.toMinutesPart()+" Minutes, "+d.toSecondsPart()+" Seconds.");
        System.out.println();
    }

    public static void printSortedEvent(Event[] events) {
        // CALCULATE AND SORT (SOONEST TO LATEST)
        LocalDateTime today = LocalDateTime.now();
        Event tempEvent; // NOTE: Used as a placeholder to enable swapping of value of arrays

        for (int i = 0; i < events.length; i++) { // Will be using Selection Sort
            for (int j = i+1; j < events.length; j++) {
                Duration d1 = events[i].getDuration(today); //... Creates duration (First Selection)
                Duration d2 = events[j].getDuration(today); //... Creates duration (Second Selection)

                if (d1.toHours() > d2.toHours()) { // IF FIRST SELECTION TOTAL HOURS IS GREATER THAN THE SECOND SELECTION TOTAL HOURS THEN SWAP
                    tempEvent = events[i];
                    events[i] = events[j];
                    events[j] = tempEvent;
                }
            }


        }

        // PRINT
        for (Event e:events) {
            if (e.getTimeRemaining(today) > 0) {
                printEvent(e);
            }
        }
        for (Event e:events) {
            if (e.getTimeRemaining(today) < 0) {
                printEvent(e);
            }
        }
    }
}

// NOTE: In the printSortedEvent, i used the Selection Sort as its sorting method and the Selection Sort method is my main sorting method.
// NOTE: I am planning to change my main sorting method as I learn more about Data Structures.