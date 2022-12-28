package org.example;

public class SingletonDemo {
    public static void main(String[] args) {
        //Singleton instance = new Singleton(); //error
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance2 = " + instance2);
    }
}