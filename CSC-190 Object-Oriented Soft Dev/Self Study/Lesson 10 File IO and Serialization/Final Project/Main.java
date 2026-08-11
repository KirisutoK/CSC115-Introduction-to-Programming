// Creation Date: July 25, 2026. at 10:05 PM
// Last Modified: August 10, 2026. at  8:44 PM

import Classes.BasicMathQuiz;
import Exceptions.FinishQuizException;
import Exceptions.InvalidQuestionChoiceException;
import Exceptions.NoLogsException;
import Exceptions.SkipQuizException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    static Scanner input = new Scanner(System.in);
    static BasicMathQuiz BMQ01;
    static boolean isActive = true;
    static boolean ValidInput = false;
    static boolean newQuiz = true;

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        while (isActive) {
            if (newQuiz) {
                startQuiz();
            } else {
                loadQuiz();
            }
            AnswerQuiz();
            EndQuiz();
        }
    }

    // =========================== METHODS =========================== \\
    public static void startQuiz() {
        // [USER QUIZ CONFIGURATIONS]
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║       QUIZ CONFIGURATIONS       ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.print("Username: ");
        String UserName = input.nextLine();
        
        ValidInput = false;
        while (!ValidInput) {
            try {
                System.out.print("Range: ");
                int Range = input.nextInt();
                System.out.println();
                BMQ01 = new BasicMathQuiz(UserName, Range);

                // PRINTING
                System.out.println("╔══════════════════════════════════╗");
                System.out.println("║      QUIZ HAS BEEN CREATED!      ║");
                System.out.println("╚══════════════════════════════════╝");
                System.out.println("Username: " + UserName);
                System.out.println("Range: " + BMQ01.getQuestions().length);

                ValidInput = true;
            } catch (InputMismatchException e) {
                input.nextLine(); // REFRESH LEFTOVER \n (CLEARNING BUFFER)
                System.out.println("ERROR: Range must be a numerical value!");
            }
        }

        // [GENERATE QUESTIONS]
        BMQ01.generateQuestions();
        System.out.println();
    }
    public static void AnswerQuiz() {
        // [START ANSWERING EACH QUESTION]
        int count = 1;
        boolean QuizFinished = false;
        for (BasicMathQuiz.Question q : BMQ01.getQuestions()) {

            // PROCESS USER INPUT
            ValidInput = false ; // If UserFinishQuiz is true, then make this true, if it is false, then make it false.
            while (!ValidInput) {
                try {
                    if (QuizFinished) { // IF USER HAD DECIDED THAT
                        q.answerQuestion('E');
                    } else { // IF USER DID NOT DECIDE TO FINISH QUIZ
                        System.out.println("+=================================+");
                        System.out.print(count + ". ");
                        q.displayQuestion();
                        System.out.println();
                        System.out.print("ANSWER: ");

                        char UserAnswer = input.next().charAt(0);
                        System.out.println();
                        q.answerQuestion(UserAnswer);
                    }

                    ValidInput = true;
                    count++;
                } catch (InvalidQuestionChoiceException e) {
                    System.out.println("ERROR: " + e.getMessage());
                } catch (SkipQuizException e) {
                    System.out.println("[USER] "+BMQ01.getUsername()+" "+e.getMessage()+" "+count);
                    System.out.println();
                    count++;
                    break;
                } catch (FinishQuizException e) {
                    System.out.println("[USER] "+BMQ01.getUsername()+" "+ e.getMessage());
                    System.out.println();
                    QuizFinished = true;
                }
            }
        }

        // [SHOW RESULTS]
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║             RESULTS              ║");
        System.out.println("╚══════════════════════════════════╝");
        BMQ01.displayStatus();

        // [PROCESSING LOG AND SERIALIZATION] <====================== THIS IS WHERE WE ARE GOING TO DO THE LOG AND SERIALIZATION STUFF
        BMQ01.createLog();
    }
    public static void EndQuiz() {
        // [WOULD YOU LIKE TO TRY AGAIN?]
        System.out.println();
        System.out.println();
        System.out.println("[]++++++++++++++++++++++++++++[]");
        System.out.println("Would you like to try again? ");
        System.out.println("1. Yes              2. No");
        System.out.println();

        ValidInput = false;
        while (!ValidInput) {
            try {
                System.out.print("ANSWER: ");
                int InputChoice = input.nextInt();

                switch (InputChoice) {
                    case 1:
                        ValidInput = true;

                        System.out.println();
                        System.out.println("[]++++++++++++++++++++++++++++[]");
                        System.out.println("1. Create New Quiz");
                        System.out.println("2. Create Old Quiz");
                        System.out.println();

                        boolean ValidInput01 = false;
                        while (!ValidInput01) {
                            try {
                                System.out.print("ANSWER: ");
                                int InputChoice01 = input.nextInt();
                                System.out.println();

                                switch (InputChoice01) {
                                    case 1:
                                        newQuiz = true;
                                        ValidInput01 = true;
                                        break;
                                    case 2:
                                        try {
                                            if (BMQ01.getLogFolders().length == 0) { //... THIS IS A SECURITY MEASURE IF THERE ARE NO LOGS THAT EXIST
                                                throw new NoLogsException();
                                            }

                                            newQuiz = false;
                                            ValidInput01 = true;
                                            break;
                                        } catch (NoLogsException e) {
                                            System.out.println("ERROR: THERE ARE CURRENTLY NO LOGS IN THE PROGRAM (IT MAY GOT DELETED)");
                                            newQuiz = true;
                                            ValidInput01 = true;
                                            input.nextLine(); // REFRESHED BUFFER (LEFTOVER \n)
                                            return; // stops the whole method
                                        }
                                    default:
                                        throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("ERROR: please choose between 1 and 2");
                                input.nextLine(); // REFRESHED BUFFER (LEFTOVER \n)
                            }
                        }

                        break;
                    case 2:
                        isActive = false;
                        ValidInput = true;
                        System.out.println();
                        System.out.println("THANK YOU FOR PLAYING!");
                        break;
                    default:
                        throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please choose between 1 and 2");
                input.nextLine();
            }
        }
        input.nextLine();
    }
    public static void loadQuiz() {
        BMQ01.displayHistory();

        System.out.println();
        System.out.println("Which save would you like to load? \n");
        boolean ValidInput01 = false;
        while (!ValidInput01) {
            try {
                System.out.print("Answer: ");
                int PickedIndex = input.nextInt();

                if (PickedIndex < 1 || PickedIndex > BMQ01.getLogFolders().length) {
                    throw new InputMismatchException();
                }

                BMQ01 = BMQ01.loadLog(PickedIndex);

                if (BMQ01 == null) {
                    throw new NullPointerException();
                }

                System.out.println(BMQ01.getLogFolders()[PickedIndex-1].getName()+" has successfully loaded!");
                ValidInput01 = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please select a number from 1 to "+BMQ01.getLogFolders().length);
                input.nextLine(); // REFRESHED BUFFER (LEFTOVER \n)
            } catch (NullPointerException e) {
                System.out.println("ERROR: The selected object is null!");
                input.nextLine();
            }
        }
        System.out.println();
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

