// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: August 29, 2026. at  2:50 AM

import Classess.Menu;
import Misc.ReuseableMethods;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    private static Scanner input = new Scanner(System.in);

    // [OBJECTS]
    private static Menu menu;

    // [USER CONDITIONS]
    private static boolean LockUsername = false;
    private static boolean LockBirthday = false;

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        boolean ApplicationRunning = true;
        while (ApplicationRunning) {
            if (!LockUsername) {
                enterUsername();
                LockUsername = true;
            }
            if (!LockBirthday) {
                enterBirthday();
                LockBirthday = true;
            }


            boolean showingMenu = true;
            while (showingMenu) {
                showingMenu = menu.MainMenu(); //... This runs multiple process
                //... Runs menu.MainMenu()
                //... Returns boolean after the method
            }
            changeProfileMenu(); // this will only run if the user decided to choose the only answer that returns `false` which is the `Change Profile case`.
        }
    }

    // =========================== METHODS =========================== \\
    public static void enterUsername() {
        System.out.print("Enter Username: ");
        menu = new Menu(input.nextLine()); // Assign username
        System.out.println();
    }
    public static void enterBirthday() {
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
                menu.setBirthday(LocalDate.of(Integer.parseInt(Lines[2]), Integer.parseInt(Lines[0]), Integer.parseInt(Lines[1])));

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
    }
    private static void changeProfileMenu() {
        // DISPLAY
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║ Which information would you like to change?       ║");
        System.out.println("╟───────────────────────────────────────────────────╢");
        System.out.println("║ 1. Username                                       ║");
        System.out.println("║ 2. Birthday                                       ║");
        System.out.println("║ 3. Username & Birthday                            ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println();

        // PROCESSING INPUT
        int Answer = ReuseableMethods.getAnswer(1, 3);

        // PROCESSING OUTPUTS
        switch (Answer) {
            case 1:
                LockUsername = false;
                break;
            case 2:
                LockBirthday = false;
                break;
            case 3:
                LockUsername = false;
                LockBirthday = false;
                break;

        }

    }
}

// INITIAL IDEA 1.2:
// Add an exception if a user decides to exit the application because our application is running in an infinite while lopp.
// INITIAL IDEA 1.3:
// Add AES Encryption, Hashing Password
// I am currently using a raw password string and users are able to see it throught the object file.
// This whole cryptography thing will be a whole entire different thing so I am planning to learn it after i finish this project.
// Add AES Encryption, Hashing Password
// I am currently using a raw password string and users are able to see it throught the object file.
// This whole cryptography thing will be a whole entire different thing so I am planning to learn it after i finish this project.