package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlyweightPatternDemo {
    private static final List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        createOrder("TV", 1);
        createOrder("MackBook Pro", 2);
        createOrder("TV", 3);
        createOrder("Mug", 4);
        createOrder("TV", 5);
        createOrder("MackBook Pro", 6);

        processOrders();

        System.out.println(ItemFlyweightFactory.totalItemsMade());
    }


    //creates an order
    private static void createOrder(String itemName, int orderNumber) {
        Item item = ItemFlyweightFactory.lookup(itemName);
        Order order = new Order(orderNumber, item);
        orders.add(order);
    }


    //The below code throws the ConcurrentModificationException exception because you are modifying the list while iterating.
//    private static void processOrders() {
//        for (Order order : orders) {
//            order.processOrder();
//            orders.remove(order);
//        }
//    }


    private static void processOrders() {
        Iterator<Order> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            orderIterator.next().processOrder();
            orderIterator.remove();
        }
    }
}