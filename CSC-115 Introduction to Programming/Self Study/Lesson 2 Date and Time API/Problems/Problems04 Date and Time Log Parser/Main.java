// Creation Date: August 20, 2026. at 10:46 PM
// Last Modified: August 20, 2026. at 11:32 PM

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        String[] Logs = {
                "2026-08-01 09:15:00 | Server started",
                "2026-08-10 14:30:00 | User login failed",
                "2026-08-15 08:00:00 | Backup completed",
                "2026-08-20 17:45:00 | Server shutdown"
        };

        logsDateTimeParser(Logs);
        System.out.println();
        System.out.println("Closest Log: "+printClosestLog(Logs));
    }

    // =========================== METHODS =========================== \\
    public static String printLogDateTimeParser(String s) {
        String[] Lines = s.split(" \\| "); // LESSON LEARNED: `|` was treated as an regex OR operator so the `\\` was essential

        // NOTE: "2026-08-01 09:15:00 | Server started" <=================== Example of the log (Input)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(Lines[0], dtf);

        // NOTE: "Friday, August 01 2026 - 09:15 AM"  <=================== Example outcome (Output)
        dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy - hh:mm a"); //... OUTPUT FORMAT

        return ldt.format(dtf)+" | "+Lines[1];
    }
    public static LocalDateTime getLogDateTimeParser(String s) {
        String[] Lines = s.split(" \\| "); // LESSON LEARNED: `|` was treated as an regex OR operator so the `\\` was essential

        // NOTE: "2026-08-01 09:15:00 | Server started" <=================== Example of the log (Input)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return LocalDateTime.parse(Lines[0], dtf);
    }
    public static void logsDateTimeParser(String[] logs) {
        for (String lines:logs) {
            System.out.println(printLogDateTimeParser(lines));
        }
    }
    public static String printClosestLog(String[] logs) {
        LocalDateTime today = LocalDateTime.now(); // LESSON LEARNED: We have to put the value of instance creation in order to avoid recreating `LocalDateTime.now()` and changing its value throughout the process of its recreation
        Duration closestD = Duration.between(getLogDateTimeParser(logs[0]), today);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy - hh:mm a");
        String Output = "";

        for (int i = 0; i < logs.length; i++) {
            String[] Lines = logs[i].split(" \\| "); // LESSON LEARNED: `|` was treated as an regex OR operator so the `\\` was essential

            // NOTE: "2026-08-01 09:15:00 | Server started" <=================== Example of the log (Input)
            LocalDateTime ldt = getLogDateTimeParser(logs[i]);
            Duration d = Duration.between(ldt, today);

            if (d.toSeconds() < closestD.toSeconds()) { // if the selected duration is less than the closest
                closestD = d;

                Output = ldt.format(dtf)+" | "+Lines[1]+" ("+d.toHoursPart()+" hour"+((d.toHoursPart() > 1) ? "s":"")+", "+d.toMinutesPart()+" minutes, "+d.toSecondsPart()+" seconds ago)";
            }
        }

        return Output;
    }
}
