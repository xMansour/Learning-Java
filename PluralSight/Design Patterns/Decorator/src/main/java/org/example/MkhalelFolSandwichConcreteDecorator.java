package org.example;

public class MkhalelFolSandwichConcreteDecorator extends SandwichDecorator{
    public MkhalelFolSandwichConcreteDecorator(SandwichComponent sandwichComponent) {
        super(sandwichComponent);
    }

    public String makeSandwich() {
        return sandwichComponent.makeSandwich() + addMkhalel();
    }

    private String addMkhalel() {
        return " + Mkhalel";
    }
}
