// Creation Date: July 25, 2026. at 10:05 PM
// Last Modified: July 29, 2026. at  6:38 PM

import Classes.BasicMathQuiz;
import Exceptions.FinishQuizException;
import Exceptions.InvalidQuestionChoiceException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    static BasicMathQuiz BMQ01 = new BasicMathQuiz("Christ", 10);

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        startQuiz();
    }

    // =========================== METHODS =========================== \\
    public static void startQuiz() {
        Scanner input = new Scanner(System.in);

        // [USER QUIZ CONFIGURATIONS]
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║       QUIZ CONFIGURATIONS       ║");
        System.out.println("╚═════════════════════════════════╝");

        try {
            System.out.print("Username: ");
            String UserName = input.nextLine();

            System.out.print("Range: ");
            int Range = input.nextInt();
            input.nextLine(); // REFRESH LEFTOVER \n (CLEARNING BUFFER)
            System.out.println();
            BMQ01 = new BasicMathQuiz(UserName, Range);

            // PRINTING
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║      QUIZ HAS BEEN CREATED!      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("Username: "+UserName);
            System.out.println("Range: "+BMQ01.getQuestions().length);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        // [GENERATE QUESTIONS]
        BMQ01.generateQuestions();
        System.out.println();

        // [START ANSWERING EACH QUESTION]
        int count = 1;
        boolean QuizFinished = false;
        for (BasicMathQuiz.Question q: BMQ01.getQuestions()) {
            // STOP IF THE USER DECIDEDS TO STOP
            if (QuizFinished) break;

            // SHOW QUESTION
            System.out.println("+=================================+");
            System.out.print(count+". ");
            q.displayQuestion();
            System.out.println();

            // PROCESS USER INPUT
            boolean ValidInput = false;
            while (!ValidInput) {
                try {
                    System.out.print("ANSWER: ");
                    char UserAnswer = input.next().charAt(0);
                    System.out.println();
                    q.answerQuestion(UserAnswer);

                    ValidInput = true;
                    count++;
                } catch (InvalidQuestionChoiceException e) {
                    System.out.println("ERROR: "+e.getMessage());
                } catch (FinishQuizException e) {
                    System.out.println("[USER] "+BMQ01.getUsername()+" "+e.getMessage());
                    System.out.println();
                    QuizFinished = true;
                    break; // stops the for loop?
                }
            }
        }

        // [SHOW RESULTS]
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║             RESULTS║             ║");
        System.out.println("╚══════════════════════════════════╝");
        BMQ01.displayStatus();
    }
}

 // IDEAS
 //
 // RANDOM BASIC MATH QUESTIONS
// Question [CLASS]
// 1. This will be the question to BasicMathQuiz class
// 2. contains variables of correct answer, question, and if either it has answered correctly.
// 3. The question class can be passed around and each question object can be checked if the question has been answered or not.
//
// BasicMathQuiz [CLASS]
// 1. Gives out random quiz
// 2. Must ask who answered the quiz
// 2. specify how many quiz. (60 is Maximum) (Has option to skip or skip all)
// 3. specifcy what type of quiz (either addition, subtraction, division, multiplication or all)
// 4. add a timer or not.
//
// MathQuizDatabase [CLASS]
// 1. Sends the results of BasicMathQuiz (Question[])
// 2. can retrieve the data of the Completed/Failed Quizes but can not change those

// TODO: IMROVE PRINTING VISUALS
//! BUG: WHEN YOU INPUT 'E' AS THE RANGE, IT DOES NOT TRIGGER A SPECIAL CASE SCENARIO, IT TRIGGERS A LOGIC ERROR AND SOMEHOW THE DATA PASSESS THROUGH ANSWER QUESTION FOR LOOP?