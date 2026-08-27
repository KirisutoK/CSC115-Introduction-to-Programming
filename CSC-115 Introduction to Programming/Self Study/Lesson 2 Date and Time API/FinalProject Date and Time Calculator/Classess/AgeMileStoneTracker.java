package Classess;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: August 26, 2026. at 11:36 PM

import Misc.ReuseableMethods;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.file.attribute.*;

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
            nextBirthday = nextBirthday.plusYears(1);
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
    private File loadFile() {
        // [CHECK THE DIRECTORY OF `Saves`]
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        // [UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `AgeMileStoneTracker`]
        File AgeMileStoneTrackerFolder = new File(SavesFolder, "AgeMileStoneTracker");
        if (!AgeMileStoneTrackerFolder.exists() || AgeMileStoneTrackerFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then
            AgeMileStoneTrackerFolder.mkdir();
        }

        // [UNDER `AgeMileStoneTracker`, grab all the files]
        File[] LoadFiles = AgeMileStoneTrackerFolder.listFiles();
        // If there are no files, return false.
        if (LoadFiles == null || LoadFiles.length <= 0) { // the `OR` comparison is to prevent an IO Exception, null prevents if there is no folder created and the other `OR` is for the folder if it exists
            System.out.println("[ERROR] There are currently no saved files in the `Age MileStone Tracker Saves Folder`.");
            return null;
        }

        // [DISPLAY ALL THE FILES]
        BasicFileAttributes metaData; // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
        LocalDateTime LDT;
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        System.out.println("╒══════════[AGE MILESTONE TRACKER SAVES]════════════╕");
        for (File f:LoadFiles) {
            try {
                //... METADATA
                metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
                                                            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
                            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
                            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

                //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
                LDT = LocalDateTime.ofInstant(metaData.creationTime().toInstant(), ZoneId.systemDefault());
                String dateCreated = LDT.format(DTF);
                LDT = LocalDateTime.ofInstant(metaData.lastModifiedTime().toInstant(), ZoneId.systemDefault());
                String lastModified = LDT.format(DTF);

                //... PRINTING
                System.out.println(ReuseableMethods.lineAutoSpacing("║ Name: "+f.getName().substring(0, f.getName().length()-4), 53)); // The extra methods are meant to remove the `.txt`
                System.out.println(ReuseableMethods.lineAutoSpacing("║ Size: "+f.length(), 53));
                System.out.println(ReuseableMethods.lineAutoSpacing("║ Date Created: "+dateCreated, 53));
                System.out.println(ReuseableMethods.lineAutoSpacing("║ Last Modified: "+lastModified,53));
                System.out.println("╟───────────────────────────────────────────────────╢");
            } catch (IOException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            }
        }
        System.out.println("╙───────────────────────────────────────────────────╜");

        // [GET THE ANSWERS] (STRING MATCH)
        File chosenLoadFile = null; // NOTE: `null` is just a placeholder, the value of this `variable` will eventually be reassigned
        boolean validLoadFileName = false;
        while (!validLoadFileName) {
            System.out.print("Choose File (Name): ");
            String chosenLoadFileName = input.nextLine()+".txt";

            chosenLoadFile = ReuseableMethods.getFile(LoadFiles, chosenLoadFileName);

            if (chosenLoadFile == null) {
                System.out.println(chosenLoadFileName+" does not exist in the saves folder of `AgeMileStoneTracker`!");
                System.out.println();
            } else {
                System.out.println(chosenLoadFileName+" has been loaded!");
                validLoadFileName = true;
            }

        }

        return chosenLoadFile;
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
    public boolean AMST_Menu() {
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
        System.out.println("║ 3. Change Birthday                                              ║");
        System.out.println("║ 4. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 4);
        System.out.println();

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:
                // While loop for name checks
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
                System.out.println();

                // While Loop to enable going back in forth (Navigation Feature)
                FileMenuRunningLoop(FileName);

                break;
            case 2: //! <================================== LEFT HERE ON THIS, WE ADDED LoadFile feature.
                // BUG: somehow the current file: `print` show something weird where sometimes it shows the `.txt` and sometimes not.
                // Note: Current File: `FileName` should not show .txt
                // [File Check]
                File loadedFile = loadFile();
                if (loadedFile == null) {
                    break;
                }

                // [File Menu]
                FileMenuRunningLoop(loadedFile.getName());
                break;
            case 3:

                break;
            case 4:
                return false; // false means it stopped running
        }

        return true; // true means it's still running
    }
    private boolean AMST_FileMenu(String FileName) {
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
        System.out.println("║ 5. Go Back (WIP)                                                ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 5);
        System.out.println();

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:
                // PRINTS OUT ALL THE MILESTONES (CHRONOLOGICALLY SORTED)
                break;
            case 2:
                // GRABS THE CURRENT TABLE
                // ADD THE NEW DATA TO THE TABLE
                // SORT OUT THE NEW TABLE
                // REFLECT THE NEW TABLE INTO THE TEXT FILE AND UPDATE IT
                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
                return false; // `false` means that this method will now stop running
        }
        return true; // `true` means that this method will keep running
    }

    //===========REUSABLE METHODS===========\\ NOTE: THIS ARE THE SPECIFIC METHODS THAT ARE REPEATEDLY USED ALL OVER THE PROGRAM
    private void FileMenuRunningLoop(String fileName) {


        boolean FileMenuRunning = true;
        while (FileMenuRunning) {
            FileMenuRunning = AMST_FileMenu(fileName);
            //... RUNS THE FILE MENU METHOD
            //... RETURNS BOOLEAN
        }
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