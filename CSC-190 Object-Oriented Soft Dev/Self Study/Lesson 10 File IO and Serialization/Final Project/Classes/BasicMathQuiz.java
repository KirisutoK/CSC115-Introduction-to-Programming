package Classes;

// Creation Date: July 25, 2026. at 10:21 PM
// Last Modified: August 09, 2026. at 10:27 PM

import Exceptions.FinishQuizException;
import Exceptions.InvalidQuestionChoiceException;
import Exceptions.SkipQuizException;

import java.io.*;
import java.util.HashSet;
import java.util.Random;

public class BasicMathQuiz implements Serializable {
    //======= CONFIGURABLE VARIABLES=======//
    static final int MAX_QUESTIONS = 100; // CHANGING THIS WILL CHANGE THE MAXIMUM QUESTIONS A USER CAN GENERATE QUESTIONS IN A QUIZ
    static final File LogFolder = new File("Logs");

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
        ensureLogFolder();

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
    public File[] getLogFolders() {
        return LogFolder.listFiles();
    }
    public String getLogObject(File f) {
        return new File(f, "QuizObject.ser").getPath();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void generateQuestions() {
        for (int i = 0; i < Questions.length; i++) {
            Questions[i] = new Question();
        }
    }
    public BasicMathQuiz loadLog(int index) { // This just loads up every single variables of the class and i will be configuring score and questions. only name and range stays
        File SelectedLogObjectFile = new File(getLogObject(getLogFolders()[index-1]));
        BasicMathQuiz SelectedLogObject;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SelectedLogObjectFile))) {
            SelectedLogObject = (BasicMathQuiz) ois.readObject();
            return SelectedLogObject;
            
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        System.out.println("ERROR: Object is null!");
        return null;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayStatus() {
        countScore();
        System.out.println("Username: "+Username);
        System.out.println("Score: "+Score+"/"+Questions.length);
        System.out.println();
        int count = 1;
        for (Question q: Questions) {
            System.out.println(count+". "+(q.AnsweredCorrectly ? "✅" : "❌"));
            count++;
        }
    }
    public void displayHistory() {
        BasicMathQuiz SelectedObject;
        int count = 1;

        System.out.println("+++++++++++++++++++++ HISTORY +++++++++++++++++++++");
        for (File f:getLogFolders()) {
            File ClassObject = new File(getLogObject(f));

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ClassObject))) {
                SelectedObject = (BasicMathQuiz) ois.readObject();
                System.out.println("["+count+"] "+ClassObject.getParentFile().getName());
                System.out.println("Username: "+SelectedObject.getUsername());
                System.out.println("Range: "+SelectedObject.getQuestions().length);
                System.out.println("Total Score: "+SelectedObject.Score+"/"+SelectedObject.getQuestions().length);
                System.out.println();
                count++;
            } catch (IOException e) {
                System.out.println("ERROR: "+e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: "+e.getMessage());
            }
        }
    }
    public void createLog() {
        // CHECK IF WE HAVE A LOG FOLDER
        ensureLogFolder();

        // CHECKING WHAT ARE THE AVAILABLE FOLDER SLOT NUMBERS
        HashSet<Integer> CurrentUsedIndex = new HashSet<>();
                // NOTE: We will be storing numbers in a hashset to avoid gaps when users may delete a log
                // NOTE: If the Log00 and Log02 exist, and then we can do a for loop for every hashset value + 1
                // NOTE: We can check that 01 does not exist and will we create it.
                // NOTE: If all of the folders are correct. then the +1 will create an empty slot to create another loop.
        for (File l:getLogFolders()) { //... THIS CHECKS HOW MANY INDEX ARE CURRENTLY AVAILABLE
            CurrentUsedIndex.add(Integer.valueOf(l.getName().substring(3))); // Get the number of the name of the folder and add it into the hashset
        }

        // ASSIGNING THE NUMBERS INTO THE LOGFOLDER NAME
        String FolderName;
        File LogFolderChildren = null; //... we need to initialize this first since java compiles will return an error
        for (int i = 0; i < CurrentUsedIndex.size()+1; i++ ) { // NOTE: +1 because we need an extra slot to fill in what is missing and what slot on what needs to be created
            if (!CurrentUsedIndex.contains(i)) { // if it does not contain this number then
                if (i < 10) { // IF THE NUMBER IS BELOW 10
                    FolderName = "Log0"+i;
                    LogFolderChildren = new File(LogFolder, FolderName);
                } else {
                    FolderName = "Log"+i;
                    LogFolderChildren = new File(LogFolder, FolderName);
                }
                LogFolderChildren.mkdir();
                break;
            }
        }

        // CREATING THE FILES INSIDE THE LOGS OF LOGS FOLDER
        File QuestionFile = new File(LogFolderChildren, "Questions.txt");
        File QuizObjectFile = new File(LogFolderChildren, "QuizObject.ser");
        try {
            QuestionFile.createNewFile();
            QuizObjectFile.createNewFile();
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        // WRITING THE QUESTIONS FOR QUESTIONS.TXT
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(QuestionFile))) {
            // GENERAL INFORMATION
            bw.write("Username: "+getUsername()); bw.newLine();
            bw.write("Total Score: "+Score+"/"+Questions.length);
            bw.newLine();
            bw.newLine();

            // EACH QUESTIONS
            int Count = 1;
            for (Question q: Questions) {
                bw.write("+----------------------------------------------------+");
                bw.newLine();
                // CHECKING
                if (q.AnsweredCorrectly) {
                    bw.write("✅ ");
                } else {
                    bw.write("❌ ");
                }
                // NUMBERING
                bw.write(Count+". ");
                // QUESTION
                bw.write(q.getQuestionStatus());
                Count++;
            }
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        // SAVING THE CURRENT STATE OF OBJECT INTO A SER FILE
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(QuizObjectFile))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    // [SAFETY MEASURES METHOD]
    public void ensureLogFolder() { //! <===================================== YOU LEFT HERE
        // NOTE: THIS METHOD IS TO ENSURE THAT WE HAVE A FOLDER WHERE WE CAN SAVE THE FOLDER OF LOGS AND PREVENTING DANGEROUS CODE FROM RUNNING

        // CHECK IF WE HAVE LOG FOLDER
        if (!LogFolder.exists()) {
            LogFolder.mkdir();
        }
    }

    // ================================================== OTHER CLASSES ================================================== \\
    public static class Question implements Serializable {
        //=======VARIABLES=======//
        Random random = new Random();

        // [MAIN VARIABLES]
        private String Prompt;
        private double PromptAnswer;
        private char CorrectAnswer; // DEFAULT IS UPPERCASE
        private char UserAnswerCharacter; // THIS IS AUTOMATICALLY CONVERTED INTO UPPERCASE FOR DEFAULT\
        private double UserAnswerNumber;
        private boolean AnsweredCorrectly;
        private boolean Skipped;

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
        public String getQuestionStatus() {
            if (Prompt.contains("/")) {
                return "Question: " +Prompt+" = ?? \n"+
                        "A. "+String.format("%.0f" ,RandomizeOptions[0])+"\n"+
                        "B. "+String.format("%.0f" ,RandomizeOptions[1])+"\n"+
                        "C. "+String.format("%.0f" ,RandomizeOptions[2])+"\n"+
                        "D. "+String.format("%.0f" ,RandomizeOptions[3])+"\n"+
                        "\n"+
                        "Correct Answer: ["+CorrectAnswer+"] "+String.format("%.2f", PromptAnswer)+"\n"+
                        "User Answer: "+((Skipped) ? "SKIPPED \n" : "["+UserAnswerCharacter +"] "+String.format("%.2f", UserAnswerNumber)+"\n"); //... <=========== TERNARIES
            }

            return "Question: " +Prompt+" = ?? \n"+
                    "A. "+String.format("%.0f" ,RandomizeOptions[0])+"\n"+
                    "B. "+String.format("%.0f" ,RandomizeOptions[1])+"\n"+
                    "C. "+String.format("%.0f" ,RandomizeOptions[2])+"\n"+
                    "D. "+String.format("%.0f" ,RandomizeOptions[3])+"\n"+
                    "\n"+
                    "Correct Answer: ["+CorrectAnswer+"] "+String.format("%.0f", PromptAnswer)+"\n"+
                    "User Answer: "+((Skipped) ? "SKIPPED \n" : "["+UserAnswerCharacter+"] "+String.format("%.2f", UserAnswerNumber)+"\n") ; //... <=========== TERNARIES
        }


        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public boolean answerQuestion(char userAnswer) throws InvalidQuestionChoiceException, FinishQuizException, SkipQuizException {
            // SETTING IT UP
            UserAnswerCharacter = Character.toUpperCase(userAnswer);

            // PROCESSING THE USER ANSWER
            switch (UserAnswerCharacter) {
                case 'A':
                    UserAnswerNumber = RandomizeOptions[0]; // this is for printing out and showing what the user had picked (For logs)
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[0]; // If They are equal or not, return true or false.
                    break;
                case 'B':
                    UserAnswerNumber = RandomizeOptions[1]; // this is for printing out and showing what the user had picked (For logs)
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[1]; // If They are equal or not, return true or false.
                    break;
                case 'C':
                    UserAnswerNumber = RandomizeOptions[2]; // this is for printing out and showing what the user had picked (For logs)
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[2]; // If They are equal or not, return true or false.
                    break;
                case 'D':
                    UserAnswerNumber = RandomizeOptions[3]; // this is for printing out and showing what the user had picked (For logs)
                    AnsweredCorrectly = PromptAnswer == RandomizeOptions[3]; // If They are equal or not, return true or false.
                    break;
                case 'E':
                    Skipped = true;
                    AnsweredCorrectly = false;
                    throw new SkipQuizException();
                case 'F':
                    throw new FinishQuizException();
                default:
                    throw new InvalidQuestionChoiceException(); // WE ARE GOING TO NEED THIS WHEN SCANNING INPUTS IN THE MAIN METHOD. IF IT THROWS INVALID QUESTION, REPEAT TIL ITS VALID
            }

            // CHECK IF IT ANSWERED CORRECTLY
            return AnsweredCorrectly;
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayQuestion() {
            System.out.println("Question: "+Prompt+" = ??");
            if (Prompt.contains("/")) {
                System.out.println("A. "+String.format("%.2f" ,RandomizeOptions[0])) ;
                System.out.println("B. "+String.format("%.2f" ,RandomizeOptions[1]));
                System.out.println("C. "+String.format("%.2f" ,RandomizeOptions[2]));
                System.out.println("D. "+String.format("%.2f" ,RandomizeOptions[3]));
                System.out.println();
                System.out.println("E. Skip Question");
                System.out.println("F. End Quiz");
            } else {
                System.out.println("A. "+String.format("%.0f" ,RandomizeOptions[0])) ;
                System.out.println("B. "+String.format("%.0f" ,RandomizeOptions[1]));
                System.out.println("C. "+String.format("%.0f" ,RandomizeOptions[2]));
                System.out.println("D. "+String.format("%.0f" ,RandomizeOptions[3]));
                System.out.println();
                System.out.println("E. Skip Question");
                System.out.println("F. End Quiz");
            }
        }



        // ================================================== OTHER CLASSES ================================================== \\
    }
}
// TODO: DO TIME FOR LAST (I AM NOT GONNA DO THIS)
// TODO: IF YOU HAVE FREE TIME, ADD SOME MENU IN THE START (NOT NEEDED FOR LEARNING, ITS MORE OF JUST A UI THINGY)
// TODO: CHECK CLAUDE FOR BUG CHECKS (2/6)

// LESSON LEARNED: A class must be Serializeable before we can save and load the selected object.
// LESSON LEARNED: 'getClass()' only returns the metadata of the class.
// LESSON LEARNED: 'this' returns the current object/class
// LESSON LEARNED: A working directory determines where the file/folder will be created if you are not using absolute paths.