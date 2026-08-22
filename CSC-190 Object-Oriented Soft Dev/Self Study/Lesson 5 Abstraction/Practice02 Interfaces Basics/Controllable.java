public interface Controllable { // A TEMPLATE/CONTRACT THAT GIVES REQUIREMENTS FOR A CLASS
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    boolean isOn();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void turnOn();
    void turnOff();

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

}

// ReuseableMethods and Interface is static by default
