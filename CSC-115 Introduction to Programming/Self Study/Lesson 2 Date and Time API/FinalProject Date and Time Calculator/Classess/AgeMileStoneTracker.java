package Classess;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: August 21, 2026. at 11:35 PM

import Misc.ReuseableMethods;

import java.io.File;
import java.time.*;
import java.util.Scanner;

public class AgeMileStoneTracker {
    //=======VARIABLES=======//
    String Username;
    LocalDate BirthdateLD;
    LocalDateTime TodayLDT;
    LocalDate TodayLD;
    LocalTime TodayLT;

    // [MISC]
    Scanner input = new Scanner(System.in);

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTracker(String Username, int year, int month, int day) {
        this.Username = Username;

        BirthdateLD = LocalDate.of(year, month, day);

        TodayLD = LocalDate.now();
        TodayLDT = LocalDateTime.now();
        TodayLT = LocalTime.now();
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    private String getNextBirthday() {
        LocalDate nextBirthday = LocalDate.of(TodayLD.getYear(), BirthdateLD.getMonth(), BirthdateLD.getDayOfMonth());

        while (nextBirthday.isBefore(TodayLD)) { // while its next birthday is before today
            nextBirthday.plusYears(1);
        }

        Period p = Period.between(TodayLD, nextBirthday);

        return p.getYears()+((p.getYears()>1) ? " Years," : "Year," )+p.getMonths()+((p.getMonths()>1) ? " Months," : " Month,")+p.getDays()+((p.getDays()>1) ? " Days Remaining" : "Day Remaining");
        // NOTE: Lowky this is pretty hard to read but using ternaries are just so satisfying.
    }
    private String getBirthday() {
        return BirthdateLD.getMonth()+" "+BirthdateLD.getDayOfMonth()+" "+BirthdateLD.getYear();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    private void loadFile(File f) {

    }
    private void createFile(File f) {

    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void AMST_Menu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      AGE MILESTONE TRACKER                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println("Username: "+Username);
        System.out.println("Birthdate: "+getBirthday());
        System.out.println("Next Birthday: "+getNextBirthday());
        System.out.println("Total Days Alive: ");
        System.out.println("+==================================================================+");
        System.out.println("1. Create File");
        System.out.println("2. Load File");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 2);

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }
    
    
    
    
    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEAS: 1.0
// Given a birthdate, calculates age, next birthday, and upcoming life milestones (e.g. 10,000th day alive, retirement age, etc.)
// with countdowns to each. Reusable in any profile or personal dashboard feature.
//
// INITIAL IDEAS: 2.0
// Use A txt file to add, remove, modify datas for better serialization, user interface, and readable code.
//