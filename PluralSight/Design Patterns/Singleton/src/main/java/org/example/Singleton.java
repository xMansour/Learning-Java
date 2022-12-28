package org.example;

public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
        if (instance != null) { //to avoid instantiation throw reflection.
            throw new RuntimeException("Use the getInstance() method to instantiate an object");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) { //lazy loaded
            synchronized (Singleton.class) {    //thread safe
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
