package org.example;

public class BridgeDemo {
    public static void main(String[] args) {
        Color red = new Red();
        Color green = new Green();
        Color blue = new Blue();


        Shape redCircle = new Circle();
        redCircle.applyColor(red);
        System.out.println();

        Shape greenSquare = new Square();
        greenSquare.applyColor(green);
        System.out.println();

    }
}