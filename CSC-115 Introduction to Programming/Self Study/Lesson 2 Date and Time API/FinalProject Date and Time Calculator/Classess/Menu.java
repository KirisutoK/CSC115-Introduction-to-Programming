package Classess;

// Creation Date: August 21, 2026. at 12:09 AM
// Last Modified: August 22, 2026. at 12:06 AM

import java.util.Scanner;

import Misc.ReuseableMethods;

public class Menu {
    //=======VARIABLES=======//
    private static String Username;

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

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void MainMenu() {
        // DISPLAY
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      DATE AND TIME CALCULATOR 1.0                      ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 74));
        System.out.println("║                                                                        ║");
        System.out.println("║ 1. Age MileStone Tracker             4. Subscription Tracker           ║");
        System.out.println("║ 2. Day Planner                       5. Work Hours Tracker             ║");
        System.out.println("║ 3. Multi-TimeZone Tracker            6. Period/Duration Calculator     ║");
        System.out.println("║                                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        

        // PROCESSING INPUTS
        int Answer = ReuseableMethods.getAnswer(1, 6); // CustomUtil.getAnswer(start, end);

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1:
                startAgeMileStoneTracker();
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
                break;
            default:
                System.out.println("ERROR: Invalid Answer in MainMenu Method");
                break;

        }
    }


    // [AgeMileStoneTracker ReuseableMethods]
    public static void startAgeMileStoneTracker() { //! <====================================   THIS IS WHERE YOU LEFT OFFF!!!!!!!!!
        // PROCESS DATE INPUT

        // INITIALIZE OUTPUT (OBJECT CREATION)


    }
    



    // [DayPlanner ReuseableMethods]
    // [MultiTimeZoneMeetingPlanner ReuseableMethods]
    // [SubscriptionTracker ReuseableMethods]
    // [WorkHoursTracker ReuseableMethods]





    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// This class will manage all the 4 classes and in the future objects too.