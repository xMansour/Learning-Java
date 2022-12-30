package org.example;

import java.util.HashMap;
import java.util.Map;


//this class acts as a factory for flyweight objects
public class ItemFlyweightFactory {
    private static Map<String, Item> items = new HashMap<>();

    //Factory method
    public static Item lookup(String itemName) {
        if (!items.containsKey(itemName))
            items.put(itemName, new Item(itemName));
        return items.get(itemName);
    }

    public static int totalItemsMade() {
        return items.size();
    }
}
