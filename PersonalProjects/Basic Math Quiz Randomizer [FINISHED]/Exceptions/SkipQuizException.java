package Exceptions;

public class SkipQuizException extends Exception {
  //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
  public SkipQuizException() {
    super("Skipped question");
  }
}
