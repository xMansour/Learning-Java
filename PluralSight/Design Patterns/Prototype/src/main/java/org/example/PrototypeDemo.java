package org.example;

public class PrototypeDemo {
    public static void main(String[] args) {
        Registry registry = new Registry();

        Movie movie = (Movie) registry.createItem("movie");     //cloned object
        movie.setImdbRating("9.9/10");
        System.out.println("movie = " + movie);
        Movie movie2 = (Movie) registry.createItem("movie");    //cloned object
        System.out.println("movie2 = " + movie2);


        Book book = (Book) registry.createItem("book");         //cloned object
        book.setPrice("15$");
        System.out.println("book = " + book);
        Book book2 = (Book) registry.createItem("book");        //cloned object
        System.out.println("book2 = " + book2);


    }
}