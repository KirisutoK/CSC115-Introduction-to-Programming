package Classes;

// Creation Date: July 25, 2026. at 10:22 PM
// Last Modified: July 27, 2026. at  5:37 PM

import java.util.Random;

public class Question {
    //=======VARIABLES=======//
    Random random = new Random();

    // [MAIN VARIABLES]
    private String Prompt;
    private double PromptAnswer;
    private char CorrectAnswer; // DEFAULT IS UPPERCASE
    private char UserAnswer; // THIS IS AUTOMATICALLY CONVERTED INTO UPPERCASE FOR DEFAULT\
    private boolean AnsweredCorrectly;

    // [OPERATIONAL VARIABLES]

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Question() { // CREATES A RANDOMIZED QUESTION
        // MAKING THE QUESTION (RANDOMIZING IT)
        int num1 = random.nextInt(500)+1; // Starts from 1 and ends at 500
        int num2 = random.nextInt(500)+1; // Starts from 1 and ends at 500
        String[] operators = {"+", "-", "*", "/"}; // an array of operators (this will be randomized
        String selectedOperator = operators[random.nextInt(4)]; // Starts from 0 to 3 (4 in total)
        Prompt = num1 + selectedOperator + num2;

        // CALCULATING THE CORRECT ANSWER
        switch (selectedOperator) {
            case "+": PromptAnswer = num1 + num2; break;
            case "-": PromptAnswer = num1 - num2; break;
            case "*": PromptAnswer = num1 * num2; break;
            case "/": PromptAnswer = (num2 != 0) ? (double)num1/num2 : 0; break; // THIS IS A TERNARIES OR SOMETHING
        }
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public boolean answerQuestion(char userAnswer) {
        // SETTING IT UP
        UserAnswer = Character.toUpperCase(UserAnswer);
        double[] RandomizeOptions = generateOptions();

        // DISPLAYING THE QUESTION
        System.out.println("Question: "+Prompt+" = ??");
        System.out.println("A. "+RandomizeOptions[0]);
        System.out.println("B. "+RandomizeOptions[1]);
        System.out.println("C. "+RandomizeOptions[2]);
        System.out.println("D. "+RandomizeOptions[3]);

        // PROCESSING THE USER ANSWER
        boolean ValidAnswer = false;
        while (!ValidAnswer) {
            switch (UserAnswer) {
                case 'A':
                    ValidAnswer = true;
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[0];
                    break;
                case 'B':
                    ValidAnswer = true;
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[0];
                    break;
                case 'C':
                    ValidAnswer = true;
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[0];
                    break;
                case 'D':
                    ValidAnswer = true;
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[0];
                    break;
                default:
                    System.out.println("Please choose A, B, C, D");
                    break;
            }
        }

        return false;
    }

    private double[] generateOptions() {
        double[] GeneratedOptions = new double[4];
        for (double o:GeneratedOptions) {
            o = random.nextDouble(PromptAnswer+10)+PromptAnswer-10; // The chances of the generative wrong answers will be in a range of 10 towards the correct answer
        }
        // [ASSIGNING THE CORRECT PROMPT ANSWER]
        int CorrectAnswerPosition = random.nextInt(4);
        switch (CorrectAnswerPosition) {
            case 0:
                CorrectAnswer = 'A';
                break;
            case 1:
                CorrectAnswer = 'B';
                break;
            case 2:
                CorrectAnswer = 'C';
                break;
            case 3:
                CorrectAnswer = 'D';
                break;
        }
        GeneratedOptions[CorrectAnswerPosition] = PromptAnswer;

        return GeneratedOptions;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}
