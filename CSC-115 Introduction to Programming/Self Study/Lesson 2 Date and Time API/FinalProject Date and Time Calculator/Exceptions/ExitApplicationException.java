package Exceptions;

public class ExitApplicationException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ExitApplicationException() {
        super("User has exited the application!");
    }
}

// This is what needs to be thrown when a user decides to choose to exit the application.
// Note: i mean u can just click the close button but this is also just for fun practices.