package org.example;

public class MenuComposite extends MenuComponent {
    public MenuComposite(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void addChild(MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
    }

    public void removeChild(MenuComponent menuComponent) {
        if (this.menuComponents.contains(menuComponent))
            this.menuComponents.remove(menuComponent);
    }

    @Override
    public String toString() {
        return menuComponents.stream().map(MenuComponent::getUrl).reduce((current, next) -> current + next ).orElseThrow();
    }
}
