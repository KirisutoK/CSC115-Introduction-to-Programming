package Classes;

// Creation Date: July 25, 2026. at 10:21 PM
// Last Modified: July 28, 2026. at  5:58 PM

import Exceptions.InvalidQuestionChoiceException;
import java.util.Random;

public class BasicMathQuiz {
    //=======VARIABLES=======//
    Question[] Questions;
    int Score;
    String Username;
    // ADD TIMER LATER

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    //! I AM PLANNING TO REMOVE THE PRINTING STUFF HERE AND MOVE IT INTO MAIN, THAT WAY WE CAN ONLY FOCUS THE CONSTRUCTOR AS BACKEND AND MAKE THE SCANNER METHODS EASIER TO READ!
    public BasicMathQuiz(String Username, int Questions) { // Name of the person who took the quiz, How many Questions
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      QUIZ HAS BEEN CREATED!      ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("Username: "+Username);
        this.Username = Username;
        if (Questions > 100) { // If it's greater than 100
            this.Questions = new Question[100];
            System.out.println("Range: 100");
        } else if (Questions < 1) { // If it's less than 1
            this.Questions = new  Question[1];
            System.out.println("Range: 1");
        } else {
            this.Questions = new Question[Questions];
            System.out.println("Range: "+Questions);
        }

        // [DEFAULTS]
        // TODO: StartTime = System.currentTimeMillis(); ////////// <================= DO THIS AFTER IMPLEMENTING ALMOST EVERYTHING
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILE
    public void countScore() {
        Score = 0;
        for (Question q: Questions) {
            if (q.AnsweredCorrectly) {
                Score++;
            }
        }
    }
    public Question[] getQuestions() {
        return Questions;
    }
    public void saveQuizStatus() {
        countScore();
        System.out.println("User: "+Username);
        System.out.println("Total Score: "+Score+"/"+Questions.length);
        for (Question q:Questions) {
            q.displayStatus();
            System.out.println();
        }
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void generateQuestions() {
        for (int i = 0; i < Questions.length; i++) {
            Questions[i] = new Question();
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayStatus() {
        countScore();
        System.out.println("Username: "+Username);
        System.out.println("Score: "+Score+"/"+Questions.length);
    }


    // ================================================== OTHER CLASSES ================================================== \\
    public static class Question {
        //=======VARIABLES=======//
        Random random = new Random();

        // [MAIN VARIABLES]
        private String Prompt;
        private double PromptAnswer;
        private char CorrectAnswer; // DEFAULT IS UPPERCASE
        private char UserAnswer; // THIS IS AUTOMATICALLY CONVERTED INTO UPPERCASE FOR DEFAULT\
        private boolean AnsweredCorrectly;

        // [OPERATIONAL VARIABLES]
        private double[] RandomizeOptions;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Question() {
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

            // GENERATION THE CHOICES
            RandomizeOptions = generateOptions();
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
        private double[] generateOptions() {
            double[] GeneratedOptions = new double[4];

            // [GENERATING THE WRONG ANSWERS] <=============== CLAUDE HELPED ME FIXING THIS BOUND ERROR
            double range = 10.0;
            for (int i = 0; i < GeneratedOptions.length; i++) {
                double min = PromptAnswer - range;
                double generatedOptions = min + random.nextDouble(range * 2); // The chances of the generative wrong answers will be in a range of 10 towards the correct answer
                while (PromptAnswer == generatedOptions) { // WHILE IT IS THE SAME, GENERATE AGAIN UNTIL IT IS NOT THE SAME
                    generatedOptions = min + random.nextDouble(range * 2);
                }
                GeneratedOptions[i] = generatedOptions;
            }

            // [ASSIGNING THE CORRECT PROMPT ANSWER]
            int CorrectAnswerPosition = random.nextInt(4);
            switch (CorrectAnswerPosition) {
                case 0: CorrectAnswer = 'A'; break;
                case 1: CorrectAnswer = 'B'; break;
                case 2: CorrectAnswer = 'C'; break;
                case 3: CorrectAnswer = 'D'; break;
            }
            GeneratedOptions[CorrectAnswerPosition] = PromptAnswer;

            return GeneratedOptions;
        }
        public boolean getAnsweredCorrectly() {
            return AnsweredCorrectly;
        }


        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public boolean answerQuestion(char userAnswer) throws InvalidQuestionChoiceException {
            // SETTING IT UP
            UserAnswer = Character.toUpperCase(userAnswer);

            // PROCESSING THE USER ANSWER
            switch (UserAnswer) {
                case 'A':
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[0]; // If They are equal or not, return true or false.
                    break;
                case 'B':
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[1]; // If They are equal or not, return true or false.
                    break;
                case 'C':
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[2]; // If They are equal or not, return true or false.
                    break;
                case 'D':
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[3]; // If They are equal or not, return true or false.
                    break;
                default:
                    throw new InvalidQuestionChoiceException(); // WE ARE GOING TO NEED THIS WHEN SCANNING INPUTS IN THE MAIN METHOD. IF IT THROWS INVALID QUESTION, REPEAT TIL ITS VALID
            }

            return false;
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayStatus() {
            System.out.println("Question: "+Prompt+" = ??");
            System.out.println("Correct Answer: "+CorrectAnswer+". "+PromptAnswer);
            System.out.println("User Answer: "+UserAnswer);
            System.out.println("Check: "+AnsweredCorrectly);
        }
        public void displayQuestion() {
            System.out.println("Question: "+Prompt+" = ??");
            if (Prompt.contains("/")) {
                System.out.println("A. "+String.format("%.2f" ,RandomizeOptions[0])) ;
                System.out.println("B. "+String.format("%.2f" ,RandomizeOptions[1]));
                System.out.println("C. "+String.format("%.2f" ,RandomizeOptions[2]));
                System.out.println("D. "+String.format("%.2f" ,RandomizeOptions[3]));
            } else {
                System.out.println("A. "+String.format("%.0f" ,RandomizeOptions[0])) ;
                System.out.println("B. "+String.format("%.0f" ,RandomizeOptions[1]));
                System.out.println("C. "+String.format("%.0f" ,RandomizeOptions[2]));
                System.out.println("D. "+String.format("%.0f" ,RandomizeOptions[3]));
            }
        }


        // ================================================== OTHER CLASSES ================================================== \\
    }
}


//! BUG: THERE WILL BE A CHANCE THAT A DUPLICATE OF  THE CORRECT ANSWER WILL SHOW IN THE OPTIONS (PLEASE REMOVE DUPLICATES OF CORRECT ANSWER)
// TODO: DO TIME FOR LAST
// TODO: THERE IS A
