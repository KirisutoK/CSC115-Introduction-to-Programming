// Creation Date: August 19, 2026. at 11:33 PM
// Last Modified: August 20, 2026. at 12:36 AM

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {
    //=======VARIABLES=======//
    private String Name;
    private LocalDateTime ldt;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Event(String Name, LocalDateTime ldt) {
        this.Name = Name;
        this.ldt = ldt;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public LocalDateTime getDateTime() {
        return ldt;
    }
    public Duration getDuration(LocalDateTime LDT) {
        return Duration.between(LDT, ldt);
    }
    public long getTimeRemaining(LocalDateTime LDT) {
        Duration d = Duration.between(LDT, ldt);

        return d.toHours();
    }
    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
