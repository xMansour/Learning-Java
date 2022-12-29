package org.example;

public class CompositeDemo {
    public static void main(String[] args) {
        MenuComposite menuComposite = new MenuComposite("Main", "/main");   //composite

        MenuItemLeaf menuItemLeaf1 = new MenuItemLeaf("Play Multiplayer", "/playMultiplayer");  //leaf item
        MenuItemLeaf menuItemLeaf2 = new MenuItemLeaf("Play SinglePlayer", "/playSinglePlayer");  //leaf item
        MenuItemLeaf menuItemLeaf3 = new MenuItemLeaf("Settings", "/settings");  //leaf item
        MenuItemLeaf menuItemLeaf4 = new MenuItemLeaf("Exit", "/exit");  //leaf item

        menuComposite.addChild(menuItemLeaf1);
        menuComposite.addChild(menuItemLeaf2);
        menuComposite.addChild(menuItemLeaf3);
        menuComposite.addChild(menuItemLeaf4);

        System.out.println(menuComposite);  //printing the tree
    }
}