import annotations.CommandKeyword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        doOperation(1, 2, "Add");
        doOperation(2, 2, "sub");
        doOperation(2, 4, "pow");

    }


    /**
     * PreConditions
     * This method is used to do operations in each operator independently of it's inherited type.
     * PostConditions
     * This method has no side effects.
     *
     * @param num1, first number for the operations add and sub and the base for the operation power.
     * @param num2, second number for the operations add and sub and the number num1 will be raised to in case of the power operation.
     * @param opCode, should be, add for addition operation, sub for subtract operation, or pow for a power operation.
     */
    private static void doOperation(int num1, int num2, String opCode) {
        /*
        MathProcessor[] processors = {new Adder(num1, num2), new Subtracter(num1, num2)};
        for (MathProcessor processor : processors) {
            CommandKeyword commandKeyword = processor.getClass().getAnnotation(CommandKeyword.class);
            String name = commandKeyword.name();
            if (name.equalsIgnoreCase(opCode))
                System.out.println(processor.doOperation());
        }
         */
        Object[] processors = {new Adder(num1, num2), new Subtracter(num1, num2), new Power()};
        for (Object processor : processors) {
            if (processor instanceof MathProcessor) {
                CommandKeyword commandKeyword = ((MathProcessor) processor).getClass().getAnnotation(CommandKeyword.class);
                String name = commandKeyword.name();
                if (name.equalsIgnoreCase(opCode))
                    System.out.println(((MathProcessor) processor).doOperation());
            } else {
                CommandKeyword commandKeyword = processor.getClass().getAnnotation(CommandKeyword.class);
                String name = commandKeyword.name();
                String methodSignature = commandKeyword.method();
                if (name.equalsIgnoreCase(opCode))
                    try {
                        Method calculateMethod = processor.getClass().getMethod(methodSignature, double.class, double.class);
                        System.out.println(calculateMethod.invoke(processor, num1, num2));
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

            }
        }
    }
}