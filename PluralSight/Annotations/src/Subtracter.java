import annotations.CommandKeyword;
@CommandKeyword(name = "sub")
public class Subtracter extends MathProcessor {
    public Subtracter(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int doOperation() {
        return getNum1() - getNum2();
    }
}
