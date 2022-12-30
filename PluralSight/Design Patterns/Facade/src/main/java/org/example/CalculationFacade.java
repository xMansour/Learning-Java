package org.example;

//This class will just make the client simpler by containing the implementation details.
public class CalculationFacade {

    public static int sum(int num1, int num2) {
        //some bla bla bla
        //some other bla bla bla
        return num1 + num2;
    }

    public static int sub(int num1, int num2) {
        //a lot of bla bla bla
        return num1 - num2;
    }

    public static int div(int num1, int num2) {
        //bla bla bla...
        if (num2 != 0)
            return num1 / num2;
        else
            return 0;   //Whatttt!
    }

    public static int mul(int num1, int num2) {
        //bla bla
        return num1 * num2;
    }
}
