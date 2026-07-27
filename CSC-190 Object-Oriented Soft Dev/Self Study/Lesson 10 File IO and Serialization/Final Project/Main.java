// Creation Date: July 25, 2026. at 10:05 PM
// Last Modified: July 26, 2026. at 10:28 PM

import Classes.BasicMathQuiz;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\
    static BasicMathQuiz BMQ01 = new BasicMathQuiz("Christ", 10);

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        
    }

    // =========================== METHODS =========================== \\
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