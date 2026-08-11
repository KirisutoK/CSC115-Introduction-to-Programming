package Exceptions;

public class FinishQuizException extends Exception {
  //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
  public FinishQuizException() {
    super("Has finished the quiz (Skipped the rest of the question)");
  }
}
