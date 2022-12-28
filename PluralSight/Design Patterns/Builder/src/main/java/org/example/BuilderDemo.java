package org.example;

public class BuilderDemo {
    public static void main(String[] args) {
        BreakfastOrder breakfastOrder = new BreakfastOrder.Builder().fol("2").ta3mia("3").build();
        System.out.println("breakfastOrder = " + breakfastOrder);

        BreakfastOrder.Builder builder = new BreakfastOrder.Builder();
        builder.fol("5 fol").bed("1 bed");
        BreakfastOrder order = builder.build();
        System.out.println("order = " + order);
    }
}