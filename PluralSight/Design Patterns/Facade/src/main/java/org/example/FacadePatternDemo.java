package org.example;

public class FacadePatternDemo {
    public static void main(String[] args) {

        int num1 = 5;
        int num2 = 6;


        //Implementation details is hidden by the Facade
        int sum = CalculationFacade.sum(num1, num2);
        System.out.println("sum = " + sum);

        int sub = CalculationFacade.sub(num1, num2);
        System.out.println("sub = " + sub);

        double div = CalculationFacade.div(num1, num2);
        System.out.println("div = " + div);

        int mul = CalculationFacade.mul(num1, num2);
        System.out.println("mul = " + mul);
    }
}