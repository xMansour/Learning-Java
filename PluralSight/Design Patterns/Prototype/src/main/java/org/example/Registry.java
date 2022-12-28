package org.example;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private final Map<String, Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }

    public Item createItem(String type) {
        try {
            return (Item) items.get(type).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;    //returning null isn't good practice
    }


    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setPrice("100$");
        movie.setDirectorName("Christopher Nolan");
        movie.setImdbRating("10/10 :D");
        items.put("movie", movie);

        Book book = new Book();
        book.setTitle("The 5 AM Club");
        book.setPrice("20$");
        book.setAuthorName("Robin Sharma");
        book.setNumberOfPages("350 Pages");
        items.put("book", book);

        System.out.println("Objects created using the new keyword only once.");
    }

}
