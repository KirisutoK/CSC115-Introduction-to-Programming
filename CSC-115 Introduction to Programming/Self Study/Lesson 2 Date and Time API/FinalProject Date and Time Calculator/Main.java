// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: August 24, 2026. at 12:10 PM

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
                showingMenu = menu.MainMenu();
            }
            ApplicationRunning = menu.MainMenu(); //... This runs multiple process
                    //... Runs menu.MainMenu()
                    //... Returns boolean after the method
        }
    }

    // =========================== METHODS =========================== \\

    public static void enterUsername() {
        System.out.print("Enter Username: "); menu = new Menu(input.nextLine());
        System.out.println();
    }

}

//! YOU LEFT OFF  AT FIGURING OUT HOW TO MAKE THE USER GO BACK TO WHERE THE USER HAD WENT. INITIAL IDEA OF THIS IS USING A WHILE LOOP FOR THOSE METHODS.

// INITIAL IDEA 1.2:
// Add an exception if a user decides to exit the application because our application is running in an infinite while lopp.