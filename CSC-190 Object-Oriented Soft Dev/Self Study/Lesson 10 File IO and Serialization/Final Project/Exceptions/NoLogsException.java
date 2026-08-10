package Exceptions;

public class NoLogsException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public NoLogsException() {
        super("There are currently no logs!");
    }
}
