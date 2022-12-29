package org.example;

public class SandwichDecorator implements SandwichComponent{

    protected SandwichComponent sandwichComponent;    //this will be shared by all the decorators

    public SandwichDecorator(SandwichComponent sandwichComponent) { //composition
        this.sandwichComponent = sandwichComponent;
    }

    @Override
    public String makeSandwich() {
        return sandwichComponent.makeSandwich();
    }
}
