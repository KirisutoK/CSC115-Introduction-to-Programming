package Misc;// Creation Date: August 21, 2026. at 10:50 PM
// Last Modified: August 30, 2026. at  8:50 AM

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReuseableMethods {
    //=======VARIABLES=======//
    static Scanner input = new Scanner(System.in);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public static int getAnswer(int start, int end) {
        boolean ValidAnswer = false; //... Placeholders
        int Answer = 0; //... Placeholders
        while (!ValidAnswer) {
            try {
                System.out.print("Answer: ");
                Answer = input.nextInt();
                input.nextLine(); // Refreshes buffer
                if (Answer < start || Answer > end) {
                    throw new InputMismatchException();
                }

                ValidAnswer = true;
            } catch (InputMismatchException e) {
                System.out.println("Please choose between "+start+" through "+end);
                input.nextLine(); // Refreshes buffer
            }
        }
        System.out.println();

        return Answer;
    }
    public static String lineAutoSpacing(String line, int width) {
        // DISPLAY
        int totalWidth = width;
        int spacesNeeded = Math.max(0, totalWidth - line.length() - 1); // NOTE: (spacesNeeded = totalWidth - prefixLength - usernameLength - 1) <========= FORMULA BY CLAUDE
        String padding = " ".repeat(spacesNeeded);

        return line + padding + line.toCharArray()[0];
    }
    public static boolean passwordValidation(String Password, int minimum, int maximum, int specialCharacters, int Numbers){

        // Count how many Characters, how many special characters, and numbers
        int CharacterCounts = 0;
        int SpecialCaracterCounts = 0;
        int NumberCharacterCounts = 0;
        for (int i = 0; i < Password.length(); i++) {
            CharacterCounts++;

            // If the character is a special character
            if (!(Character.isLetterOrDigit(Password.charAt(i)) || Character.isWhitespace(Password.charAt(i)))) {
                SpecialCaracterCounts++;
            }

            // If the character is a number
            if (Character.isDigit(Password.charAt(i))) {
                NumberCharacterCounts++;
            }
        }

        // Do Checks
        if (!((CharacterCounts >= minimum && CharacterCounts <= maximum) && SpecialCaracterCounts >= specialCharacters && NumberCharacterCounts >= Numbers)) {
            System.out.println("[ERROR] Invalid Password! must have:");
            System.out.println(minimum+" minimum characters,");
            System.out.println(maximum+" maximum characters,");
            System.out.println(specialCharacters+" special characters minimum,");
            System.out.println(Numbers+" number characters minimum.");
            return false;
        }


        return true;
    }
    public static String fileNameOnly(File file, int TypeWidth) {
        return file.getName().substring(0, file.getName().length() - TypeWidth);
    }
    public static boolean Confirmation(String process) {
        // DISPLAY
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(ReuseableMethods.lineAutoSpacing("║ Are you sure you would like to confirm \""+process+"\"?", 85));
        System.out.println("╟───────────────────────────────────────────────────────────────────────────────────╢");
        System.out.println("║ 1. Yes                                     2. No                                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // PROCESSING INPUT
        int Answer = ReuseableMethods.getAnswer(1, 2);

        // PROCESSING OUTPUT
        return Answer == 1; // if it's 1, return true, else false
    }

    // [FILE MANAGEMENT]
    public static void printSavedFiles(File[] savedFiles, File currentFile) {
        // Check if its null
        if (savedFiles == null) {
            System.out.println("[ERROR] Saved Files is empty!");
            System.out.println("[METHOD] printSavedFiles(File[] savedFiles)");
            System.out.println();
            return;
        }

        // Print
        System.out.println("╒══════════[AGE MILESTONE TRACKER SAVES]════════════╕");
        for (File f:savedFiles) {
            if (currentFile != null) {
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Name: "+ReuseableMethods.fileNameOnly(f, 10)+((f.getName().equals(currentFile.getName())) ? " (CURRENT FILE)":""), 53)); // The extra methods are meant to remove the `.txt
            } else {
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Name: "+ReuseableMethods.fileNameOnly(f, 10), 53)); // The extra methods are meant to remove the `.txt`
            }
            try {
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Size: "+f.length(), 53));
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Date Created: "+ReuseableMethods.getDateCreated(f), 53));
                System.out.println(ReuseableMethods.lineAutoSpacing("│ Last Modified: "+ReuseableMethods.getLastModified(f), 53));
            } catch (NoSuchFileException e) { // Note: I feel like we will never run into this because savedFiles are called every single time to double check so it's impossible to delete a file in nanoseconds while this method runs
                System.out.println("[ERROR: NoSuchFileException] "+e.getMessage());
            }

            System.out.println("╞═══════════════════════════════════════════════════╡");
        }
        System.out.println("│[NOTE] Input \"e\" to exit.                          │");
        System.out.println("╘═══════════════════════════════════════════════════╛");
        System.out.println();
    }
    public static File[] getSaveFiles(String ApplicationSavesFolderName) {
        //... CHECK THE DIRECTORY OF `Saves`
        File SavesFolder = new File("Saves");
        if (!SavesFolder.exists() || SavesFolder.isFile()) { // if the path does not exist or there is an existing file called "Saves" then.
            SavesFolder.mkdir();
        }

        //... UNDER DIRECTORY OF `Saves`, CREATE ANOTHER DIRECTORY CALLED `AgeMileStoneTracker`
        File ApplicationSavesFolder = new File(SavesFolder, ApplicationSavesFolderName);
        if (!ApplicationSavesFolder.exists() || ApplicationSavesFolder.isFile()) { // if the path does not exists or there is an existing file called "Saves" then
            ApplicationSavesFolder.mkdir();
        }

        //... UNDER `AgeMileStoneTracker`.
        File[] SaveFiles = ApplicationSavesFolder.listFiles();
        //... If it has no contents or files in the folder
        if (SaveFiles == null || SaveFiles.length < 1) {
            System.out.println("[ERROR] There are currently no saved files in the Age MileStone Tracker Folder");
            System.out.println();
            return null; // false means that it did not load successfully
        }

        return SaveFiles;
    }

    // [BIRTHDAYS]
    public static String toStringBirthday(LocalDate Birthday) {
        return Birthday.getMonth()+" "+ Birthday.getDayOfMonth()+", "+ Birthday.getYear();
    }

    // [METADATA]
    public static String getDateCreated(File f) throws NoSuchFileException { // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        //... METADATA
        try {
            BasicFileAttributes metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
                                                                            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
                                                                            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
                                                                            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

            //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
            LocalDateTime LDT = LocalDateTime.ofInstant(metaData.creationTime().toInstant(), ZoneId.systemDefault());
            return LDT.format(DTF);
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }

        return null;
    }
    public static String getLastModified(File f) throws NoSuchFileException{
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma");

        //... METADATA
        try {
            BasicFileAttributes metaData = Files.readAttributes(f.toPath(), BasicFileAttributes.class); // NOTE: <================= THIS IS NEW AND WAS NOT PART OF THE LESSON (THANKS TO CLAUDE FOR HELPING ME OUT GET METADATA INFORMATION FROM A FILE)
                                                                            // NOTE: ^ is a standard class similar to `Integer.class` or `String.class`.
                                                                            // LESSON LEARNED: NIO stands for New Input Output, its the advanced class for IO
                                                                            // LESSON LEARNED: BasicFileAttirbutes.class can read an attribute of a file.

            //... FORMATTING THE METADATA TO BE READABLE (METADATAS CONSIST OF LONG VALUES)
            LocalDateTime LDT = LocalDateTime.ofInstant(metaData.lastModifiedTime().toInstant(), ZoneId.systemDefault());
            return LDT.format(DTF);
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR: "+e.getClass().getSimpleName()+"] "+e.getMessage());
        }

        return null;
    }



    // ================================================== OTHER CLASSES ================================================== \\
}

// NOTE: THIS IS JUST TO STORE METHODS THAT ARE UNIVERSALLY USED THROUGHOUT CLASSES
// NOTE: THIS IS A `REUSABLE METHODS FILE`