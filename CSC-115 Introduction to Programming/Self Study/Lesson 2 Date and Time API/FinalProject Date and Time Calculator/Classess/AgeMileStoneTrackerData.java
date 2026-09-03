package Classess;

// Creation Date: August 26, 2026. at 11:59 PM
// Last Modified: September 03, 2026. at  5:30 PM

import Misc.ReuseableMethods;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class AgeMileStoneTrackerData implements Serializable {
    //=======VARIABLES=======//
    // [Class Data]
    private static final long serialVersionUID = 1L; // this is for serialization versions of the class

    // [Security]
    private String Password; // TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password. (DO THIS AFTER LEARNING HOW TO ENCRYPT AND HASHING [Cryptography Lessons: Not OOP])
    private boolean passwordPassed = false;

    // [Basic Data]
    private String Username;
    private int Age;
    private LocalDate Birthday;
    private LocalDate Today;

    // [Milestones Data]
    private HashMap<Integer, String> AgeBasedMilestone = new HashMap<>(); // Age, Message
    private boolean[] DayBasedMileStone = new boolean[44562]; // Maximum limit a human can live

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTrackerData(String Username, String Password, LocalDate Birthday) {
        this.Username = Username;
        this.Password = Password;
        this.Birthday = Birthday;
        this.Today = LocalDate.now();
        this.Age = ReuseableMethods.getAge(Birthday);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // [Basic Getters]
    public int getAge() {
        if (!passwordPassed) System.out.println("[ERROR] User is not logged in!");
        return (passwordPassed) ? Age: 0;
    }
    public String getUsername() {
        return (passwordPassed) ? Username: "[ERROR] User is not logged in!";
    }
    public String getNextBirthday() {
        LocalDate nextBirthday = LocalDate.of(Today.getYear(), Birthday.getMonth(), Birthday.getDayOfMonth());

        if (nextBirthday.isBefore(Today)) {
            nextBirthday.plusYears(1);
        }

        return nextBirthday.getMonth()+" "+nextBirthday.getDayOfMonth()+" "+nextBirthday.getYear();
    }
    public long getTotalDaysAlive() {
        return ChronoUnit.DAYS.between(Birthday, Today);
    }

    // [Milestone Getters]
    public boolean[] getDayBasedMileStone() {
        return DayBasedMileStone;
    }
    public HashMap<Integer, String> getAgeBasedMilestone() {
        return AgeBasedMilestone;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // [SECURITY]
    public boolean logIn(String input) {
        if (Password.equals(input)) {
            passwordPassed = true;
            return true;
        }

        System.out.println("[ERROR] Invalid Password");
        System.out.println();
        return false;
    }
    public void logOut() {
        passwordPassed = false;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void viewData(File CurrentFile) { //! <========================================================= YOU LEFT AT THIS METHOD!!!!!!!!!!!!!!!!
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ File Name: "+CurrentFile.getName(), 67));
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Age: "+Age, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Next Birthday: "+getNextBirthday(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Total Days Alive: "+getTotalDaysAlive(), 67));
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║                       AGE MILESTONES                            ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        System.out.println();
        System.out.println();

        // TODO: YOU NEED TO FIND A WAY HOW TO DISPLAY THE AGE MILESTONES AND DAY MILESTONES

    }

    
    // ================================================== OTHER CLASSES ================================================== \\
}

// TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password.

// TODO: Actually thinking of a way on how to modify this data through the data handler
// [MODIFIERS]
//public void addAgeMilestone() {
//}
//public void removeAgeMilestone() {
//}
//public void editAgeMileStone() {
//}