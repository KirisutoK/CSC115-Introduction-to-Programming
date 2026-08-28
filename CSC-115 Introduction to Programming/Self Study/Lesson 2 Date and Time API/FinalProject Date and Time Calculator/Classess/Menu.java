package Classess;

// Creation Date: August 21, 2026. at 12:09 AM
// Last Modified: August 28, 2026. at 12:07 PM

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import Misc.ReuseableMethods;

public class Menu {
    //=======VARIABLES=======//
    // [USER DATA]
    private static String Username;
    private static LocalDate UserBirthday;
    // TODO: I WILL BE MOVING THE BIRTHDAY VARIABLES INTO THE MENU IN ORDER FOR IT TO BE REUSABLE FOR EACH FEATURE.

    // [CLASSES OR APPLICATIONS]
    private static AgeMileStoneTracker AMST;
    private static DayPlanner DP;
    private static MultiTimeZoneMeetingPlanner MTZMP;
    private static SubscriptionTracker ST;
    private static WorkHoursTracker WHT;

    // [MISC]
    static Scanner input = new Scanner(System.in);

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Menu(String Username) {
        this.Username = Username;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setBirthday(LocalDate UserBirthday) {
        this.UserBirthday = UserBirthday;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public boolean MainMenu() {


        // DISPLAY
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      DATE AND TIME CALCULATOR 1.0                      ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 74));
        System.out.println("║                                                                        ║");
        System.out.println("║ 1. Age MileStone Tracker             4. Subscription Tracker           ║");
        System.out.println("║ 2. Day Planner                       5. Work Hours Tracker             ║");
        System.out.println("║ 3. Multi-TimeZone Tracker            6. Change Username                ║");
        System.out.println("║                                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        

        // PROCESSING INPUTS
        int Answer = ReuseableMethods.getAnswer(1, 6); // CustomUtil.getAnswer(start, end);
        System.out.println();

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1:
                AMST = new AgeMileStoneTracker(Username, UserBirthday); //! <================= YOU LEFT HERE, NEED TO CHECK IF THE CHANGES OF MOVING THE BIRTHDAY VARIABLE INTO MENU IS OKAY OR NOT

                boolean FeatureRunning = true;
                while (FeatureRunning) {
                    FeatureRunning = AMST.AMST_Menu(); //... This runs multiple process
                            //... Runs the Method
                            //... Returns boolean
                }

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                return false; // This returns `false` because it means that user choose an execution where a method to go back? (Lowky confused with the logic here)
            default:
                System.out.println("[ERROR] Invalid Answer in MainMenu Method");
                break;

        }
        return true; // Only Case 6 of Switch(Answer) will return `false` since its an indication of "Stop" or "Running is False"
    }


    // [AgeMileStoneTracker Methods]
    



    // [DayPlanner Methods]
    // [MultiTimeZoneMeetingPlanner Methods]
    // [SubscriptionTracker Methods]
    // [WorkHoursTracker Methods]


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// This class will manage all the 4 classes and in the future objects too.