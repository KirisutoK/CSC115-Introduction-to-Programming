package Classess;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: August 23, 2026. at  9:22 PM

import Misc.ReuseableMethods;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeMileStoneTracker {
    //=======VARIABLES=======//
    private String Username;
    private LocalDate BirthdateLD;
    private LocalDate TodayLD;

    // [MISC]
    Scanner input = new Scanner(System.in);

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTracker(String Username, int month, int day, int year) {
        this.Username = Username;

        try {
            TodayLD = LocalDate.now();

            // Birthday Check: If Year is greater than `Today's Year`.
            if (year > TodayLD.getYear()) {
                throw new DateTimeException("Year can not be greater than Today's year, This feature is currently in development. Thank you!");
            }
            BirthdateLD = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new DateTimeException(e.getMessage());
        }
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    private int getAge() {
        Period p = Period.between(BirthdateLD, TodayLD);

        return p.getYears();
    }
    private long getTotalDaysAlive() {
        return ChronoUnit.DAYS.between(BirthdateLD, TodayLD);
    }
    private String getNextBirthday() {
        LocalDate nextBirthday = LocalDate.of(TodayLD.getYear(), BirthdateLD.getMonth(), BirthdateLD.getDayOfMonth());

        while (nextBirthday.isBefore(TodayLD)) { // while its next birthday is before today
            nextBirthday.plusYears(1);
        }

        Period p = Period.between(TodayLD, nextBirthday);

        // NAMING CONVENTIONS WITH `S`
        String Year = String.valueOf(p.getYears()+((p.getYears() >= 2) ? " Years": " Year"));
        String Month = String.valueOf(p.getMonths()+((p.getMonths() >= 2) ? " Months": " Month"));
        String DayOfMonth = String.valueOf(p.getDays()+((p.getDays() >= 2) ? " Days": " Day"));

        // CUTTING STRINGS BASED ON DATE
        if (p.getYears() == 0 && p.getMonths() == 0 && p.getDays() == 0) {
            return "TODAY (HAPPY BIRTHDAY!)";
        } else if (p.getYears() == 0 && p.getMonths() == 0) {
            return DayOfMonth+".";
        } else if (p.getYears() == 0) {
            return Month+", "+DayOfMonth+".";
        }

        return p.getYears()+((p.getYears()>1) ? " Years," : " Year, " )+p.getMonths()+((p.getMonths()>1) ? " Months," : " Month,")+p.getDays()+((p.getDays()>1) ? " Days Remaining" : "Day Remaining");
        // NOTE: Lowky this is pretty hard to read but using ternaries are just so satisfying.
    }
    private String getBirthday() {
        return BirthdateLD.getMonth()+" "+BirthdateLD.getDayOfMonth()+", "+BirthdateLD.getYear();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    private void loadFile(String loadFileName) {

    }
    private boolean createFile(String createFileName) {
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `AgeMileStoneTracker`
        File AgeMileStoneTrackerFolder = new File(SavesFolder, "AgeMileStoneTracker");
        if (!AgeMileStoneTrackerFolder.exists() || AgeMileStoneTrackerFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then
            AgeMileStoneTrackerFolder.mkdir();
        }

        //... UNDER `AgeMileStoneTracker`, Check if it already exists in the list.
            //... a. Return false if it exists already.
            //... b. Create the file and return true.
        File SaveFile = new File(AgeMileStoneTrackerFolder, createFileName+".txt"); // NOTE: .txt append so that every file will be a `.txt` file
        if (!SaveFile.exists() || SaveFile.isDirectory()) { // if the SaveFile does not exist or is currently a directory then.
            try {
                SaveFile.createNewFile();
                System.out.println(createFileName+" has been created!");
                return true;
            } catch (IOException e) {
                System.out.println("[ERROR: "+e+"] "+e.getMessage());
            }
        } else {
            System.out.println(createFileName+" already exist! please try another name.");
        }

        return false;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void AMST_Menu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      AGE MILESTONE TRACKER                      ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Age: "+getAge(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Birthdate: "+getBirthday(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Next Birthday: "+getNextBirthday(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Total Days Alive: "+getTotalDaysAlive(), 67));
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
        System.out.println("║ 1. Create File                                                  ║");
        System.out.println("║ 2. Load File                                                    ║");
        System.out.println("║ 3. View Save Files                                              ║"); // NOTE: THINKING OF REMOVING THIS!
        System.out.println("║ 4. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 4);
        while (Answer == 4) { // NOTE: THIS IS A PLACEHOLDER RESPONSE FOR 3, (NEED SOME EXTRA LEARNING WITH THIS)
            System.out.println("This feature is currently in Development, Thank you!");
            Answer = ReuseableMethods.getAnswer(1, 4);
        }

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:
                boolean ValidName = false;

                String FileName = "";
                while (!ValidName) {
                    System.out.print("File Name: ");
                    FileName = input.nextLine();
                    ValidName = createFile(FileName); // NOTE: This runs multiple process
                        //... RUNS CREATE FILE
                        //... CHECK IF FILE ALREADY EXIST
                        //... RETURNS BOOLEAN IF THE FILE HAS BEEN CREATED OR NOT
                }

                AMST_FileMenu(FileName);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                // NOTE: I HAVE NO IDEA HOW TO DO THIS BUT LEARNING IT WILL BE SUPER AMAZING!
                break;
            default:
                break;
        }
    }
    public void AMST_FileMenu(String FileName) { //! <========================= YOU LEFT ON THIS SPOT (THINKING OF ADDING THE FEATURE SOF MODYING THE FILE AND THEN ADDING THE FEATURE TO LOAD UP A FILE.

        // NOTE: THERE IS NO FEATURES FOR THIS ONE YET, EVERYTHING IS IN DEVELOPMENT
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                AGE MILESTONE TRACKER (FILE MENU)                ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: "+FileName, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Next Milestone: IN PROGRESS", 67));
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
        System.out.println("║ 1. View MileStones                                              ║");
        System.out.println("║ 2. Add MileStones                                               ║");
        System.out.println("║ 3. Remove Milestones                                            ║");
        System.out.println("║ 4. Next MileStones                                              ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    
    
    
    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEAS: 1.0
// Given a birthdate, calculates age, next birthday, and upcoming life milestones (e.g. 10,000th day alive, retirement age, etc.)
// with countdowns to each. Reusable in any profile or personal dashboard feature.
//
// INITIAL IDEAS: 1.1
// Use A txt file to add, remove, modify datas for better serialization, user interface, and readable code.
//