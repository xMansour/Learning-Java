package org.example;

public class Ziet7arFolSandwichConcreteDecorator extends SandwichDecorator {

    public Ziet7arFolSandwichConcreteDecorator(SandwichComponent sandwichComponent) {
        super(sandwichComponent);
    }

    public String makeSandwich() {
        return sandwichComponent.makeSandwich() + addZiet7ar();
    }

    private String addZiet7ar() {
        return " + Ziet7ar";
    }
}
