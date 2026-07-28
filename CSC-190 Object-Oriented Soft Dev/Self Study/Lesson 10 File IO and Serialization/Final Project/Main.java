// Creation Date: July 25, 2026. at 10:05 PM
// Last Modified: July 27, 2026. at 10:42 PM

import Classes.BasicMathQuiz;
import Exceptions.InvalidQuestionChoiceException;
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

        // [GENERATE QUESTIONS]
        BMQ01.generateQuestions();
        System.out.println();

        // [START ANSWERING EACH QUESTION]
        int count = 1;
        for (BasicMathQuiz.Question q: BMQ01.getQuestions()) {
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
                }
            }
        }

        // [SHOW RESULTS]
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