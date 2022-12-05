import annotations.CommandKeyword;

@CommandKeyword(name = "pow", method = "calculate")   //method = "calculate" is redundant since it's the default method value declared in the annotation
public class Power {


    public double calculate(double num, double pow) {
        return Math.pow(num, pow);
    }
}
