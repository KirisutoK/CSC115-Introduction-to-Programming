// Creation Date: August 15, 2026. at 11:38 AM
// Last Modified: August 15, 2026. at 12:36 PM

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        LocalDateTime Now = LocalDateTime.now();
        LocalDateTime SpecificLDT = LocalDateTime.of(2006, 12, 5, 12, 0, 0);

        System.out.println(Formatter01(Now));
        System.out.println(Formatter02(Now));
        System.out.println(Formatter01(SpecificLDT));
        System.out.println(Formatter02(SpecificLDT));
        System.out.println();

        LocalDateTime ParsedLDT01 = Parser01("05/06/2006 12:00");
        LocalDateTime ParsedLDT02 = Parser02("Tuesday, December 06 2067"); // NOTE: IF THE DAY OF THE WEEK (TUESDAY) WERE MONDAY, IT WOULD THROW A `DATETIMEXCEPTION`

        System.out.println(Formatter01(ParsedLDT01));
        System.out.println(Formatter02(ParsedLDT01));
        System.out.println(Formatter01(ParsedLDT02));
        System.out.println(Formatter02(ParsedLDT02));
        System.out.println();
    }

    // =========================== METHODS =========================== \\
    public static String Formatter01(LocalDateTime LDT) {
        return LDT.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
    }
    public static String Formatter02(LocalDateTime LDT) {
        return LDT.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy"));
    }

    public static LocalDateTime Parser01(String mmddyyyy_HHMM) {
        return LocalDateTime.parse(mmddyyyy_HHMM, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")); 
    }
    public static LocalDateTime Parser02(String EEEE_MMMMddyyyy) {
        LocalDate parsedLD = LocalDate.parse(EEEE_MMMMddyyyy, DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy")); //... <================== parse in this scenario only returns Date and not time.
        return parsedLD.atStartOfDay(); //... <==================== attaches 00:00 as the time (HELP WITH CLAUDE)
    }
}
