
/**
 * MadLibs Lab
 *
 * @author Christ Aerjil Dampog
 * @since Oct 7, 2025
 */

import java.util.Scanner;
import java.util.Random;

public class MadLibs {
    public static void main(String[] args) {
        madLibs();
    }

    public static void madLibs() {

        // ========== INSERT YOUR CODE HERE ==========
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your Favorite School or College?");
        String SCHOOL = scanner.nextLine();

        System.out.println("Pick a Random Number: 1-13");
        int WEATHERDAY = scanner.nextInt();
        String WEATHERDAYRESULT = "";
        if (WEATHERDAY == 1) {
            WEATHERDAYRESULT = "normal";
        } else if (WEATHERDAY == 2) {
            WEATHERDAYRESULT = "rainy";
        } else if (WEATHERDAY == 3) {
            WEATHERDAYRESULT = "sunny";
        } else if (WEATHERDAY == 4) {
            WEATHERDAYRESULT = "cloudy";
        } else if (WEATHERDAY == 5) {
            WEATHERDAYRESULT = "wasted";
        } else if (WEATHERDAY == 6) {
            WEATHERDAYRESULT = "lively";
        } else if (WEATHERDAY == 7) {
            WEATHERDAYRESULT = "lovely";
        } else if (WEATHERDAY == 8) {
            WEATHERDAYRESULT = "depressing";
        } else if (WEATHERDAY == 9) {
            WEATHERDAYRESULT = "lonely";
        } else if (WEATHERDAY == 10) {
            WEATHERDAYRESULT = "sad";
        } else if (WEATHERDAY == 11) {
            WEATHERDAYRESULT = "miserable";
        } else if (WEATHERDAY == 12) {
            WEATHERDAYRESULT = "bizzare";
        } else if (WEATHERDAY == 13) {
            WEATHERDAYRESULT = "bad";      
        } else {
            WEATHERDAYRESULT = "normal";
        }

        System.out.println("Pick a random number: 1-8");
        int ACTIONWORD1 = scanner.nextInt();
        String ACTIONWORD1RESULT = "";
        if (ACTIONWORD1 == 1) {
            ACTIONWORD1RESULT = "walked";
        } else if (ACTIONWORD1 == 2) {
            ACTIONWORD1RESULT = "ran";
        } else if (ACTIONWORD1 == 3) {
            ACTIONWORD1RESULT = "crawled";
        } else if (ACTIONWORD1 == 4) {
            ACTIONWORD1RESULT = "jumped";
        } else if (ACTIONWORD1 == 5) {
            ACTIONWORD1RESULT = "bombed";
        } else if (ACTIONWORD1 == 6) {
            ACTIONWORD1RESULT = "slided";
        } else if (ACTIONWORD1 == 7) {
            ACTIONWORD1RESULT = "dived";
        } else if (ACTIONWORD1 == 8) {
            ACTIONWORD1RESULT = "flew";
        } else {
            ACTIONWORD1RESULT = "walked";
        }

        System.out.println("What is your favorite Class?");
        scanner.nextLine();
        String CLASS = scanner.nextLine();

        System.out.println("Describe what type of kid do you not like?");
        String KID = scanner.nextLine();

        System.out.println("Enter a random number");
        int TIMER = scanner.nextInt();
        Random RANDOMTIMER = new Random(TIMER);

        System.out.println("Pick a random number: 1-7");
        int TIMERTYPE = scanner.nextInt();
        String TIMERTYPERESULT = "";
        if (TIMERTYPE == 1) {
            ACTIONWORD1RESULT = "Second";
        } else if (TIMERTYPE == 2) {
            TIMERTYPERESULT = "Minute";
        } else if (TIMERTYPE == 3) {
            TIMERTYPERESULT = "Hour";
        } else if (TIMERTYPE == 4) {
            TIMERTYPERESULT = "Day";
        } else if (TIMERTYPE == 5) {
            TIMERTYPERESULT = "Week";
        } else if (TIMERTYPE == 6) {
            TIMERTYPERESULT = "Month";
        } else if (TIMERTYPE == 7) {
            TIMERTYPERESULT = "Year";
        } else {
            TIMERTYPERESULT = "Second";
        }

        System.out.println("Type a random heavy object");
        scanner.nextLine();
        String HEAVYOBJECT = scanner.nextLine();

        System.out.println("What day is the best day in your school?");
        String BESTSCHOOLDAY = scanner.nextLine();

        System.out.println("Pick a random number: 1-8");
        int ACTIONWORD2 = scanner.nextInt();
        String ACTIONWORD2RESULT = "";
        if (ACTIONWORD2 == 1) {
            ACTIONWORD2RESULT = "walked";
        } else if (ACTIONWORD2 == 2) {
            ACTIONWORD2RESULT = "ran";
        } else if (ACTIONWORD2 == 3) {
            ACTIONWORD2RESULT = "crawled";
        } else if (ACTIONWORD2 == 4) {
            ACTIONWORD2RESULT = "jumped";
        } else if (ACTIONWORD2 == 5) {
            ACTIONWORD2RESULT = "bombed";
        } else if (ACTIONWORD2 == 6) {
            ACTIONWORD2RESULT = "slided";
        } else if (ACTIONWORD2 == 7) {
            ACTIONWORD2RESULT = "dived";
        } else if (ACTIONWORD2 == 8) {
            ACTIONWORD2RESULT = "flew";
        } else {
            ACTIONWORD2RESULT = "walked";
        }

        System.out.println("Type a random number");
        int RANDOMNUMBER1 = scanner.nextInt();
        Random RANDOMNUMBER = new Random(RANDOMNUMBER1);

        System.out.println("Pick a random number: 1-5");
        int ERA = scanner.nextInt();
        String ERARESULT = "";
        if (ERA == 1) {
            ERARESULT = "Day";
        } else if (ERA == 2) {
            ERARESULT = "Year";
        } else if (ERA == 3) {
            ERARESULT = "Decade";
        } else if (ERA == 4) {
            ERARESULT = "Century";
        } else if (ERA == 5) {
            ERARESULT = "Millennium";
        } else {
            ERARESULT = "Day";
        }

        System.out.println("Pick a random number: 1-8");
        int ACTIONWORD3 = scanner.nextInt();
        String ACTIONWORD3RESULT = "";
        if (ACTIONWORD3 == 1) {
            ACTIONWORD3RESULT = "walked";
        } else if (ACTIONWORD3 == 2) {
            ACTIONWORD3RESULT = "ran";
        } else if (ACTIONWORD3 == 3) {
            ACTIONWORD3RESULT = "crawled";
        } else if (ACTIONWORD3 == 4) {
            ACTIONWORD3RESULT = "jumped";
        } else if (ACTIONWORD3 == 5) {
            ACTIONWORD3RESULT = "bombed";
        } else if (ACTIONWORD3 == 6) {
            ACTIONWORD3RESULT = "slided";
        } else if (ACTIONWORD3 == 7) {
            ACTIONWORD3RESULT = "dived";
        } else if (ACTIONWORD3 == 8) {
            ACTIONWORD3RESULT = "flew";
        } else {
            ACTIONWORD3RESULT = "walked";
        }


        scanner.close();

        System.out.println("        ==========================================================");
        System.out.println("            That one kid in " + SCHOOL);
        System.out.println("        ==========================================================\n");

        System.out.println("So i was in " + SCHOOL + " on a " + WEATHERDAYRESULT + " day and, we " + ACTIONWORD1RESULT + " into " + CLASS + " class.");
        System.out.println("the class started and it was about " + ((RANDOMTIMER.nextInt(1000)+1)) + " " + TIMERTYPERESULT + " in when a random kid, that looked like " + KID + " ran");
        System.out.println("in, grabbed " + HEAVYOBJECT + ", and ran out, never to be seen again. But that's not the end, it's the " + BESTSCHOOLDAY);
        System.out.println("day of the school year. I " + ACTIONWORD2RESULT + " into " + CLASS + " class, " + ((RANDOMTIMER.nextInt(1000)+1)) + " " + TIMERTYPERESULT + "s go by, and at the exact same time");
        System.out.println("As " + ((RANDOMNUMBER.nextInt(1000)+1)) + " " + ERARESULT + " ago, the same kid walks in with " + HEAVYOBJECT + ", puts it back and " + ACTIONWORD3RESULT + "s out again.");

        // One time, I was in school on a normal day, and we walked into French class.
        // The class started,
        // and it was about 10 minutes in when a random kid, probably in grade 10 or 9,
        // ran in, grabbed a
        // desk, and ran out, never to be seen again. But that’s not the end, it’s the
        // last day of the
        // school year. I walk into French class, 10 minutes go by, and at the exact
        // same time as 5 months
        // ago, the same kid walks in with a desk, puts it back and runs out again.

        // ===========================================
    }

}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * Making up the stories and trying it to be the same as what i want it exactly to be. Trying to implement
 * the random numbers utility and trying to be unique and random as possible.
 * 
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 *  The automatic indentation is so usefull which is Shift+Alt+F. My code was very messy because of my story but with the help of that shortcut, 
 *  everything looked clean. Also Scanner is probably the most useful utility in programming, it changes how the user or inputs changes your logical
 *  output.
 * 
 * 
 * 
 */
