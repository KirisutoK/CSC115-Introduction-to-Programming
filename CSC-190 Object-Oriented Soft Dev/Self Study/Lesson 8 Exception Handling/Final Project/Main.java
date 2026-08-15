// Creation Date: June 24, 2026. at 10:01 PM
// Last Modified: August 14, 2026. at  7:57 PM

import Exceptions.*;

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        Bar Bar01 = new Bar("Random's Bar", 5);
        People P01 = new People("Dampog", 19);
        People P02 = new People("Bella", 36);

        //======= ADDING/REMOVING ALCOHOL INTO THE BAR =======//

        // [ADDING ALCOHOL]
        try {
            for (int i = 0; i <= 5; i++) { // ADDS 5 NEW ALCOHOL OF THE SAME TYPE
                Bar01.addAlcohol(new Alcohol("A01", 2, 99.99));
            }
            Bar01.addAlcohol(new Alcohol("Special Strong Alcohol", 67, 6676767.66767));

            // Bar01.addAlcohol(null); //... THIS THROWS AN ERROR

        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        } catch (CollectionFullException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("UNEXPECTED ERROR: "+e);
        } finally {
            System.out.println("Finished Adding Alcohol!");
        }

        // THE ERROR SHOWED THAT IT IS CURRENTLY FULL.. I WILL NOW REMOVE 1 ALCOHOL IN THE LIST AND THEN ADD THE ONE THAT I WANTED TO ADD.
        // Bar01.displayAlcoholCollections();

        // [REMOVING AND ADDING]
        try {
            Bar01.removeAlcohol(4);
            Bar01.addAlcohol(new Alcohol("Special Strong Alcohol", 67, 6676767.66767));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("FINISHED REMOVING ALCOHOL INTO "+Bar01.Name+"'s Collection");
        }

        // AS YOU CAN SEE, THE TRY BLOCKS DID NOT CATCH AN ERROR, AS FOR THIS LINE UNDER THIS COMMENT, I WILL MAKE AN ERROR
        // [2 TYPES OF INDEX ERROR MESSAGE]
        // +[TYPE 1]+
        try {
            Bar01.removeAlcohol(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("ERROR DEBUGGING FINISHED!");
        }
        // +[TYPE 2]+
        try {
            Bar01.removeAlcohol(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("ERROR DEBUGGING FINISHED!");
        }
        // Bar01.displayAlcoholCollections();

        //======= PEOPLE =======//
        // ... THIS THROWS AN ERROR SINCE THIS PERSON IS UNDER 21
        try {
            P01.drinkAlcohol(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ... THIS ALSO THROWS AN ERROR BECAUSE THE PERSON DID NOT ENTER A BAR YET
        try {
            P02.drinkAlcohol(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ... THIS IS A FULLY AUTOMATED CODE WITH NO ERRORS IN IT
        try {
            P02.enterBar(Bar01);
            P02.drinkAlcohol(3);
            P02.leaveBar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(P02.getName()+" has finished its process on getting wasted!");
        }
    }
}




// REQUIREMENTS:
//
// Must have at least 3 custom exception classes that are meaningful and make real-world sense
// Must demonstrate try-catch with multiple catch blocks at least once
// Must use finally at least once in a meaningful way — not just printing "done", it should actually make sense WHY finally is there
// Must use throws in at least 2 method signatures
// Must use throw to manually trigger exceptions in at least 3 different places
// Must have at least 2 classes outside of exception classes
// Must have a fully working StringUtils.java that triggers both successful operations AND each custom exception at least once
// The system must make real-world logical sense — exceptions should represent things that could actually go wrong in that system

// MY INITIAL IDEA:

// BAR object (MANAGER OF OBJECTS{PEOPLE, ALCOHOL} )
// BAR methods will consist of:
//  -> closeBar();
//  -> openBar();
//  -> addAlcohol(Alcohol a);
//  -> removeAlcohol(Alcohol a);
// PEOPLE methods will consist of:
//  -> drinkAlcohol();
//  -> enterBar();
//  -> leaveBar();
// ALCOHOL methods will consist of:
//  ->