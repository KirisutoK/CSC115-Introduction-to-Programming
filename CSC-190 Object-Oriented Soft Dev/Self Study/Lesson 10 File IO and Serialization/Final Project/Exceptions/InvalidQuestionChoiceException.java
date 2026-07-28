package Exceptions;

public class InvalidQuestionChoiceException extends Exception {
  //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
  public InvalidQuestionChoiceException() {
    super("Please choose from A, B, C, D");
  }
}
