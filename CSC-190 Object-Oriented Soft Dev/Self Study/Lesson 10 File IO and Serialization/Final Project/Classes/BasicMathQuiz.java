package Classes;

// Creation Date: July 25, 2026. at 10:21 PM
// Last Modified: August 02, 2026. at 12:59 PM

import Exceptions.FinishQuizException;
import Exceptions.InvalidQuestionChoiceException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BasicMathQuiz {
    //======= CONFIGURABLE VARIABLES=======//
    static final int MAX_QUESTIONS = 100; // CHANGING THIS WILL CHANGE THE MAXIMUM QUESTIONS A USER CAN GENERATE QUESTIONS IN A QUIZ

    //=======VARIABLES=======//
    private Question[] Questions;
    private int Score;
    private String Username;
    // ADD TIMER LATER

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BasicMathQuiz(String Username, int Questions) { // Name of the person who took the quiz, How many Questions
        this.Username = Username;
        if (Questions > MAX_QUESTIONS) { // If it's greater than 100
            this.Questions = new Question[100];
        } else if (Questions < 1) { // If it's less than 1
            this.Questions = new  Question[1];
        } else {
            this.Questions = new Question[Questions];
        }

        // [DEFAULTS]
        // TODO: StartTime = System.currentTimeMillis(); ////////// <================= DO THIS AFTER IMPLEMENTING ALMOST EVERYTHING
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILE
    public String getUsername() {
        return Username;
    }
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

    //! [SERIALIZATION AND I/O FILE] <===================== TRYING TO TEST IT OUT (ITS PRETTY HARD DEBUGGING THIS)
    public void createLog() {
        // FINDING PATH
        String LogFolderPath = "C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Final Project\\Logs";
        File LogFolder = new File(LogFolderPath);

        // COUNTING HOW MANY FOLDERS THERE CURRENTLY ARE
        File[] Logs = LogFolder.listFiles();
        int LogsFoldersCount = 0;
        for (File l:Logs) {
            LogsFoldersCount++;
        }

        // CREATING THE FOLDER FOR THE LOGS(.txt and .ser) INSIDE THE LOGS FOLDER
        String FolderName;
        if (LogsFoldersCount < 10) { //... THIS IS JUST FOR NUMBERING PURPOSES
            FolderName = "Log0"+LogsFoldersCount;
            LogFolder = new File(LogFolderPath, FolderName);
        } else {
            FolderName = "Log"+LogsFoldersCount;
            LogFolder = new File(LogFolderPath, FolderName);
        }
        LogFolder.mkdir();

        // CREATING THE FILES INSIDE THE LOGS OF LOGS FOLDER
        String FolderPath = LogFolderPath+"\\"+FolderName;
        try {
            LogFolder = new File(FolderPath, "Questions.txt");
            LogFolder.createNewFile();
            LogFolder = new File(FolderPath, "QuizStatus.txt");
            LogFolder.createNewFile();
            LogFolder = new File(FolderPath, "QuizObject.ser");
            LogFolder.createNewFile();
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        // WRITING THE QUESTIONS FOR QUESTIONS.TXT
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FolderPath+"\\Questions.txt"))) {
            // FOR EVERY QUESTION WRITE THE DISPLAY STATUS
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        // WRITING THE QUIZSTATUS FOR QUIZSTATUS.TXT

        // SAVING THE CURRENT STATE OF OBJECT INTO A SER FILE
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
                case "/": PromptAnswer = (double)num1/num2; break;
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
                while (Math.round(PromptAnswer) == Math.round(generatedOptions)) { // WHILE IT IS THE SAME, GENERATE AGAIN UNTIL IT IS NOT THE SAME
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
        public boolean answerQuestion(char userAnswer) throws InvalidQuestionChoiceException, FinishQuizException {
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
                case 'E':
                    throw new FinishQuizException();
                default:
                    throw new InvalidQuestionChoiceException(); // WE ARE GOING TO NEED THIS WHEN SCANNING INPUTS IN THE MAIN METHOD. IF IT THROWS INVALID QUESTION, REPEAT TIL ITS VALID
            }

            // CHECK IF IT ANSWERED CORRECTLY
            return AnsweredCorrectly;
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


// TODO: DO TIME FOR LAST
