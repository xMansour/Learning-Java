package org.example;

public class T7enaFolSandwichConcreteDecorator extends SandwichDecorator {
    public T7enaFolSandwichConcreteDecorator(SandwichComponent sandwichComponent) {
        super(sandwichComponent);
    }

    public String makeSandwich() {
        return sandwichComponent.makeSandwich() + addT7ina();
    }

    private String addT7ina() {
        return " + T7ina";
    }
}
