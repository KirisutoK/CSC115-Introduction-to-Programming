// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: August 27, 2026. at 10:36 AM

import Classess.Menu;

import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    private static Scanner input = new Scanner(System.in);
    private static Menu menu;

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        boolean ApplicationRunning = true;
        while (ApplicationRunning) {
            enterUsername();

            boolean showingMenu = true;
            while (showingMenu) {
                showingMenu = menu.MainMenu(); //... This runs multiple process
                //... Runs menu.MainMenu()
                //... Returns boolean after the method
            }
        }
    }

    // =========================== METHODS =========================== \\

    public static void enterUsername() {
        System.out.print("Enter Username: ");
        menu = new Menu(input.nextLine()); // Assign username
        System.out.println();
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