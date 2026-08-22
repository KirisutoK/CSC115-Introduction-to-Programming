public interface Adjustable { // A Template/Contract that gives requirements for a class

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    int getTemperature();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void setTemperature(int temp);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// ReuseableMethods and Interface is static by default
