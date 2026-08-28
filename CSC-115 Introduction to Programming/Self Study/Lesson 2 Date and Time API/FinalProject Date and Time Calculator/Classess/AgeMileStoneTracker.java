package Classess;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: August 27, 2026. at 10:08 PM

import Misc.ReuseableMethods;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeMileStoneTracker {
    //=======VARIABLES=======//
    private String Username;
    private LocalDate BirthdateLD;
    private LocalDate TodayLD;

    // [MISC]
    Scanner input = new Scanner(System.in);

    // [DYNAMIC VARIABLE]
    AgeMileStoneTrackerData CurrentAMST_Data; // This will be the current selected object or data (Object)
    File CurrentFile; // This will be the holder or container of that selected object or data (File)

    // [SECURITY]
    private final int minimumPassword = 5; // must have at least 5 characters
    private final int maximumPassword = 20; // must have at least 20 characters
    private final int specialCharactersPassword = 1; // must have at least 2 special characters
    private final int numbersPassword = 1; // must have at least 1 int characters

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
        BasicFileAttributes metaData; // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
        LocalDateTime LDT;
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        System.out.println("╒══════════[AGE MILESTONE TRACKER SAVES]════════════╕");
        for (File f:SaveFiles) {
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
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Name: "+ReuseableMethods.fileNameOnly(f, 10), 53)); // The extra methods are meant to remove the `.txt`
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Size: "+f.length(), 53));
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Date Created: "+dateCreated, 53));
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Last Modified: "+lastModified, 53));
                System.out.println("╞═══════════════════════════════════════════════════╡");
            } catch (IOException e) {
                System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
            }
        }
        System.out.println("╘═══════════════════════════════════════════════════╛");
        System.out.println();

        //... c. Grab input
        boolean ValidChosenFile = false;
        while (!ValidChosenFile) {
            System.out.print("Choose which save file would you like to load: ");
            File ChosenFile = new File(AgeMileStoneTrackerFolder, input.nextLine()+".AMST_Data");

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
            System.out.println("[ERROR] "+ReuseableMethods.fileNameOnly(ChosenFile, 10)+" does not exists, please try another save file. ");
        }

        return false; // false means that it did not load successfully
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
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Create File                                                  ║");
        System.out.println("║ 2. Load File                                                    ║");
        System.out.println("║ 3. Delete File                                                  ║");
        System.out.println("║ 4. View File                                                    ║");
        System.out.println("║ 5. Go Back                                                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 5);
        System.out.println();

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

                break;
            case 4:

                // NOTE: CurrentAMST_Data and CurrentFile must not be null and should be logged in order for this to call AMST_FileMenu();
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
        System.out.println("║                AGE MILESTONE TRACKER (FILE MENU)                ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: "+CurrentAMST_Data.getUsername(), 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: "+ReuseableMethods.fileNameOnly(CurrentFile, 10), 67));
        System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
        System.out.println("║ 1. View MileStones                                              ║");
        System.out.println("║ 2. Add MileStones                                               ║");
        System.out.println("║ 3. Remove Milestones                                            ║");
        System.out.println("║ 4. Go Back                                                      ║");
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

                break;
            case 3:

                break;
            case 4:
                return false; // `false` means that this method will now stop running
        }
        return true; // `true` means that this method will keep running
    }

    //===========REUSABLE METHODS===========\\ NOTE: THIS ARE THE SPECIFIC METHODS THAT ARE REPEATEDLY USED ALL OVER THE PROGRAM


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEAS: 1.0
// Given a birthdate, calculates age, next birthday, and upcoming life milestones (e.g. 10,000th day alive, retirement age, etc.)
// with countdowns to each. Reusable in any profile or personal dashboard feature.
//
//