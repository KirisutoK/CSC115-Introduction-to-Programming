// Creation Date: August 16, 2026. at 9:12 AM
// Last Modified: August 16, 2026. at  9:39 AM

import java.time.LocalDate;
import java.time.Period;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        LocalDate Birthday = LocalDate.of(2006, 12, 5);
        LocalDate Today = LocalDate.now();

        printAge(Birthday, Today);

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
        Period p = Period.between(birthday, today);

        // TODO:  COMPARE BETWEEN MONTHS AND DAY, IF THE MONTHS AND DAY OF TODAY IS BEFORE THE BIRTHDAY'S MONTH AND DAY, THEN PRINT OUT DIFFERENCE.

    }
}
