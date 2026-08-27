package Classess;

// Creation Date: August 26, 2026. at 11:59 PM
// Last Modified: August 27, 2026. at  1:23 AM

import java.io.Serializable;
import java.util.HashMap;

public class AgeMileStoneTrackerData implements Serializable {
    //=======VARIABLES=======//
    // [Class Data]
    private static final long serialVersionUID = 1L; // this is for serialization versions of the class

    // [Basic Data]
    private String Username;
    private int Age;
    private String Birthday;
    private String NextBrithday;
    private String TotalDaysAlive;

    // [Milestones Data]
    private HashMap<Integer, String> AgeBasedMilestone = new HashMap<>(); // Age, Message
    private boolean[] DayBasedMileStone = new boolean[44562]; // Maximum limit a human can live
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTrackerData(String Username, int Age, String Birthday, String NextBirthday, String TotalDaysAlive) {
        this.Username = Username;
        this.Age = Age;
        this.Birthday = Birthday;
        this.NextBrithday = NextBirthday;
        this.TotalDaysAlive = TotalDaysAlive;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // [Basic Getters]
    public String getTotalDaysAlive() {
        return TotalDaysAlive;
    }
    public String getNextBrithday() {
        return NextBrithday;
    }
    public String getBirthday() {
        return Birthday;
    }
    public int getAge() {
        return Age;
    }
    public String getUsername() {
        return Username;
    }
    public

    // [Milestone Getters]
    public boolean[] getDayBasedMileStone() {
        return DayBasedMileStone;
    }
    public HashMap<Integer, String> getAgeBasedMilestone() {
        return AgeBasedMilestone;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    // NOTE: Actually thinking of a way on how to modify this data through the data handler
    public void addAgeMilestone() {
    }
    public void removeAgeMilestone() {
    }
    public void editAgeMileStone() {
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    
    // ================================================== OTHER CLASSES ================================================== \\
}
