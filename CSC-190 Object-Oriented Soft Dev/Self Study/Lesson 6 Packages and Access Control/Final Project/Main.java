// Creation Date: June 02, 2026. at 2:13 PM
// Last Modified: August 14, 2026. at  7:57 PM

import Family.*;
import Rules.*;

public class Main {
    public static void main(String[] args) {
        //=======CREATING CLASSES=======//
        FamilyMember FMember01 = new FamilyMember("Christ", "Son", 19);
        FamilyMember FMember02 = new FamilyMember("Bella", "Mother", 36);

        //=======FAMILY STUFF=======//

        // [ADDING RULES]
        FMember01.addRules("PLEASE WASH THE DISH!", "UNTIL THERE IS NO MORE DISHES IN THE SINK");
        FMember01.addRules("Wipe the mirrors", "until is shiny and shimmering");
        FMember01.addRules("Clean the toilet", "after using it");
        FMember01.addRules("Take the dog out", 1.3);
        FMember02.addRules("NO COMPUTER!", 24);
        System.out.println(); // Space for Readability

        DatabaseManager.displayRules();
        System.out.println(); // Space for Readability

        // [REMOVING RULES]
        FMember02.removeRules(3);
        FMember02.removeRules(1);
        FMember02.removeRules(0);
        System.out.println(); // Space for Readability

        DatabaseManager.displayRules();

        //=======RELATIVE STUFF=======//
        Relative Relative01 = new Relative("Carlo", "Cousin", 24, "Male", 1);

        // [ADDING RULES]
        Relative01.addRules("No Playing"); // AddRules() automatically sorts it into TempRules since most Relatives just visits temporarily
        Relative01.addRules("Relax", 67); // AddRules() automatically sorts it into TempRules since most Relatives just visits temporarily
        System.out.println(); // Space for Readability

        DatabaseManager.displayTempRules();
        System.out.println(); // Space for Readability

        // [REMOVING RULES]
        Relative01.removeRules(0);
        Relative01.removeTempRules(1);

        DatabaseManager.displayTempRules();
        System.out.println(); // Space for Readability
        DatabaseManager.displayRules();

    }
}

// TODO: Requirements:
// TODO:
// TODO: Must have a minimum of 3 packages each with a clear and logical purpose
// TODO: Must demonstrate all 4 access modifiers (public, protected, package-private, private) — each used meaningfully, not just randomly placed
// TODO: Must have at least one package-private class that is hidden from outside packages but used internally by a public class in the same package (the gateway pattern)
// TODO: Must have at least one protected attribute or method that is accessed by a subclass in a different package through inheritance
// TODO: Must have proper import statements wherever classes cross package boundaries
// TODO: Must have a fully working StringUtils.java that demonstrates the system end-to-end
// TODO: Must have at least 6 classes total across all packages
// TODO: The system must make real-world logical sense — classes and their relationships should feel natural


// MY MISTAKES:
// SHOULD HAVE THOUGHT THAT DATABASE ONLY HAS DATAS
// SHOULD HAVE THOUGHT THAT IF THERE IS A DATABASE, IT SHOULD BE PACKAGE-PRIVATE OR PRIVATE AND LET ANOTHER CLASS (DATABASEMANAGEMENT) TO HANDLE ALL THE ADDING/REMOVING/CHANGING OF THE DATAS TO MAKE IT EXTRA SECURE
//
// TAKEAWAY:
// it was a good project for 2 days. it definetely had learning alot with this lesson and i did not regret anything to what i said to professor claude about my complaints about the last activity.
// I am very happy and satisfied with all of this activities.
//
 // Thank you, Professor Claude!