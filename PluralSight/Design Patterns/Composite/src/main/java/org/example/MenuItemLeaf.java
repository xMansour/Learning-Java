package org.example;

public class MenuItemLeaf extends MenuComponent {
    public MenuItemLeaf(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return this.print(this);
    }
}
