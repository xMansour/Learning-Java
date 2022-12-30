package org.example;


//this class isn't a part of the flyweight pattern
public class Order {
    private final int orderNumber;
    private final Item item;


    public Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    public void processOrder() {
        System.out.println("Ordering: " + this.item + " for order number: " + this.orderNumber);
    }
}
