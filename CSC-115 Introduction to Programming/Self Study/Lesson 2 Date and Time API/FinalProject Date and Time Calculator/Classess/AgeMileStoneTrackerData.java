package Classess;

// Creation Date: August 26, 2026. at 11:59 PM
// Last Modified: September 06, 2026. at 10:10 PM

import Misc.ReuseableMethods;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
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
    private HashMap<Integer, String> AgeBasedMilestone; // Age, Message
    private HashMap<Integer, String> DayBasedMilestone; // Day, Message

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTrackerData(String Username, String Password, LocalDate Birthday) {
        this.Username = Username;
        this.Password = Password;
        this.Birthday = Birthday;
        this.Today = LocalDate.now();
        this.Age = ReuseableMethods.getAge(Birthday);
        this.AgeBasedMilestone = new HashMap<>();
        this.DayBasedMilestone = new HashMap<>();
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

    public boolean DayMilestoneIsEmpty() {
        return DayBasedMilestone.isEmpty();
    }
    public boolean AgeMilestoneIsEmpty() {
        return AgeBasedMilestone.isEmpty();
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

    // [MILESTONES]
    public void addDayBasedMilestone(int day, String message) {
        DayBasedMilestone.put(day, message);

        if (DayBasedMilestone.containsKey(day)) {
            System.out.println("(Day: "+day+") {Message: "+message+"} has been successfully overwritten!");
        } else {
            System.out.println("(Day: "+day+") {Message: "+message+"} has been successfully added!");
        }
    }
    public boolean removeDayBasedMilestone(int day) {

        if (DayBasedMilestone.containsKey(day)) {
            DayBasedMilestone.remove(day);
            System.out.println("day "+day+" has been successfully been removed!");
            System.out.println();
            return true; // true means that it has successfully been deleted
        }

        System.out.println("day "+day+" does not exist!");
        return false; // false means that it did get successfully deleted
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void viewData(File CurrentFile) { //! <========================================================= YOU LEFT AT THIS METHOD!!!!!!!!!!!!!!!! (NEED TO WORK ON HOW TO SORT OUT THE DAYS IN ORDER AND AGE TOO)
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ File Name: "+ReuseableMethods.fileNameOnly(CurrentFile, 10)+((AgeBasedMilestone.isEmpty()&&DayBasedMilestone.isEmpty())? " (EMPTY)":""), 67));
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Age: "+Age, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Next Birthday: "+getNextBirthday(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Total Days Alive: "+getTotalDaysAlive(), 67));
        if (!DayBasedMilestone.isEmpty()) {
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println("║                         DAY MILESTONES                          ║");
            System.out.println("╟─────────────────────────────────────────────────────────────────╢");
            for (int d: DayBasedMilestone.keySet()) {
                System.out.println(ReuseableMethods.lineAutoSpacing("║ (Day: "+d+") {Message: "+DayBasedMilestone.get(d)+"} ", 67));
            }
            System.out.println("║                                                                 ║");
        }
        if (!AgeBasedMilestone.isEmpty()) {
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println("║                         AGE MILESTONES                          ║");
            System.out.println("╟─────────────────────────────────────────────────────────────────╢");
            for (int a: AgeBasedMilestone.keySet()) {
                System.out.println(ReuseableMethods.lineAutoSpacing("║ (Age: "+a+") {Message: "+DayBasedMilestone.get(a)+"} ", 67));
            }
            System.out.println("║                                                                 ║");
        }
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"e\" to exit.                                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // It will not run the other methods unless "e" is inputted
        while (true) {
            System.out.print("Answer: ");
            String Answer = ReuseableMethods.input.nextLine();
            System.out.println();

            if (Answer.equals("e")) {
                return;
            }
        }
    }

    
    // ================================================== OTHER CLASSES ================================================== \\
}

// TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password.
// TODO: Remove this todo or line