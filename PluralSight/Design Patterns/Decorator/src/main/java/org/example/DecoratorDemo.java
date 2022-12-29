package org.example;

public class DecoratorDemo {
    public static void main(String[] args) {
        SandwichComponent sandwichComponent = new SandwichDecorator(
                new Ziet7arFolSandwichConcreteDecorator(
                        new T7enaFolSandwichConcreteDecorator(
                                new MkhalelFolSandwichConcreteDecorator(
                                        new FolSandwichConcreteComponent()
                                )
                        )
                )
        );
        System.out.println("sandwichComponent = " + sandwichComponent.makeSandwich());
    }
}