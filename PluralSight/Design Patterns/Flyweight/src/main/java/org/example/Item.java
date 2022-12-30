package org.example;


//instance of this class will be flyweights
public class Item {

    //everything here should be final and immutable -> no setters
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
