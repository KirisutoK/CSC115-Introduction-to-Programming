package Classess;

// Creation Date: August 26, 2026. at 11:59 PM
// Last Modified: August 29, 2026. at  1:21 PM

import java.io.Serializable;
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
    private String Birthday;
    private String NextBirthday;
    private String TotalDaysAlive;

    // [Milestones Data]
    private HashMap<Integer, String> AgeBasedMilestone = new HashMap<>(); // Age, Message
    private boolean[] DayBasedMileStone = new boolean[44562]; // Maximum limit a human can live

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTrackerData(String Username, String Password, int Age, String Birthday, String NextBirthday, String TotalDaysAlive) {
        this.Username = Username;
        this.Password = Password;
        this.Age = Age;
        this.Birthday = Birthday;
        this.NextBirthday = NextBirthday;
        this.TotalDaysAlive = TotalDaysAlive;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // [Basic Getters]
    public String getTotalDaysAlive() {
        return (passwordPassed) ? TotalDaysAlive: "[ERROR] User is not logged in!";
    }
    public String getNextBirthday() {
        return (passwordPassed) ? NextBirthday: "[ERROR] User is not logged in!";
    }
    public String getBirthday() {
        return (passwordPassed) ? Birthday: "[ERROR] User is not logged in!";
    }
    public int getAge() {
        if (!passwordPassed) System.out.println("[ERROR] User is not logged in!");
        return (passwordPassed) ? Age: 0;
    }
    public String getUsername() {
        return (passwordPassed) ? Username: "[ERROR] User is not logged in!";
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
    public void viewMileStones() {

    } //... WIP

    
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
