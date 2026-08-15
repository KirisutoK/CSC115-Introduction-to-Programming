// Creation Date: June 30, 2026. at 3:13 AM
// Last Modified: August 14, 2026. at  7:57 PM

import Exceptions.ChoiceOutOfBoundsException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    static Scanner input = new Scanner(System.in); //... CLASS OBJECT
    static AgeSorter AgeSorterObject = new AgeSorter(); //... CLASS OBJECT

    // =========================== MAIN =========================== \\ 
    public static void main(String[] args) {
        Introduction();
        while (true) { //... THIS WAS ADDED BECAUSE MY LAST WAY OF CALLING OPTIONS WAS RECURRSIVE (CALLING OPTIONS() INSIDE OF OPTIONS() WHICH POTENTIALLY CAN LEAD INTO A STACKOVERFLOW ERROR).
            Options();
        }

    }

    // =========================== USER INTERFACE METHODS (PRINTING VISUALS) =========================== \\
    public static void Introduction() {
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║    AGE SORTER BY CHRIST AERJIL C. DAMPOG    ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Java Skills in this program include:");
        System.out.println("1. Collections Framework");
        System.out.println("2. Inner Classes");
        System.out.println("3. Enhanced For Loops");
        System.out.println("4. Object-Oriented Programming");
        System.out.println("5. Switches");
        System.out.println("6. Exceptions");
        System.out.println("7. Scanner");
        System.out.println();
        System.out.println("Author: Have Fun!");
        System.out.println();
    }
    public static void Options() {
        // DISPLAY THE OPTIONS
        System.out.println("+======================================================+");

        if (!AgeSorterObject.hasNoGroup()) { // IF WE HAVE NOT MADE A GROUP YET
            AgeSorterObject.displayGrouplessProfilesInformation();
        }
        AgeSorterObject.displayInformation();

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║ 1. Create Profile          4. Create Group           ║");
        System.out.println("║ 2. Remove Profile          5. Remove Group           ║");
        System.out.println("║ 3. Change Profile Age      6. Change Group Range     ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("Choice: ");

        // GRAB THE INPUT
        boolean ValidInput = false;
        int Choice = 0;
        while (!ValidInput) { // While the validInput is false
            try {
                Choice = input.nextInt();

                if (Choice < 1 || Choice > 6) {
                    throw new ChoiceOutOfBoundsException();
                }

                System.out.println();
                input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
                ValidInput = true;
            } catch (ChoiceOutOfBoundsException e) {
                System.out.println();
                System.out.println(e);
                System.out.println();
                System.out.print("Choice: ");
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(e+": Please choose a number of integer!");
                System.out.println();
                System.out.print("Choice: ");
                input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n (THIS PREVENTS FROM THE WHILE LOOP TO TRIGGER AUTOMATICALLY RECIEVING THE SAME INPUT FROM THE PREVIOUS INPUT)
            } catch (Exception e) {
                System.out.println("Unexpected Error: "+e);
                System.out.println();
                System.out.print("Choice: ");
            }
        }

        // OUTPUT OF THE INPUT
        boolean ValidInputChoices = false;
        switch (Choice) {
            case 1: //... CREATING A PROFILE
                System.out.println("╔═════════════════════════╗");
                System.out.println("║  CREATING A PROFILE...  ║");
                System.out.println("╚═════════════════════════╝");

                while (!ValidInputChoices) {
                    try {
                        System.out.print("Name: ");
                        String Name01 = input.nextLine();
                        System.out.print("Age: ");
                        int Age01 = input.nextInt();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
                        System.out.println();

                        AgeSorterObject.addProfile(new AgeSorter.Profile(Name01, Age01));
                        System.out.println();

                        ValidInputChoices = true;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println(e+": Please choose a number of integer!");
                        System.out.println();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n (THIS PREVENTS FROM THE WHILE LOOP TO TRIGGER AUTOMATICALLY RECIEVING THE SAME INPUT FROM THE PREVIOUS INPUT)
                    }
                }

                break;
            case 2: //... REMOVE PROFILE
                System.out.println("╔══════════════════════════╗");
                System.out.println("║  REMOVING A PROFILE...  ║");
                System.out.println("╚══════════════════════════╝");

                while (!ValidInputChoices) {
                    System.out.print("Name: ");
                    String Name02 = input.nextLine();
                    System.out.println();

                    AgeSorterObject.removeProfile(Name02);
                    System.out.println();

                    ValidInputChoices = true;
                }

                break;
            case 3: //... CHANGE PROFILE AGE
                System.out.println("╔═══════════════════════════════╗");
                System.out.println("║  CHANGING A PROFILE'S AGE...  ║");
                System.out.println("╚═══════════════════════════════╝");

                while (!ValidInputChoices) {
                    try {
                        System.out.print("Name: ");
                        String Name02 = input.nextLine();
                        System.out.print("Age: ");
                        int Age02 = input.nextInt();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
                        System.out.println();

                        AgeSorterObject.changeProfileAge(Name02, Age02);
                        System.out.println();

                        ValidInputChoices = true;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println(e+": Please choose a number of integer for both Start Age and End Age!");
                        System.out.println();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n (THIS PREVENTS FROM THE WHILE LOOP TO TRIGGER AUTOMATICALLY RECIEVING THE SAME INPUT FROM THE PREVIOUS INPUT)
                    }
                }
                break;
            case 4: //... CREATE GROUP
                System.out.println("╔═══════════════════════╗");
                System.out.println("║  CREATING A GROUP...  ║");
                System.out.println("╚═══════════════════════╝");

                while (!ValidInputChoices) {
                    try {
                        System.out.print("Group Name: ");
                        String GroupName = input.nextLine();
                        System.out.print("Start Age: ");
                        int GroupStartAge = input.nextInt();
                        System.out.print("End Age: ");
                        int GroupEndAge = input.nextInt();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
                        System.out.println();

                        AgeSorterObject.addGroup(new AgeSorter.Group(GroupName, GroupStartAge, GroupEndAge));
                        System.out.println();

                        ValidInputChoices =  true;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println(e+": Please choose a number of integer for both Start Age and End Age!");
                        System.out.println();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n (THIS PREVENTS FROM THE WHILE LOOP TO TRIGGER AUTOMATICALLY RECIEVING THE SAME INPUT FROM THE PREVIOUS INPUT)
                    }
                }
                break;
            case 5: //... REMOVE GROUP
                System.out.println("╔═══════════════════════╗");
                System.out.println("║  REMOVING A GROUP...  ║");
                System.out.println("╚═══════════════════════╝");

                while (!ValidInputChoices) {
                    System.out.print("Name: ");
                    String GroupName = input.nextLine();
                    System.out.println();

                    AgeSorterObject.removeGroup(GroupName);
                    System.out.println();

                    ValidInputChoices = true;
                }

                break;
            case 6: //... CHANGE GROUP AGE
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║  CHANGING A GROUPS RANGE...  ║");
                System.out.println("╚══════════════════════════════╝");

                while (!ValidInputChoices) {
                    try {
                        System.out.print("Group Name: ");
                        String GroupName = input.nextLine();
                        System.out.print("New Start Age: ");
                        int GroupStartAge = input.nextInt();
                        System.out.print("New End Age: ");
                        int GroupEndAge = input.nextInt();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n
                        System.out.println();

                        AgeSorterObject.changeGroupRange(GroupName, GroupStartAge, GroupEndAge);
                        System.out.println();

                        ValidInputChoices =  true;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println(e+": Please choose a number of integer!");
                        System.out.println();
                        input.nextLine(); // THIS CONSUMES THE LEFTOVER MADE FROM THE LAST SCANNER WHICH IS \n (THIS PREVENTS FROM THE WHILE LOOP TO TRIGGER AUTOMATICALLY RECIEVING THE SAME INPUT FROM THE PREVIOUS INPUT)
                    }
                }
                break;
        }
    }
}


// TODO: check AgeSorter class and then add it here in the main

// Requirements:
// 1. Must use all 3 collections — ArrayList, HashMap, and HashSet — each serving a meaningful and logical purpose
// 2. Must have at least 3 classes outside of StringUtils
// 3. Must demonstrate at least one case where collections work together — not just separately
// 4. Must use each of these methods at least once across your entire project:
//      → add(), remove(), contains() or containsKey(), size(), and a loop through a collection
// 5. Must have a fully working StringUtils.java demonstrating the full system end-to-end
// 6. The system must make real-world logical sense — each collection choice should make sense for why that specific collection was chosen
// 7. Must handle at least one case where a duplicate is rejected and show it in Mai


// INITIAL IDEAS:
//
// Age Sorter:
// Able to create groups based on age customizeably
// using HashSet as the HashSet as the group.
// HashSet but be binded to an int range that can be customized
// Ex:
//  Create new AgeGroup: Teens
//  Teen Group Age Range: From 1 to 3
//
//  When Creating a group that collides with an existing group's age range, decline the creation of the group.
//
// 1. Create a AgeSorter Class
//      a. ArrayList<String> Names
//      b. HashMap<String, String>
//      c. HashSet<String>
// 2.
//