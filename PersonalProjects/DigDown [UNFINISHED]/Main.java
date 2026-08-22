// Creation Date: March 31, 2026. at 10:55 AM
// Last Modified: August 21, 2026. at 11:34 PM

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // ============ CREATING OBJECTS OR INSTANCES ============ \\
        GameObject DigDown01 = new GameObject(); // default is Row:[5] Column:[10]

        // ============ METHODS ============ \\
        System.out.println("Table Height: "+DigDown01.getTableRow());
        System.out.println("Table Row: "+DigDown01.getTableColumn());
        System.out.println(" "); // Space for Readability

        DigDown01.playGame();
    }

    // ============ METHODS TO WORK ON ============ \\

}


// ReuseableMethods to work on:
// Generating random table
// Random generation with new array
//
// Game Functionality:
//
// 1. Ask's user to start game
// 2. displays table 10x15
// 3. there is an odd dot in the upper top middle that stands out and that is the userZ
// 4. tells the user which way to go (Left, right, middle)
// 5. the odd dot changes position on which way the user told them to go.
// 6. each time the whole array shifts, the table generates a random row of array in the bottom.
//
// Game Goal: reaching to the bottom (around 10 blocks down)
//
// Game Logic:
// Bomb = Game Over