package Classess;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: August 29, 2026. at  3:18 AM

import Misc.ReuseableMethods;

import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeMileStoneTracker {
    //=======VARIABLES=======//
    private String Username;
    private LocalDate UserBirthday;
    private LocalDate TodayLD;

    // [MISC]
    Scanner input = new Scanner(System.in);

    // [DYNAMIC VARIABLE]
    private AgeMileStoneTrackerData CurrentAMST_Data; // This will be the current selected object or data (Object)
    private File CurrentFile; // This will be the holder or container of that selected object or data (File)

    // [SECURITY]
    private final int minimumPassword = 5; // must have at least 5 characters
    private final int maximumPassword = 20; // must have at least 20 characters
    private final int specialCharactersPassword = 1; // must have at least 2 special characters
    private final int numbersPassword = 1; // must have at least 1 int characters

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    AgeMileStoneTracker(String Username, LocalDate UserBirthday) {
        this.Username = Username;

        try {
            TodayLD = LocalDate.now();

            // Birthday Check: If Year is greater than `Today's Year`.
            if (UserBirthday.getYear() > TodayLD.getYear()) {
                throw new DateTimeException("Year can not be greater than Today's year, This feature is currently in development. Thank you!");
            }

            this.UserBirthday = UserBirthday;
        } catch (DateTimeException e) {
            throw new DateTimeException(e.getMessage());
        }
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    private int getAge() {
        Period p = Period.between(UserBirthday, TodayLD);

        return p.getYears();
    }
    private long getTotalDaysAlive() {
        return ChronoUnit.DAYS.between(UserBirthday, TodayLD);
    }
    private String getNextBirthday() {
        LocalDate nextBirthday = LocalDate.of(TodayLD.getYear(), UserBirthday.getMonth(), UserBirthday.getDayOfMonth());

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
        return UserBirthday.getMonth()+" "+ UserBirthday.getDayOfMonth()+", "+ UserBirthday.getYear();
    }

    // [FILES/DATA]
    private String getCurrentFileNameOnly() {
        if (CurrentFile == null) {
            return "NULL";
        }

        return ReuseableMethods.fileNameOnly(CurrentFile, 10);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public boolean createFile(String FileName) {
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `AgeMileStoneTracker`
        File AgeMileStoneTrackerFolder = new File(SavesFolder, "AgeMileStoneTracker");
        if (!AgeMileStoneTrackerFolder.exists() || AgeMileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            AgeMileStoneTrackerFolder.mkdir();
        }

        //... UNDER `AgeMileStoneTracker`, Check if it already exists in the list.
        File SaveFile = new File(AgeMileStoneTrackerFolder, FileName+".AMST_Data"); // NOTE: `.AMST_Data` append so that every file will be a `.AMST_Data` file
        if (!SaveFile.exists() || SaveFile.isDirectory()) { // if the SaveFile does not exist or is currently a directory then.
            //... b. Create the password for the file.
            String Password = " "; // `" "` is just a placeholder
            boolean ValidPassword = false;
            while (!ValidPassword) {
                System.out.print("Enter a password for the created file: ");
                Password = input.nextLine();
                System.out.println();
                ValidPassword = ReuseableMethods.passwordValidation(Password, minimumPassword, maximumPassword, specialCharactersPassword, numbersPassword);
            }

            //... c. Create the file and return true.
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SaveFile))) { // NOTE: WE WILL BE USING `.AMST_Data` for the file name of our datas
                CurrentAMST_Data = new AgeMileStoneTrackerData(Username, Password, getAge(), getBirthday(), getNextBirthday(), String.valueOf(getTotalDaysAlive()));
                oos.writeObject(CurrentAMST_Data); // grab the file and put the object in that file
                CurrentFile = SaveFile;
                CurrentAMST_Data.logIn(Password); // this auto logIn's the current selected object as it is created

                System.out.println(FileName+" has been created!");
                System.out.println();
                return true; // true means that it has successfully been created!
            } catch (IOException e) {
                System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
            }
        } else {
            System.out.println(FileName+" already exists! please try another name.");
        }

        //... a. Return false if it exists already.
        return false; // false means that it did not work or something lmao
    }
    public boolean loadFile() {
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `AgeMileStoneTracker`
        File AgeMileStoneTrackerFolder = new File(SavesFolder, "AgeMileStoneTracker");
        if (!AgeMileStoneTrackerFolder.exists() || AgeMileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            AgeMileStoneTrackerFolder.mkdir();
        }

        //... UNDER `AgeMileStoneTracker`.
        File[] SaveFiles = AgeMileStoneTrackerFolder.listFiles();
        //... a. If it has no contents or files in the folder
        if (SaveFiles.length <= 0) {
            System.out.println("[ERROR] There are currently no saved files in the Age MileStone Tracker Folder");
            System.out.println();
            return false; // false means that it did not load successfully
        }
        //... b. displaying the existing saved files
        System.out.println("╒══════════[AGE MILESTONE TRACKER SAVES]════════════╕");
        for (File f:SaveFiles) {
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Name: "+ReuseableMethods.fileNameOnly(f, 10), 53)); // The extra methods are meant to remove the `.txt`
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Size: "+f.length(), 53));
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Date Created: "+ReuseableMethods.getDateCreated(f), 53));
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Last Modified: "+ReuseableMethods.getLastModified(f), 53));
            System.out.println("╞═══════════════════════════════════════════════════╡");
        }
        System.out.println("│[NOTE] Input \"e\" to exit.                          │");
        System.out.println("╘═══════════════════════════════════════════════════╛");
        System.out.println();

        //... c. Grab input
        boolean ValidChosenFile = false;
        while (!ValidChosenFile) {
            System.out.print("Choose which save file would you like to load: ");
            String UserAnswerFileName = input.nextLine();
            File ChosenFile = new File(AgeMileStoneTrackerFolder, UserAnswerFileName+".AMST_Data");

            //... d. Process output
            for (File f:SaveFiles) {
                if (f.getName().equals(ChosenFile.getName())) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ChosenFile))) {

                        //... e. Must log-in in order for the data to load
                        AgeMileStoneTrackerData Temp = (AgeMileStoneTrackerData) ois.readObject();
                        boolean ValidPassword = false;
                        while (!ValidPassword) {
                            System.out.print("Enter Password: ");
                            String UserInputPassword = input.nextLine();
                            ValidPassword = Temp.logIn(UserInputPassword);

                            if (UserInputPassword.equals("e")) { // NOTE: Lowky dont know how to deal with this, initially planning to go back to selecting files but dont know how
                                return false;
                            }
                        }

                        if (ValidPassword) {
                            CurrentAMST_Data = Temp;
                            CurrentFile = ChosenFile;

                            ValidChosenFile = true;
                            System.out.println(ReuseableMethods.fileNameOnly(f, 10)+" has successfully loaded!");
                            System.out.println();

                            return true;
                        }
                    } catch (IOException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    } catch (ClassNotFoundException e) {
                        System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
                    }
                }
            }

            if (UserAnswerFileName.equals("e")) {
                System.out.println();
                return false;
            }
            System.out.println("[ERROR] "+ReuseableMethods.fileNameOnly(ChosenFile, 10)+" does not exists, please try another save file. ");
            System.out.println();
        }

        return false; // false means that it did not load successfully
    }
    public boolean deleteFile() { //! <===================== DELETE FILES WILL NEED TO GO THROUGH THE DELETECONFIRMATION PROCESS BEFORE DELETION RUNS
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `AgeMileStoneTracker`
        File AgeMileStoneTrackerFolder = new File(SavesFolder, "AgeMileStoneTracker");
        if (!AgeMileStoneTrackerFolder.exists() || AgeMileStoneTrackerFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            AgeMileStoneTrackerFolder.mkdir();
        }

        //... UNDER `AgeMileStoneTracker`.
        File[] SaveFiles = AgeMileStoneTrackerFolder.listFiles();
        //... a. If it has no contents or files in the folder
        if (SaveFiles.length <= 0) {
            System.out.println("[ERROR] There are currently no saved files in the Age MileStone Tracker Folder");
            System.out.println();
            return false; // false means that it did not load successfully
        }
        //... b. displaying the existing saved files
        System.out.println("╒══════════[AGE MILESTONE TRACKER SAVES]════════════╕");
        for (File f:SaveFiles) {
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Name: "+ReuseableMethods.fileNameOnly(f, 10), 53)); // The extra methods are meant to remove the `.txt`
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Size: "+f.length(), 53));
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Date Created: "+ReuseableMethods.getDateCreated(f), 53));
            System.out.println(ReuseableMethods.lineAutoSpacing("│ Last Modified: "+ReuseableMethods.getLastModified(f), 53));
            System.out.println("╞═══════════════════════════════════════════════════╡");
        }
        System.out.println("│[NOTE] Input \"e\" to exit.                          │");
        System.out.println("╘═══════════════════════════════════════════════════╛");
        System.out.println();

        //... c. Grab input
        boolean ValidChosenFile = false;
        while (!ValidChosenFile) {
            System.out.print("Choose which save file would you like to load: ");
            String UserAnswerFileName = input.nextLine();
            File ChosenFile = new File(AgeMileStoneTrackerFolder, UserAnswerFileName+".AMST_Data");

            //... d. Process output
            for (File f:SaveFiles) {
                if (f.getName().equals(ChosenFile.getName())) {
                    System.out.println(ReuseableMethods.fileNameOnly(f, 10)+" has been successfully deleted!");
                    System.out.println();
                    f.delete();
                    return true;
                }
            }

            if (UserAnswerFileName.equals("e")) {
                System.out.println();
                return false;
            }
            System.out.println("[ERROR] "+ReuseableMethods.fileNameOnly(ChosenFile, 10)+" does not exists, please try another save file. ");
            System.out.println();
        }

        return false;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public boolean AMST_Menu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║               AGE MILESTONE TRACKER [Main Menu]                 ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+Username, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Age: "+getAge(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Birthdate: "+getBirthday(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: "+getCurrentFileNameOnly(), 67));
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Create File                                                  ║");
        System.out.println("║ 2. Load File                                                    ║");
        System.out.println("║ 3. View File                                                    ║");
        System.out.println("║ 4. Delete File                                                  ║");
        System.out.println("║ 5. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 5);

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:
                boolean ValidName = false;
                while (!ValidName) {
                    System.out.print("Please enter file name: ");
                    String FileName = input.nextLine();
                    ValidName = createFile(FileName);
                }

                AMST_FileMenu();
                break;
            case 2: //! <===================================== YOU LEFT ON THIS METHOD, THINKING ABOUT HOW TO FORMAT THE SIZE INTO EITHER `KB` OR `MB`
                if (!loadFile()) { // if load file returns false (did not load successfully, go back to the AMST_Menu
                    break;
                }

                AMST_FileMenu();
                break;
            case 3:
                if (CurrentAMST_Data != null && CurrentFile != null) { // Note: no need to check if it's logged-in since it needs to be log in when initializing it into the `current` variable
                    AMST_FileMenu();
                } else {
                    System.out.println("[ERROR] User currently has not created or loaded a file.");
                    System.out.println();
                }
                break;
            case 4:

                break;
            case 5:
                if (CurrentAMST_Data != null) {
                    CurrentAMST_Data.logOut(); // logOut when leaving the FileMenu
                }
                return false; // false means it stopped running
        }

        return true; // true means it's still running
    }
    private boolean AMST_FileMenu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                AGE MILESTONE TRACKER [FILE MENU]                ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+CurrentAMST_Data.getUsername(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: "+ReuseableMethods.fileNameOnly(CurrentFile, 10), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ File Size: "+CurrentFile.length(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Date Created: "+ReuseableMethods.getDateCreated(CurrentFile), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Last Modified: "+ReuseableMethods.getLastModified(CurrentFile), 67));
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
        System.out.println("║ 1. View MileStones                                              ║");
        System.out.println("║ 2. Add MileStones                                               ║");
        System.out.println("║ 3. Remove Milestones                                            ║");
        System.out.println("║ 4. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 5);

        // [PROCESSING OUTPUTS]
        switch (Answer) {
            case 1:

                // PRINTS OUT ALL THE MILESTONES (CHRONOLOGICALLY SORTED)
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                return false; // `false` means that this method will now stop running
        }
        return true; // `true` means that this method will keep running
    }

    public boolean deleteFileConfirmation() { //! <=============================== CURRENTLY WORKING ON THIS!!!!!!!!!! (THIS IS WHERE YOU LEFT ATTT!!!!!!!!!!!!!!!!!!!)
        // DISPLAY
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Pease specify which type of delete method would you like to run ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Delete Current File                                          ║");
        System.out.println("║ 2. Delete All Saved File                                        ║");
        System.out.println("║ 3. Delete Selected File                                         ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        return false;
    }
    //===========REUSABLE METHODS===========\\ NOTE: THIS ARE THE SPECIFIC METHODS THAT ARE REPEATEDLY USED ALL OVER THE PROGRAM


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEAS: 1.0
// Given a birthdate, calculates age, next birthday, and upcoming life milestones (e.g. 10,000th day alive, retirement age, etc.)
// with countdowns to each. Reusable in any profile or personal dashboard feature.
//
//