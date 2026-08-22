// Creation Date: August 21, 2026. at 12:02 AM
// Last Modified: August 21, 2026. at  9:38 PM

import Classess.Menu;

import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    private static Scanner input = new Scanner(System.in);
    private static Menu menu;

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        startMenu();
    }

    // =========================== METHODS =========================== \\

    public static void startMenu() {
        System.out.print("Enter Username: "); menu = new Menu(input.nextLine());
        System.out.println();

        menu.MainMenu();
    }

}

// INITIAL IDEAS:
//
