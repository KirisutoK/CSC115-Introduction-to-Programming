// Creation Date: August 18, 2026. at 6:39 PM
// Last Modified: August 18, 2026. at  6:55 PM

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        LocalDate ChristBirthday = LocalDate.of(2006, 12, 5);

        birthdayCalculator(ChristBirthday);

    }

    // =========================== METHODS =========================== \\
    public static void birthdayCalculator(LocalDate birthdate) {
        // [CONFIGURING THE NEXT BIRTHDAY VARIABLE]
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthdate.withYear(today.getYear()); // NOTE: GRABS THE BIRTHDAY'S DATA AND CHANGE THE YEAR TO (TODAY'S Year)
        if (!nextBirthday.isAfter(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        Period pd = Period.between(birthdate, today); // From Birthdate to Today
        long daysUntils = ChronoUnit.DAYS.between(today, nextBirthday); // From Today to the Next Birthday
                    // NOTE: INITIALLY WAS USING PERIOD TO GET THE DAYS BUT GETDAYS METHOD OF PERIOD ONLY RETURNS HOW MANY DAYS IN A YEAR (LEFT OVER)
                    // LESSON LEARNED: CHRONOUNIT IS ANOTHER OBJECT OR UTILS THAT CAN CALCULATE THE TIME PERIOD BETWEEN DATES OR TIME.


        System.out.println("Age: "+pd.getYears());
        System.out.println("Days until next Birthday: "+daysUntils+" Days");
        System.out.println("Birthday Today: "+((birthdate.isEqual(LocalDate.now()))));
    }
}
