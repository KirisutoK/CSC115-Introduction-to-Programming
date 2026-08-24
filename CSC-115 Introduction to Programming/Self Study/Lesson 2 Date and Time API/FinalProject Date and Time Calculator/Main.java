// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: August 23, 2026. at  9:38 PM

import Classess.Menu;

import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    private static Scanner input = new Scanner(System.in);
    private static Menu menu;

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        enterUsername();
        menu.MainMenu();
    }

    // =========================== METHODS =========================== \\

    public static void enterUsername() {
        System.out.print("Enter Username: "); menu = new Menu(input.nextLine());
        System.out.println();
    }

}

//! YOU LEFT OFF  AT FIGURING OUT HOW TO MAKE THE USER GO BACK TO WHERE THE USER HAD WENT. INITIAL IDEA OF THIS IS USING A WHILE LOOP FOR THOSE METHODS.
