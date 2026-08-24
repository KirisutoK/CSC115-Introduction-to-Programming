package Classess;

// Creation Date: August 21, 2026. at 12:09 AM
// Last Modified: August 23, 2026. at  9:38 PM

import java.time.DateTimeException;
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
        System.out.println();

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1:
                startAgeMileStoneTracker();

                AMST.AMST_Menu();

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
                System.out.println("[ERROR] Invalid Answer in MainMenu Method");
                break;

        }
    }


    // [AgeMileStoneTracker Methods]
    public static boolean startAgeMileStoneTracker() {
        // PROCESS DATE INPUT
        boolean ValidInput = false;
        while (!ValidInput) {
            try {
                System.out.println("Please enter your Birthday: ");
                System.out.println("(Month DayOfMonth Year) => ex: 12/05/2006");
                System.out.print("Answer: ");
                String Birthday = input.nextLine();

                // LETS SPLIT THEM LINES AND CONVERT IT INTO INTEGERS THEN PASS IT ON
                String[] Lines = Birthday.split("/");

                // ADD THE CONVERTED LINES INTO THE CONSTRUCTOR
                AMST = new AgeMileStoneTracker(Username, Integer.parseInt(Lines[0]), Integer.parseInt(Lines[1]), Integer.parseInt(Lines[2]));

                ValidInput = true;
            } catch (DateTimeException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] Please follow the Date Format which is `MM/DD/YY` or `Month/DayOfMonth/Year`.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] You are missing the required numbers, please enter your Birthday, separating with `/`.");
            } catch (Exception e) {
                System.out.println("[UNEXPECTED ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            } finally {
                System.out.println();
            }
        }

        return ValidInput; // Note: I know that this will always return true, its just that its for readability.
    }
    



    // [DayPlanner Methods]
    // [MultiTimeZoneMeetingPlanner Methods]
    // [SubscriptionTracker Methods]
    // [WorkHoursTracker Methods]


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEA:
// This class will manage all the 4 classes and in the future objects too.