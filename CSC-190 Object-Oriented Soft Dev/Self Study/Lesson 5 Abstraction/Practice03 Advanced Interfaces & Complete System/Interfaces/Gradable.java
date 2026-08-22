package Interfaces;
import Classes.Course;

// Creation Date: February 27, 2026. at 9:10 PM
// Last Modified: August 21, 2026. at 11:34 PM

public interface Gradable { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    double getGPA();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void assignGrade(Course course, double grade);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// ReuseableMethods and Interface is static by default
