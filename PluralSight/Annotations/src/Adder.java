import annotations.CommandKeyword;
@CommandKeyword(name = "add")
public class Adder extends MathProcessor {
    public Adder(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int doOperation() {
        return getNum1() + getNum2();
    }
}
