package Classess;

// Creation Date: August 21, 2026. at 12:04 AM
// Last Modified: September 07, 2026. at  1:03 AM

import Misc.ReuseableMethods;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.time.*;
import java.util.InputMismatchException;

public class AgeMileStoneTracker {
    //=======VARIABLES=======//
    private String Username;
    private LocalDate UserBirthday;

    // [MISC]

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
        this.UserBirthday = UserBirthday;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

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
        File SaveFile = new File(AgeMileStoneTrackerFolder, FileName + ".AMST_Data"); // NOTE: `.AMST_Data` append so that every file will be a `.AMST_Data` file
        if (!SaveFile.exists() || SaveFile.isDirectory()) { // if the SaveFile does not exist or is currently a directory then.
            //... b. Create the password for the file.
            String Password = " "; // `" "` is just a placeholder
            boolean ValidPassword = false;
            while (!ValidPassword) {
                System.out.print("Enter a password for the created file: ");
                Password = ReuseableMethods.input.nextLine();
                System.out.println();
                ValidPassword = ReuseableMethods.passwordValidation(Password, minimumPassword, maximumPassword, specialCharactersPassword, numbersPassword);
            }

            //... c. Create the file and return true.
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SaveFile))) { // NOTE: WE WILL BE USING `.AMST_Data` for the file name of our datas
                CurrentAMST_Data = new AgeMileStoneTrackerData(Username, Password, UserBirthday);
                oos.writeObject(CurrentAMST_Data); // grab the file and put the object in that file
                CurrentFile = SaveFile;
                CurrentAMST_Data.logIn(Password); // this auto logIn's the current selected object as it is created

                System.out.println(FileName + " has been created!");
                System.out.println();
                return true; // true means that it has successfully been created!
            } catch (IOException e) {
                System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
            }
        } else {
            System.out.println(FileName + " already exists! please try another name.");
        }

        //... a. Return false if it exists already.
        return false; // false means that it did not work or something lmao
    }
    public boolean loadFile() {
        //... a. Print existing Saved Files
        File[] SavedFiles = ReuseableMethods.getSaveFiles("AgeMileStoneTracker");
        if (SavedFiles == null) {
            return false;
        }
        ReuseableMethods.printSavedFiles(SavedFiles, CurrentFile);

        //... b. Grab input
        boolean ValidChosenFile = false;
        while (!ValidChosenFile) {
            System.out.print("Choose which save file would you like to load: ");
            String UserAnswerFileName = ReuseableMethods.input.nextLine();
            File ChosenFile = new File(SavedFiles[0].getParentFile(), UserAnswerFileName + ".AMST_Data");

            //... c. Process output
            for (File f : SavedFiles) {
                if (CurrentFile != null) { // If its not null
                    if (f.getName().equals(ChosenFile.getName()) && ChosenFile.getName().equals(CurrentFile.getName())) {
                        if (!CurrentFile.exists()) {
                            CurrentFile = null;
                            CurrentAMST_Data = null;

                            System.out.println("[ERROR] Current File has been either deleted or moved.");
                        } else {
                            System.out.println(ReuseableMethods.fileNameOnly(ChosenFile, 10) + " has already been loaded (Current File).");
                            System.out.println();
                        }

                        return false; // false means that it did not successfully load
                    }
                }

                if (f.getName().equals(ChosenFile.getName())) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ChosenFile))) {

                        //... d. Must log-in in order for the data to load
                        AgeMileStoneTrackerData Temp = (AgeMileStoneTrackerData) ois.readObject();
                        boolean ValidPassword = false;
                        while (!ValidPassword) {
                            System.out.print("Enter Password: ");
                            String UserInputPassword = ReuseableMethods.input.nextLine();
                            ValidPassword = Temp.logIn(UserInputPassword);

                            if (UserInputPassword.equals("e")) { // NOTE: Lowky dont know how to deal with this, initially planning to go back to selecting files but dont know how
                                return false; // false means that it did not successfully load
                            }
                        }

                        CurrentAMST_Data = Temp;
                        CurrentFile = ChosenFile;

                        ValidChosenFile = true;
                        System.out.println(ReuseableMethods.fileNameOnly(f, 10) + " has successfully loaded!");
                        System.out.println();

                        return true; // true means that it has successfully loaded
                    } catch (FileNotFoundException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                        SavedFiles = ReuseableMethods.getSaveFiles("AgeMileStoneTracker");
                        if (SavedFiles == null) {
                            return false; // false means that it did not successfully load
                        }
                    } catch (IOException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                    }
                }
            }

            if (UserAnswerFileName.equals("e")) {
                System.out.println();
                return false; // false means that it did not successfully load
            }
            System.out.println("[ERROR] " + ReuseableMethods.fileNameOnly(ChosenFile, 10) + " does not exists, please try another save file. ");
            System.out.println();
        }

        return false; // false means that it did not successfully load
    }
    private void deleteSelectedFile() {
        //... a. Print existing Saved Files
        File[] SavedFiles = ReuseableMethods.getSaveFiles("AgeMileStoneTracker");
        if (SavedFiles == null) {
            return;
        }
        ReuseableMethods.printSavedFiles(SavedFiles, CurrentFile);

        //... b. Grab input
        boolean ValidChosenFile = false;
        while (!ValidChosenFile) {
            System.out.print("Choose which save file would you like to delete: ");
            String UserAnswerFileName = ReuseableMethods.input.nextLine();
            File ChosenFile = new File(SavedFiles[0].getParentFile(), UserAnswerFileName + ".AMST_Data");
            System.out.println();

            //... c. Process output
            if (UserAnswerFileName.equals("e")) {
                System.out.println();
                return;
            }

            for (File f : SavedFiles) {
                if (f.getName().equals(ChosenFile.getName())) {
                    if (ChosenFile.getName().equals(CurrentFile.getName())) {
                        if (ReuseableMethods.Confirmation("Delete Current File")) { // if it returned true
                            deleteCurrentFile();
                        }
                    } else {
                        if (ReuseableMethods.Confirmation("Delete Selected File (" + ReuseableMethods.fileNameOnly(f, 10) + ")")) { // if it returned true
                            System.out.println(ReuseableMethods.fileNameOnly(f, 10) + " has been successfully deleted!");
                            System.out.println();
                            f.delete();
                        }
                    }
                    return;
                }
            }
            System.out.println("[ERROR] " + ReuseableMethods.fileNameOnly(ChosenFile, 10) + " does not exists, please try another save file. ");
            System.out.println();
        }
    }
    private void deleteCurrentFile() {
        String CurrentFileName = ReuseableMethods.fileNameOnly(CurrentFile, 10);

        CurrentFile.delete();
        CurrentFile = null;
        CurrentAMST_Data = null;

        System.out.println(CurrentFileName + " has been successfully deleted!");
        System.out.println();
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // [MENUS]
    public boolean AMST_Menu() {
        // [DISPLAY]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║               AGE MILESTONE TRACKER [Main Menu]                 ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Username: " + Username, 67));
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Age: " + ReuseableMethods.getAge(UserBirthday), 67));
        if (CurrentFile == null) {
            System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: NULL", 67));
        } else {
            System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: "+ReuseableMethods.fileNameOnly(CurrentFile, 10), 67));
        }
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
        boolean isRunningFileMenu; // this is just a place holder (I am trying to avoid using many instance of variables of boolean) since variables are shared throughout switch cases.
        switch (Answer) {
            case 1:
                boolean ValidName = false;
                while (!ValidName) {
                    System.out.print("Please enter file name: ");
                    String FileName = ReuseableMethods.input.nextLine();
                    ValidName = createFile(FileName);
                }

                // THIS IS JUST SO THAT THE FILEMENU WILL KEEP SHOWING UNTIL IT RETURNS FALSEs
                isRunningFileMenu = true;
                while (isRunningFileMenu) {
                    isRunningFileMenu = AMST_FileMenu();
                }

                break;
            case 2:
                if (!loadFile()) { // if load file returns false (did not load successfully, go back to the AMST_Menu
                    break;
                }

                // THIS IS JUST SO THAT THE FILEMENU WILL KEEP SHOWING UNTIL IT RETURNS FALSEs
                isRunningFileMenu = true;
                while (isRunningFileMenu) {
                    isRunningFileMenu = AMST_FileMenu();
                }

                break;
            case 3:
                if (CurrentAMST_Data != null && CurrentFile != null) { // Note: no need to check if it's logged-in since it needs to be log in when initializing it into the `current` variable
                    isRunningFileMenu = true;
                    while (isRunningFileMenu) {
                        isRunningFileMenu = AMST_FileMenu();
                    }
                } else {
                    System.out.println("[ERROR] User currently has not created or loaded a file.");
                    System.out.println();
                }
                break;
            case 4:
                if (ReuseableMethods.getSaveFiles("AgeMileStoneTracker") != null) {
                    deleteFileConfirmation();
                }

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
        try {
            // Error Check
            String DateCreation = ReuseableMethods.getDateCreated(CurrentFile); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.
            String LastModified = ReuseableMethods.getLastModified(CurrentFile); // Note: this method throws an error so having this to be in the first process and catch early will not run any print as long as it catches.

            // Print
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("║                AGE MILESTONE TRACKER [FILE MENU]                ║");
            System.out.println("╠═════════════════════════════════════════════════════════════════╣");
            System.out.println(ReuseableMethods.lineAutoSpacing("║ Author: " + CurrentAMST_Data.getUsername(), 67));
            System.out.println(ReuseableMethods.lineAutoSpacing("║ Current File: " + ReuseableMethods.fileNameOnly(CurrentFile, 10), 67));
            System.out.println(ReuseableMethods.lineAutoSpacing("║ File Size: " + CurrentFile.length(), 67));
            System.out.println(ReuseableMethods.lineAutoSpacing("║ Date Created: " + DateCreation, 67));
            System.out.println(ReuseableMethods.lineAutoSpacing("║ Last Modified: " + LastModified, 67));
            System.out.println("╟──[ACTIONS]──────────────────────────────────────────────────────╢ ");
            System.out.println("║ 1. View MileStones                                              ║");
            System.out.println("║ 2. Add Day MileStones                                           ║");
            System.out.println("║ 3. Remove Day Milestones                                        ║");
            System.out.println("║ 4. Add Age MileStones                                           ║");
            System.out.println("║ 5. Remove Age Milestones                                        ║");
            System.out.println("║ 6. Go Back                                                      ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println();
        } catch (NoSuchFileException e) {
            CurrentAMST_Data = null;
            CurrentFile = null;

            System.out.println("[ERROR] Current File has been either deleted or moved.");
            System.out.println();

            return false; // false means that this menu will stop running (called in the parent menu or in the AMST_Menu())
        }

        // [PROCESSING INPUTS]
        int Answer = ReuseableMethods.getAnswer(1, 6);

        // [PROCESSING OUTPUTS]
        boolean ValidInput; // This is just a placeholder for every switch cases to share (The variable are shared when created at a specific case)
        switch (Answer) {

            case 1:
                CurrentAMST_Data.viewData(CurrentFile);
                break;
            case 2:
                ValidInput = false;
                while (!ValidInput) {
                    try {
                        //... a. Processing Input
                        System.out.print("Please enter a day: ");
                        int day = ReuseableMethods.input.nextInt();
                        ReuseableMethods.input.nextLine(); // this refreshes buffer
                        System.out.print("Please enter a message for the day: ");
                        String message = ReuseableMethods.input.nextLine();
                        System.out.println();

                        ValidInput = CurrentAMST_Data.addDayBasedMilestone(day, message); // returns a boolean and processes data at the same time

                        //... b. Processing Output (Serialization)
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CurrentFile)); // enabling serialization to a file (Output)
                        oos.writeObject(CurrentAMST_Data); // serialize the object into the file

                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                    } catch (IOException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                    }
                }
                break;
            case 3:
                // [SECURITY]
                if (CurrentAMST_Data.DayMilestoneIsEmpty()) {
                    System.out.println("There are currently no Day Milestones saved on this!"); // Note: might need to improve bit with this message
                    break;
                }
                
                // [PROCESS]
                ValidInput = false;
                while (!ValidInput) {
                    try {
                        //... a. Processing Input
                        System.out.print("Please enter a day: ");
                        int day = ReuseableMethods.input.nextInt();
                        ReuseableMethods.input.nextLine(); // this refreshes buffer
                        System.out.println();

                        ValidInput = CurrentAMST_Data.removeDayBasedMilestone(day);

                        //... b. Processing Output (Serialization)
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CurrentFile)); // enabling serialization to a file (Output)
                        oos.writeObject(CurrentAMST_Data); // serialize the object into the file

                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                    } catch (IOException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                    }
                }
                break;
            case 4:
                ValidInput = false;
                while (!ValidInput) {
                    try {
                        //... a. Processing Input
                        System.out.print("Please enter an age: ");
                        int age = ReuseableMethods.input.nextInt();
                        ReuseableMethods.input.nextLine(); // this refreshes buffer
                        System.out.print("Please enter a message for the day: ");
                        String message = ReuseableMethods.input.nextLine();
                        System.out.println();

                        ValidInput = CurrentAMST_Data.addAgeBasedMilestone(age, message);

                        //... b. Processing Output (Serialization)
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CurrentFile)); // enabling serialization to a file (Output)
                        oos.writeObject(CurrentAMST_Data); // serialize the object into the file

                        ValidInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                    } catch (IOException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                    }
                }
                break;
            case 5:
                // [SECURITY]
                if (CurrentAMST_Data.AgeMilestoneIsEmpty()) {
                    System.out.println("There are currently no Age Milestones saved on this!"); // Note: might need to improve bit with this message
                    break;
                }

                // [PROCESS]
                ValidInput = false;
                while (!ValidInput) {
                    try {
                        //... a. Processing Input
                        System.out.print("Please enter a age: ");
                        int age = ReuseableMethods.input.nextInt();
                        ReuseableMethods.input.nextLine(); // this refreshes buffer
                        System.out.println();

                        ValidInput = CurrentAMST_Data.removeAgeBasedMilestone(age);

                        //... b. Processing Output (Serialization)
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CurrentFile)); // enabling serialization to a file (Output)
                        oos.writeObject(CurrentAMST_Data); // serialize the object into the file

                    } catch (InputMismatchException e) {
                        System.out.println("[ERROR: InputMismatchException] day must not be a letter, it must be a number or integer.");
                    } catch (IOException e) {
                        System.out.println("[ERROR: " + e.getClass().getSimpleName() + "] " + e.getMessage());
                    }
                }
                break;
            case 6:
                return false; // `false` means that this method will now stop running (there is a variable at AMST_Menu)
        }
        return true; // `true` means that this method will keep running
    }

    // [FILES]
    public void deleteFileConfirmation() {
        // DISPLAY
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Please specify which type of delete method would you like to run? ║");
        System.out.println("╟───────────────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Delete Current File                                            ║");
        System.out.println("║ 2. Delete Selected File                                           ║");
        System.out.println("║ 3. Delete All Saved Files                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // PROCESSING INPUT
        int Answer = ReuseableMethods.getAnswer(1, 3);

        // PROCESSING OUTPUT
        switch (Answer) {
            case 1:
                if ((CurrentAMST_Data != null && CurrentFile != null) && ReuseableMethods.Confirmation("Delete Current File")) {
                    deleteCurrentFile();
                }
                break;
            case 2:
                deleteSelectedFile();
                break;
            case 3:
                System.out.println("Note: `Delete All Saved File` will not delete your current File.");
                File[] SavedFiles = ReuseableMethods.getSaveFiles("AgeMileStoneTracker");
                if (SavedFiles != null && ReuseableMethods.Confirmation("Delete All Saved File")) {
                    for (File f : SavedFiles) {
                        if (CurrentFile != null) { // if it exist
                            if (!(f.getName().equals(CurrentFile.getName()))) { // if the f is equal to the current file
                                f.delete();
                            }
                        } else { // If there is no current file yet.
                            f.delete();
                        }
                    }
                }
                System.out.println("Delete All Saved File has successfully completed!");
                System.out.println();
                break;
        }
    }

    //===========REUSABLE METHODS===========\\ NOTE: THIS ARE THE SPECIFIC METHODS THAT ARE REPEATEDLY USED ALL OVER THE PROGRAM


    // ================================================== OTHER CLASSES ================================================== \\
}

// INITIAL IDEAS: 1.0
// Given a birthdate, calculates age, next birthday, and upcoming life milestones (e.g. 10,000th day alive, retirement age, etc.)
// with countdowns to each. Reusable in any profile or personal dashboard feature.
//
//

// TODO: YOU ARE CURRENTLY ADDING THE FEATURES FOR DATA MANAGEMENT SINCE YOU HAVE FINISH WITH FILE MANAGEMENT