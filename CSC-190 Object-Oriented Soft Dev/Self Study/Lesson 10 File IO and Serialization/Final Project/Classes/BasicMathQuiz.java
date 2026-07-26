package Classes;

// Creation Date: July 25, 2026. at 10:21 PM
// Last Modified: July 26, 2026. at  8:58 AM

public class BasicMathQuiz {
    //=======VARIABLES=======//
    Question[] Questions;
    int Score;
    long StartTime;
    int EndTime;
    String Username;
    // ADD TIMER LATER

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BasicMathQuiz(String Username, int Questions) { // Name of the person who took the quiz, How many Questions
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      QUIZ HAS BEEN CREATED!      ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("Username: "+Username);
        this.Username = Username;
        if (Questions > 100) { // If it's greater than 100
            this.Questions = new Question[100];
            System.out.println("Range: 100");
        } else if (Questions < 1) {
            this.Questions = new  Question[1];
            System.out.println("Range: 1");
        } else {
            this.Questions = new Question[Questions];
            System.out.println("Range: "+Questions);
        }
        StartTime = System.currentTimeMillis();
        System.out.println("Start Time: "+);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
